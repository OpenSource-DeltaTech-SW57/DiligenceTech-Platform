package com.deltatech.diligencetech.platform.iam.domain.services;

import com.deltatech.diligencetech.platform.iam.domain.model.commands.SeedRolesCommand;

public interface RoleCommandService {
    void handle(SeedRolesCommand command);
}
