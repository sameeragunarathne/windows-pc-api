package org.wso2.carbon.mdm.mobileservices.windows.services.push.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.wso2.carbon.mdm.mobileservices.windows.services.push.beans.OAuthToken;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class WNSAuthenticator {

    private static final String AUTHENTICATION_URL = "https://login.live.com/accesstoken.srf";

    public static OAuthToken getAccessToken(String secret, String sId) throws UnsupportedEncodingException, MalformedURLException {

        String urlEncodedSecret = URLEncoder.encode(secret, "UTF-8");
        String urlEncodedSid = URLEncoder.encode(sId, "UTF-8");

        String body = getMessegeBody(urlEncodedSecret, urlEncodedSid);
        URL url = new URL(AUTHENTICATION_URL);
        String jsonResponse = sendPost(url, body);

        return getOAuthTokenFromJson(jsonResponse);
    }

    public static String sendPost(){
        return null;
    }

    private static OAuthToken getOAuthTokenFromJson(String jsonString) {
        Gson gson = new GsonBuilder().create();
        OAuthToken authToken = gson.fromJson(jsonString, OAuthToken.class);
        return authToken;
    }

    private static String getMessegeBody(String encodedSecret, String encodedSid) {

        String messegeBody = "grant_type=client_credentials&client_id=" + encodedSid + "&client_secret=" + encodedSecret + "&scope=notify.windows.com";
        return messegeBody;
    }

    private static String sendPost(URL url, String body) {

        String jsonResponse = "";
        DataOutputStream writer;
        BufferedReader input;

        try {
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Host", "https://login.live.com");
            connection.setRequestProperty("Content-Length", "211");

            connection.setDoOutput(true);
            writer = new DataOutputStream(connection.getOutputStream());
            writer.writeBytes(body);
            writer.flush();
            writer.close();

            input = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = input.readLine()) != null) {
                response.append(inputLine);
            }
            input.close();
            jsonResponse = response.toString();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
        return jsonResponse;
    }
}
