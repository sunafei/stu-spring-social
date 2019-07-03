package com.sun.properties;

import lombok.Data;
import org.springframework.boot.autoconfigure.social.SocialProperties;

@Data
public class QQSocialProperties extends SocialProperties {
    private String providerId;
}
