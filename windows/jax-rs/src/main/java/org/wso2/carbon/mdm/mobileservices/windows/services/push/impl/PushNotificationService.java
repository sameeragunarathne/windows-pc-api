package org.wso2.carbon.mdm.mobileservices.windows.services.push.impl;


import org.wso2.carbon.mdm.mobileservices.windows.services.push.beans.OAuthToken;
import org.wso2.carbon.mdm.mobileservices.windows.services.push.util.WNSAuthenticator;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

public class PushNotificationService {

    public void pushToWns(String secret, String sId, String uri, String payload, String notificationType, String contentType) {

        try {
            OAuthToken authToken = WNSAuthenticator.getAccessToken(secret, sId);

        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }catch(MalformedURLException e){
            e.printStackTrace();
        }
    }
}
