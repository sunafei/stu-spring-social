package com.sun.social.qq.config;

import com.sun.properties.SpringSocialProperties;
import com.sun.social.qq.connet.QQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;

@Configuration
@ConditionalOnProperty(prefix = "security.social.qq", name = "app-id")
public class QQAutoConfig extends SocialAutoConfigurerAdapter {

	@Autowired
	private SpringSocialProperties springSocialProperties;

	@Override
	protected ConnectionFactory<?> createConnectionFactory() {
		return new QQConnectionFactory(springSocialProperties.getQq().getProviderId(), springSocialProperties.getQq().getAppId(), springSocialProperties.getQq().getAppSecret());
	}

}
