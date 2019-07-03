package com.sun.social;

import com.sun.properties.SpringSocialProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.mem.InMemoryUsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.social.security.SpringSocialConfigurer;

@Order(1)
@Configuration
@EnableSocial
public class SocialConfig extends SocialConfigurerAdapter {

	@Autowired
	private ConnectionSignUp customConnectionSignUp;

	@Autowired
	private SpringSocialProperties springSocialProperties;

	@Override
	public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
		InMemoryUsersConnectionRepository repository = new InMemoryUsersConnectionRepository(connectionFactoryLocator);
		if(customConnectionSignUp != null) {
			repository.setConnectionSignUp(customConnectionSignUp);
		}
		return repository;
	}

	@Bean
	public SpringSocialConfigurer socialSecurityConfig() {
		String filterProcessesUrl = springSocialProperties.getFilterProcessesUrl();
		CustomSpringSocialConfigurer configurer = new CustomSpringSocialConfigurer(filterProcessesUrl);
		configurer.signupUrl("/signUp");
		return configurer;
	}

	@Bean
	public ProviderSignInUtils providerSignInUtils(ConnectionFactoryLocator connectionFactoryLocator) {
		return new ProviderSignInUtils(connectionFactoryLocator,
				getUsersConnectionRepository(connectionFactoryLocator)) {
		};
	}
}
