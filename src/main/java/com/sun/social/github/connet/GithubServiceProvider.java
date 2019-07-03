package com.sun.social.github.connet;

import com.sun.social.github.api.Github;
import com.sun.social.github.api.GithubImpl;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;

public class GithubServiceProvider extends AbstractOAuth2ServiceProvider<Github> {

	private static final String URL_AUTHORIZE = "https://github.com/login/oauth/authorize";
	
	private static final String URL_ACCESS_TOKEN = "https://github.com/login/oauth/access_token";
	
	public GithubServiceProvider(String appId, String appSecret) {
		super(new GithubOAuth2Template(appId, appSecret, URL_AUTHORIZE, URL_ACCESS_TOKEN));
	}
	
	@Override
	public Github getApi(String accessToken) {
		return new GithubImpl(accessToken);
	}

}
