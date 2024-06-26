package com.deltatech.diligencetech.platform.duediligenceprojectmanagement.interfaces.rest.transform;

import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.commands.UpdateProjectConfirmCommand;

public class UpdateProjectConfirmCommandFromResourceAssembler {
    public static UpdateProjectConfirmCommand toCommandFromResource(Long projectId, Boolean confirm) {
        return new UpdateProjectConfirmCommand(projectId, confirm);
    }
}
