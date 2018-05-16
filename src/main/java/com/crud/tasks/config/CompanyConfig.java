package com.crud.tasks.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class CompanyConfig {
    @Value("CodeLab")
    private String companyName;
    @Value("office@codeLab.com")
    private String companyMail;
    @Value("+48225912377")
    private String companyPhone;
}
