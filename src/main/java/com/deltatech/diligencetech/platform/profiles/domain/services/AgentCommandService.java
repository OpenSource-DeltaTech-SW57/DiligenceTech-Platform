package com.deltatech.diligencetech.platform.profiles.domain.services;

import com.deltatech.diligencetech.platform.profiles.domain.model.aggregates.Agent;
import com.deltatech.diligencetech.platform.profiles.domain.model.commands.CreateAgentCommand;
import com.deltatech.diligencetech.platform.profiles.domain.model.commands.DeleteAgentCommand;
import com.deltatech.diligencetech.platform.profiles.domain.model.commands.UpdateAgentBiographyAndProfilePicCommand;
import com.deltatech.diligencetech.platform.profiles.domain.model.commands.UpdateAgentUsernameCommand;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface AgentCommandService {
    Long handle(CreateAgentCommand command);
    void handle(DeleteAgentCommand command);
    Optional<Agent> handle(UpdateAgentBiographyAndProfilePicCommand command);
    Optional<Agent> handle(UpdateAgentUsernameCommand command);

}
