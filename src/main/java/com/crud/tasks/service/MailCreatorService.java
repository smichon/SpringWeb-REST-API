package com.crud.tasks.service;

import com.crud.tasks.config.CompanyConfig;
import com.crud.tasks.trello.config.AdminConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;

@Service
public class MailCreatorService {

    @Autowired
    private AdminConfig adminConfig;
    @Autowired
    private CompanyConfig companyConfig;

    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    public String buildTrelloCardEmail(String message) {

        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("preview", "Tasks: New Trello card");
        context.setVariable("tasks_url", "http://localhost/tasks_frontend/");
        context.setVariable("button", "Visit website");
        context.setVariable("admin_config", adminConfig);
        context.setVariable("goodbye", "Thank You  for using our Application");
        context.setVariable("company", companyConfig.getCompanyName() +
                companyConfig.getCompanyMail() + " tel.: " + companyConfig.getCompanyPhone());
        context.setVariable("show_button", false);
        context.setVariable("is_friend", false);
        context.setVariable("application_functionality", getfunctionality());
        return templateEngine.process("mail/created-trello-card-mail", context);
    }

    public String buildTaskCardEmail(String message) {
        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("preview", "Tasks in base");
        context.setVariable("tasks_url", "http://localhost/tasks_frontend/");
        context.setVariable("button", "Visit website");
        context.setVariable("admin_config", adminConfig);
        context.setVariable("goodbye", "Thank You  for using our Application");
        context.setVariable("company", companyConfig.getCompanyName() +
                companyConfig.getCompanyMail() + " tel.: " + companyConfig.getCompanyPhone());
        context.setVariable("show_button", false);
        context.setVariable("is_friend", false);
        context.setVariable("application_functionality", getfunctionality());
        return templateEngine.process("mail/created-task-card-mail",context);
    }

    public List<String> getfunctionality() {

        List<String> functionality = new ArrayList<>();
        functionality.add("You can manage your tasks");
        functionality.add("Provides connection with Trello Account");
        functionality.add("Application allows sending tasks to Trello");
        return functionality;
    }
}
