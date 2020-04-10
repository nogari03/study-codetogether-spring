package com.codetogether.auth;

import com.github.scribejava.apis.GoogleApi20;
import com.github.scribejava.core.builder.api.DefaultApi20;

import lombok.Data;

@Data
public class SnsDTO implements SnsUrl {

	private String service;
	private String clientId;
	private String clientSecret;
	private String redirectUrl;
	private DefaultApi20 api20Instance;
	private String profileUrl;

	private boolean isNaver;
	private boolean isGoogle;

	public SnsDTO(String service, String clientId, String clientSecret, String redirectUrl) {
		this.service = service;
		this.clientId = clientId;
		this.clientSecret = clientSecret;
		this.redirectUrl = redirectUrl;

		this.isNaver = this.service.equalsIgnoreCase("naver");
		this.isGoogle = this.service.equalsIgnoreCase("google");

		if(isNaver) {
			this.api20Instance = NaverAPI20.Instance();
			this.profileUrl = NAVER_PROFILE_URL;

		} else if(isGoogle) {
			this.api20Instance = GoogleApi20.instance();
			this.profileUrl = GOOGLE_PROFILE_URL;

		}
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	public DefaultApi20 getApi20Instance() {
		return api20Instance;
	}

	public void setApi20Instance(DefaultApi20 api20Instance) {
		this.api20Instance = api20Instance;
	}

	public String getProfileUrl() {
		return profileUrl;
	}

	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}

	public boolean isNaver() {
		return isNaver;
	}

	public void setNaver(boolean isNaver) {
		this.isNaver = isNaver;
	}

	public boolean isGoogle() {
		return isGoogle;
	}

	public void setGoogle(boolean isGoogle) {
		this.isGoogle = isGoogle;
	}

}
