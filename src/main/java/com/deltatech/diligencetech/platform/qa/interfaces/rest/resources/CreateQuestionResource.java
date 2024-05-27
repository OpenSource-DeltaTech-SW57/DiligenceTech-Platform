package com.deltatech.diligencetech.platform.qa.interfaces.rest.resources;



public record CreateQuestionResource(String buySideStatus,
                                     String sellSideStatus,
                                     int number,
                                     String content) {
}
