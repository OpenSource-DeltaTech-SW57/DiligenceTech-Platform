package com.deltatech.diligencetech.platform.duediligenceprojectmanagement.interfaces.rest.transform;

import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.commands.UpdateProjectBuyStatusCommand;

public class UpdateProjectBuyStatusCommandFromResourceAssembler {
    public static UpdateProjectBuyStatusCommand toCommandFromResource(Long projectId, String buyStatus) {
        return new UpdateProjectBuyStatusCommand(projectId, buyStatus);
    }
}
