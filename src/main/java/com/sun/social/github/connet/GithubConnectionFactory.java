
package com.sun.social.github.connet;

import com.sun.social.github.api.Github;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;

public class GithubConnectionFactory extends OAuth2ConnectionFactory<Github> {

	public GithubConnectionFactory(String providerId, String appId, String appSecret) {
		super(providerId, new GithubServiceProvider(appId, appSecret), new GithubAdapter());
	}

}
