package org.example.controller;

import org.example.service.ApplicationService;

public class ApplicationController {
    private final ApplicationService applicationService = new ApplicationService();

    public void startPage(){
        applicationService.startPage();
    }
    public void greeting(){
        applicationService.greeting();
    }


}
