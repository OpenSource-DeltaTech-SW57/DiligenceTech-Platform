package com.deltatech.diligencetech.platform.profiles.domain.model.commands;

public record CreateAgentCommand(String username, String email, String password, String imageUrl, String firstname, String lastName, String location) {


}
