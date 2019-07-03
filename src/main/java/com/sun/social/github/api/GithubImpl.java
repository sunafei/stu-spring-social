package com.sun.social.github.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;

public class GithubImpl extends AbstractOAuth2ApiBinding implements Github {
	private static final String URL_GET_USERINFO = "https://api.github.com/user";
	private ObjectMapper objectMapper = new ObjectMapper();
	
	public GithubImpl(String accessToken) {
		super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);
	}
	
	@Override
	public GithubUserInfo getUserInfo() {
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("Authorization", appId);
	    String result = getRestTemplate().getForObject(URL_GET_USERINFO, String.class);
		try {
			return objectMapper.readValue(result, GithubUserInfo.class);
		} catch (Exception e) {
			throw new RuntimeException("获取用户信息失败", e);
		}
	}

}
