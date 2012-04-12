package aberystwythUni.cs394.slr7;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.*;
import org.scribe.model.*;
import org.scribe.oauth.OAuthService;

public class Twitter
{
		
	private String authUrl;
	private String requestURI;

	public String getAuthUrl() 
	{
		return authUrl;
	}
	public void setAuthUrl(String authUrl) 
	{
		this.authUrl = authUrl;
	}
	
	public String getRequestURI() 
	{
		return requestURI;
	}
	public void setRequestURI(String requestURI) 
	{
		requestURI="https://api.twitter.com/1/statuses/update.json";
	}

	
	public void TwitterAuth()
	{
		OAuthService service = new ServiceBuilder()
    						.provider(TwitterApi.class)
    						.apiKey("33cBV5cf3bJUUf02JhR7w")
    						.apiSecret("Be0iQbItz3ReQqyHyKxzKTW63hk1OoKdk8xCfmqD8")
    						.build();

		Token requestToken = service.getRequestToken();
	
		setAuthUrl(service.getAuthorizationUrl(requestToken));
	
		Verifier verifier = new Verifier("verifier you got from the user");
		Token accessToken = service.getAccessToken(requestToken, verifier); // the requestToken you had from step 2
	
		OAuthRequest request = new OAuthRequest(Verb.GET, "http://api.twitter.com/1/account/verify_credentials.xml");
		service.signRequest(accessToken, request); // the access token from step 4
		Response response = request.send();
		System.out.println(response.getBody());
	}

	public void TwitterPostText()
	{
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost(requestURI);
		
	    try 
	    {
	        // Add your data
	        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
	        nameValuePairs.add(new BasicNameValuePair("status", "12345"));
	        nameValuePairs.add(new BasicNameValuePair("truncated", "true/false"));
	        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
	        
	        // Execute HTTP Post Request
	        HttpResponse response = httpclient.execute(httppost);
	    }
	    catch (ClientProtocolException e)
	    {
	        // TODO Auto-generated catch block
	    } 
	    catch (IOException e) 
	    {
	        System.out.println("oops something went worng with the IO");
	    }
	}

}
