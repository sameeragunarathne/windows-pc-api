package org.wso2.carbon.mdm.mobileservices.windows.services.push.beans;

public class OAuthToken {

    private String access_token;
    private String token_type;

    public String getAccessToken() {
        return access_token;
    }

    public void setAccessToken(String accessToken) {
        this.access_token = accessToken;
    }


    public String getTokenType() {
        return token_type;
    }

    public void setTokenType(String tokenType) {
        this.token_type = tokenType;
    }


}
