package com.deltatech.diligencetech.platform.iam.application.internal.commandservices;

<<<<<<< HEAD
import com.deltatech.diligencetech.platform.iam.application.internal.outboundservices.acl.ExternalAgentIamService;
=======
import com.deltatech.diligencetech.platform.iam.application.internal.outboundservices.acl.ExternalAgentServiceForIam;
>>>>>>> 50c506ee37cf2ee0e4d7f65bf3b4f566d28ed2ef
import com.deltatech.diligencetech.platform.iam.application.internal.outboundservices.hashing.HashingService;
import com.deltatech.diligencetech.platform.iam.application.internal.outboundservices.tokens.TokenService;
import com.deltatech.diligencetech.platform.iam.domain.model.aggregates.User;
import com.deltatech.diligencetech.platform.iam.domain.model.commands.SignInCommand;
import com.deltatech.diligencetech.platform.iam.domain.model.commands.SignUpCommand;
import com.deltatech.diligencetech.platform.iam.domain.services.UserCommandService;
import com.deltatech.diligencetech.platform.iam.infrastructure.persistence.jpa.repositories.RoleRepository;
import com.deltatech.diligencetech.platform.iam.infrastructure.persistence.jpa.repositories.UserRepository;
import com.deltatech.diligencetech.platform.profiles.infrastructure.persistence.jpa.repositories.AgentRepository;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserCommandServiceImpl implements UserCommandService {

    private final UserRepository userRepository;
    private final HashingService hashingService;
    private final TokenService tokenService;
    private final RoleRepository roleRepository;
<<<<<<< HEAD
    private final ExternalAgentIamService externalAgentIamService;

    public UserCommandServiceImpl(UserRepository userRepository, HashingService hashingService, TokenService tokenService, RoleRepository roleRepository, ExternalAgentIamService externalAgentIamService, AgentRepository agentRepository) {
=======
    private final ExternalAgentServiceForIam externalAgentServiceForIam;

    public UserCommandServiceImpl(UserRepository userRepository, HashingService hashingService, TokenService tokenService, RoleRepository roleRepository, ExternalAgentServiceForIam externalAgentServiceForIam) {
>>>>>>> 50c506ee37cf2ee0e4d7f65bf3b4f566d28ed2ef
        this.userRepository = userRepository;
        this.hashingService = hashingService;
        this.tokenService = tokenService;
        this.roleRepository = roleRepository;
<<<<<<< HEAD
        this.externalAgentIamService = externalAgentIamService;
=======
        this.externalAgentServiceForIam = externalAgentServiceForIam;
>>>>>>> 50c506ee37cf2ee0e4d7f65bf3b4f566d28ed2ef
    }

    @Override
    public Optional<User> handle(SignUpCommand command) {
        var agentId = externalAgentIamService.fetchAgentIdByEmail(command.email());
        if(agentId.isEmpty()) {
            agentId = externalAgentIamService.createAgent(command.username(), command.email(),  command.firstname(), command.lastName());
        } else {
            userRepository.findByAgentId(agentId.get()).ifPresent(agent -> {
                throw new IllegalArgumentException("User already exists");
            });
        }
        if (agentId.isEmpty()) {
            throw new IllegalArgumentException("Unable to create Agent");
        }

        //if (userRepository.existsByUsername(command.username()))
        //    throw new RuntimeException("Username already exists");
        var roles = command.roles().stream().map(role -> roleRepository.findByName(role.getName())
                .orElseThrow(() -> new RuntimeException("Role not found"))).toList();

        //var user = new User(command.username(), hashingService.encode(command.password()), roles);
        //userRepository.save(user);
        var user = new User(command.email(), hashingService.encode(command.password()), agentId.get().agentId());
        userRepository.save(user);
<<<<<<< HEAD
        return userRepository.findByEmail(command.email());
=======
        // Create profile of that user
        externalAgentServiceForIam.createAgent(command.username(), command.username(), command.username(), "secret", "");
        // return the iam user
        return userRepository.findByUsername(command.username());
>>>>>>> 50c506ee37cf2ee0e4d7f65bf3b4f566d28ed2ef
    }

    @Override
    public Optional<ImmutablePair<User, String>> handle(SignInCommand command) {
        var user = userRepository.findByEmail(command.email())
                .orElseThrow(() -> new RuntimeException("User not found"));
        if (!hashingService.matches(command.password(), user.getPassword()))
            throw new RuntimeException("Invalid password");
        var token = tokenService.generateToken(user.getUserEmail());
        return Optional.of(new ImmutablePair<>(user, token));
    }
}
