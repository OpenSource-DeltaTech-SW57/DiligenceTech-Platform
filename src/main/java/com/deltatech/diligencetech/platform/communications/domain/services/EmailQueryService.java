package com.deltatech.diligencetech.platform.communications.domain.services;

import com.deltatech.diligencetech.platform.communications.domain.model.aggregates.Email;
import com.deltatech.diligencetech.platform.communications.domain.model.queries.GetAllEmailsQuery;
import com.deltatech.diligencetech.platform.communications.domain.model.queries.GetEmailByIdQuery;
import com.deltatech.diligencetech.platform.communications.domain.model.queries.GetEmailByReceiverIdQuery;
import com.deltatech.diligencetech.platform.communications.domain.model.queries.GetEmailBySenderIdQuery;

import java.util.List;
import java.util.Optional;


public interface EmailQueryService {

    List<Email> handle(GetAllEmailsQuery query);
    Optional<Email> handle(GetEmailByIdQuery query);
    List<Email> handle(GetEmailBySenderIdQuery query);
    List<Email> handle(GetEmailByReceiverIdQuery query);
}
