package aberystwythUni.cs394.slr7;

import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.*;
import org.scribe.model.*;
import org.scribe.model.Response;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

public class TwitterAuth
{
		
	private String authUrl;

	public TwitterAuth()
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

	public String getAuthUrl() {
		return authUrl;
	}

	public void setAuthUrl(String authUrl) {
		this.authUrl = authUrl;
	}

}
