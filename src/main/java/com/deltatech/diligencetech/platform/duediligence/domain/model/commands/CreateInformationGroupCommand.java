package com.deltatech.diligencetech.platform.duediligence.domain.model.commands;

public record CreateInformationGroupCommand(boolean obligatory, String groupIdentifier, String name, String priority, String buySideStatus, String sellSideStatus) {
    public CreateInformationGroupCommand {

    }
}
