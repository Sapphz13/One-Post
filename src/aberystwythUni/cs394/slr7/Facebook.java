package aberystwythUni.cs394.slr7;

import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.FacebookApi;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

public class Facebook 
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
	
	public void FacebookAuth()
	{
		OAuthService service = new ServiceBuilder()
    						.provider(FacebookApi.class)
    						.apiKey("221493037917200")
    						.apiSecret("4ceceb71cd6a91fb4251a04d5d71089f")
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
	public void FacebookPostText()
	{
		
	}
	public void FacebookPostNote()
	{
	/*	You can comment on a Note by issuing an HTTP POST request 
	*	to NOTE_ID/comments with the publish_stream permission and 
	*	the user_notes or friends_notes permission as appropriate,
	*	using the following parameters.
	*/	
	}
	public void FacebookPostPhoto()
	{
		
	}
	

}
