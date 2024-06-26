package com.deltatech.diligencetech.platform.communications.application.internal.queryservices;

import com.deltatech.diligencetech.platform.communications.domain.model.aggregates.Email;
import com.deltatech.diligencetech.platform.communications.domain.model.queries.GetAllEmailsQuery;
import com.deltatech.diligencetech.platform.communications.domain.model.queries.GetEmailByIdQuery;
import com.deltatech.diligencetech.platform.communications.domain.model.queries.GetEmailByReceiverEmailQuery;
import com.deltatech.diligencetech.platform.communications.domain.model.queries.GetEmailBySenderEmailQuery;
import com.deltatech.diligencetech.platform.communications.domain.services.EmailQueryService;
import com.deltatech.diligencetech.platform.communications.infrastructure.persistence.jpa.repositories.EmailRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmailQueryServiceImpl implements EmailQueryService {

    private final EmailRepository emailRepository;

    public EmailQueryServiceImpl(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    @Override
    public List<Email> handle(GetAllEmailsQuery query) {
        return emailRepository.findAll();
    }
    @Override
    public Optional<Email> handle (GetEmailByIdQuery query) {
        return emailRepository.findById(query.emailId());
    }

    @Override
    public List<Email> handle(GetEmailBySenderEmailQuery query) {
        return emailRepository.findBySenderEmail(query.senderEmail());
    }

    @Override
    public List<Email> handle(GetEmailByReceiverEmailQuery query) {
        return emailRepository.findByReceiverEmail(query.receiverEmail());
    }

}
