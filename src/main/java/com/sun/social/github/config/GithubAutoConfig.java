package com.sun.social.github.config;

import com.sun.properties.SpringSocialProperties;
import com.sun.social.github.connet.GithubConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;

@Configuration
@ConditionalOnProperty(prefix = "security.social.github", name = "app-id")
public class GithubAutoConfig extends SocialAutoConfigurerAdapter {

	@Autowired
	private SpringSocialProperties springSocialProperties;

	@Override
	protected ConnectionFactory<?> createConnectionFactory() {
		return new GithubConnectionFactory(springSocialProperties.getGithub().getProviderId(), springSocialProperties.getGithub().getAppId(), springSocialProperties.getGithub().getAppSecret());
	}

}
