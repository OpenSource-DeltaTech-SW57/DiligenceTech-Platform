package com.deltatech.diligencetech.platform.iam.domain.services;

import com.deltatech.diligencetech.platform.iam.domain.model.entities.Role;
import com.deltatech.diligencetech.platform.iam.domain.model.queries.GetAllRolesQuery;
import com.deltatech.diligencetech.platform.iam.domain.model.queries.GetRoleByIdQuery;

import java.util.List;
import java.util.Optional;

public interface RoleQueryService {
    List<Role> handle(GetAllRolesQuery query);
    Optional<Role> handle(GetRoleByIdQuery query);
}
