package com.sun.social;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.support.OAuth2Connection;
import org.springframework.stereotype.Component;

@Component
public class CustomConnectionSignUp implements ConnectionSignUp {

    @Override
    public String execute(Connection<?> connection) {
        OAuth2Connection conn = (OAuth2Connection) connection;
        return conn.getKey().getProviderUserId();
    }
}
