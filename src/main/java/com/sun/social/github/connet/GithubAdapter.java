package com.sun.social.github.connet;

import com.sun.social.github.api.Github;
import com.sun.social.github.api.GithubUserInfo;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

public class GithubAdapter implements ApiAdapter<Github> {

	@Override
	public boolean test(Github api) {
		return true;
	}

	@Override
	public void setConnectionValues(Github api, ConnectionValues values) {
		GithubUserInfo userInfo = api.getUserInfo();
		System.out.println(userInfo.toString());
		values.setDisplayName(userInfo.getName());
		values.setImageUrl(userInfo.getAvatar_url());
		values.setProfileUrl(null);
		values.setProviderUserId(userInfo.getId() + "");
	}

	@Override
	public UserProfile fetchUserProfile(Github api) {
		return null;
	}

	@Override
	public void updateStatus(Github api, String message) {
		//do noting
	}

}
