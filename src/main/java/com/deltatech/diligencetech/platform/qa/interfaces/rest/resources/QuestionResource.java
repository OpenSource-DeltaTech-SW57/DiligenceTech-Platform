package com.deltatech.diligencetech.platform.qa.interfaces.rest.resources;

public record QuestionResource( Long id,
                                String buySideStatus,
                                String sellSideStatus,
                                int number,
                                String content) {
}
