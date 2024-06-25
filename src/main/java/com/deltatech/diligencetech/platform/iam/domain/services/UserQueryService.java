package com.deltatech.diligencetech.platform.iam.domain.services;

import com.deltatech.diligencetech.platform.iam.domain.model.aggregates.User;
import com.deltatech.diligencetech.platform.iam.domain.model.queries.GetAllUsersQuery;
import com.deltatech.diligencetech.platform.iam.domain.model.queries.GetUserByIdQuery;
import com.deltatech.diligencetech.platform.iam.domain.model.queries.GetUserByEmailQuery;

import java.util.List;
import java.util.Optional;

public interface UserQueryService {
    List<User> handle(GetAllUsersQuery query);
    Optional<User> handle(GetUserByIdQuery query);
    Optional<User> handle(GetUserByEmailQuery query);
}
