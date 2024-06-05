package com.deltatech.diligencetech.platform.communications.domain.model.valueobjects;


import com.deltatech.diligencetech.platform.communications.domain.model.aggregates.Message;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Embeddable
public class AnswersList {


    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<Message> answers;

    public AnswersList(){
      this.answers = new ArrayList<>();
    }

}
