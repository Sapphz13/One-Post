package aberystwythUni.cs394.slr7;

import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.FlickrApi;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

public class Flickr 
{
	
	private String authUrl;

	public String getAuthUrl() 
	{
		return authUrl;
	}
	public void setAuthUrl(String authUrl) 
	{
		this.authUrl = authUrl;
	}
	
	public void FlickrAuth()
	{
		OAuthService service = new ServiceBuilder()
    						.provider(FlickrApi.class)
    						.apiKey("your_api_key")
    						.apiSecret("your_api_secret")
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
	public void FlickrPostPhoto()
	{
		
	}
	public void FlickrPostPhotoComment()
	{
		
	}

}
