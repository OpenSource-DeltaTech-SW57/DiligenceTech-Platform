package com.deltatech.diligencetech.platform.profiles.domain.exceptions;

public class AgentNotFoundException extends RuntimeException{
    public AgentNotFoundException(Long aLong) {
        super("Agent with id " + aLong + " not found");
    }
}
