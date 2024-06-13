package servlet;

import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import model.FacebookAccount;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;






public class FacebookLogin {
	public static String getToken(String code) throws ClientProtocolException, IOException {
        String response = Request.Post(contanst.LoginFacebook.FACEBOOK_LINK_GET_TOKEN)
                .bodyForm(
                        Form.form()
       .add("client_id", contanst.LoginFacebook.FACEBOOK_CLIENT_ID)
                        .add("client_secret", contanst.LoginFacebook.FACEBOOK_CLIENT_SECRET)
                        .add("redirect_uri", contanst.LoginFacebook.FACEBOOK_REDIRECT_URI)
                        .add("code", code)
                        .build()
                )
                .execute().returnContent().asString();
        JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
        String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
        return accessToken;
    }
    
    public static FacebookAccount getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
        String link = contanst.LoginFacebook.FACEBOOK_LINK_GET_USER_INFO + accessToken;
        String response = Request.Get(link).execute().returnContent().asString();
        FacebookAccount facebookAcc = new Gson().fromJson(response, FacebookAccount.class);
        return facebookAcc;
    }
}
