package com.deltatech.diligencetech.platform.duediligenceprojectmanagement.interfaces.rest.resources;

//old
//public record ProjectResource(Long id, String name, String managerName, String status) {
//}

//new
public record ProjectResource(Long id, String projectName) {}
