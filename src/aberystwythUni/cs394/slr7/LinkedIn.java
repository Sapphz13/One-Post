package aberystwythUni.cs394.slr7;

import java.io.IOException;
import java.util.*;

import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.LinkedInApi;
import org.scribe.model.*;
import org.scribe.oauth.OAuthService;

public class LinkedIn 
{
	
	private String authUrl;
	private String postURL;
	

	public String getAuthUrl() 
	{
		return authUrl;
	}
	public void setAuthUrl(String authUrl) 
	{
		this.authUrl = authUrl;
	}
	public String getPostURL() 
	{
		return postURL;
	}
	public void setPostURL(String postURL) 
	{
		postURL="http://api.linkedin.com/v1/people/~/shares";
	}
	
	public void LinkedInAuth()

	{
		OAuthService service = new ServiceBuilder()
    						.provider(LinkedInApi.class)
    						.apiKey("mgg9e89meas7")
    						.apiSecret("9qzZ6xVgXRSaFsg2")
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

	public void LinkedInPostText()
	{
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost(postURL);
		
	    try 
	    {
	        // Add your data
	        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
	        nameValuePairs.add(new BasicNameValuePair("comment", "12345"));
	        nameValuePairs.add(new BasicNameValuePair("",""));
	        nameValuePairs.add(new BasicNameValuePair("",""));
	        nameValuePairs.add(new BasicNameValuePair("visability", "anyone/connections-only"));
	        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
	        
	        // Execute HTTP Post Request
	        HttpResponse response = httpclient.execute(httppost);
	    }
	    catch (ClientProtocolException e)
	    {
	        // TODO Auto-generated catch block
	    } catch (IOException e) 
	    {
	        // TODO Auto-generated catch block
	    }
		
	/*	<?xml version="1.0" encoding="UTF-8"?>
	*	<share>
	*	  <comment>83% of employers will use social media to hire: 78% LinkedIn, 55% Facebook, 45% Twitter [SF Biz Times] http://bit.ly/cCpeOD</comment>
	*	  <content>
	*		 <title>Survey: Social networks top hiring tool - San Francisco Business Times</title>
	*		 <submitted-url>http://sanfrancisco.bizjournals.com/sanfrancisco/stories/2010/06/28/daily34.html</submitted-url>
	*		 <submitted-image-url>http://images.bizjournals.com/travel/cityscapes/thumbs/sm_sanfrancisco.jpg</submitted-image-url>
	*	  </content>
	*	  <visibility>
	*		 <code>anyone</code>
	*	  </visibility>
	*	</share>
	*/
	}

	
}
