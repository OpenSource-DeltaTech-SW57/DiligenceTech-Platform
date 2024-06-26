package com.deltatech.diligencetech.platform.duediligenceprojectmanagement.interfaces.rest.transform;

import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.commands.UpdateProjectCompletedCommand;

public class UpdateProjectCompletedCommandFromResourceAssembler {
    public static UpdateProjectCompletedCommand toCommandFromResource(Long projectId, Boolean completed) {
        return new UpdateProjectCompletedCommand(projectId, completed);
    }
}
