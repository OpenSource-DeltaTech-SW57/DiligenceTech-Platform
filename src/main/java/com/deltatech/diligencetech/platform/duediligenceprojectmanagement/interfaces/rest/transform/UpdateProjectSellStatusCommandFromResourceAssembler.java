package com.deltatech.diligencetech.platform.duediligenceprojectmanagement.interfaces.rest.transform;

import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.commands.UpdateProjectSellStatusCommand;

public class UpdateProjectSellStatusCommandFromResourceAssembler {
    public static UpdateProjectSellStatusCommand toCommandFromResource(Long projectId, String sellStatus) {
        return new UpdateProjectSellStatusCommand(projectId, sellStatus);
    }
}
