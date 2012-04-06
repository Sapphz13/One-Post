package aberystwythUni.cs394.slr7;

import java.util.ArrayList;

public class Posting 
{
	//private emun photo, audio, text;
	private String link;
	
	
	public String getLink() {
		return link;
	}


	public void setLink(String link) {
		this.link = link;
	}


	public ArrayList<String> PostPhoto()
	{
		ArrayList<String> photoLinks = new ArrayList<String>();
	/*	scale photo
	*	upload to twitpic
	*		flickr
	*		Google+
	*		Facebook
	*		LinkedIn
	*	upload link to Twitter*/
		return photoLinks; 

	}
//?Preferred photo site
//upload to preference
//title+link to other sites   <- flickr/twitpic? mutulaly exclusive


	public ArrayList<String> PostAudio()
	{
			ArrayList<String> audioLinks = new ArrayList<String>();
/*			if (audio.length < limit)
	*			upload to AudioBoo(title + audio)
	*			return link;
	*			audioLinks.add(0, link)
	*				upload title + link to Twitter
	*					to Facebook
	*					to Google+
	*					to LinkedIn  */
				return audioLinks;
	}

	public ArrayList<String> PostText()
	{
		ArrayList<String> text = new ArrayList<String>();
		ArrayList<String> textLinks = new ArrayList<String>();
		if (text.size() < 140)
		{
	/*		upload  to Twitter
	*			to facebook status
	*			to Google+
	*			to LinkedIn*/
			return textLinks;
		}
		if (text.size() >140 && text.size() <500)
		{
	/*		upload  to facebook status
	*			to Google+
	*			to LinkedIn
	*		upload 100 chars + link to Twitter*/
			return textLinks;
		}
		if (text.size() >500 && text.size() <700)
		{
	/*		upload to LinkedIn
	*		  	Google+
	*		  upload 100 chars + link to Twitter
	*			 	to Facebook*/
			return textLinks;
		}
		if (text.size() >700)
		{
	/*		upload to Google+
	*		upload 100 chars + link to Twitter
	*				to Facebook
	*				to LinkedIn*/
			return textLinks;
		}
		return null;
	}
}
