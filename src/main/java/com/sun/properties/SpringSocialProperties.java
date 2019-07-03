package com.sun.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "security.social")
public class SpringSocialProperties {
    private String filterProcessesUrl = "/auth";

    private QQSocialProperties qq = new QQSocialProperties();

    private GithubSocialProperties github = new GithubSocialProperties();
}
