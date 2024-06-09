package com.deltatech.diligencetech.platform.duediligenceagents.interfaces.rest.transform;

import com.deltatech.diligencetech.platform.duediligenceagents.domain.model.commands.UpdateAgentUsernameCommand;

public class UpdateAgentUsernameCommandFromResourceAssembler
{
    public static UpdateAgentUsernameCommand toCommandFromResource(Long agentId, String username) {
        return new UpdateAgentUsernameCommand(agentId, username);
    }
}