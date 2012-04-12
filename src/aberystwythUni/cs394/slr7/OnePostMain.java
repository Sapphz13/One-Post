package aberystwythUni.cs394.slr7;


import java.util.ArrayList;

import android.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class OnePostMain extends Activity
{
	private String postType;
	
	public String getPostType()
	{
		return postType;
	}
	public void setPostType()
	{
		postType="text";
	}
	public void setPostTypePhoto()
	{
		postType="photo";
	}
	public void setPostTypeAudio()
	{
		postType="audio";
	}
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        
        Button aButton = (Button) findViewById(R.id.splashButton);
        aButton.setOnClickListener(new View.OnClickListener() 
        {
			@Override
			public void onClick(View v) 
			{
				setContentView(R.layout.main);
			}
		});
        
        setPostType();
        Button bButton =(Button) findViewById(R.id.addImage);
        bButton.setOnClickListener(new View.OnClickListener() 
        {
			@Override
			public void onClick(View v) 
			{
				setPostTypePhoto();
			}
		});
        
        Button cButton=(Button) findViewById(R.id.addAudio);
        cButton.setOnClickListener(new View.OnClickListener() 
        {
			@Override
			public void onClick(View v) 
			{
				setPostTypeAudio();
			}
		});
    
        Button dButton=(Button) findViewById(R.id.postButton);
        dButton.setOnClickListener(new View.OnClickListener() 
        {
			@Override
			public void onClick(View v) 
			{
				if (postType == "text")
				{
					Posting.PostText();
				}
				if (postType == "photo")
				{
					Posting.PostPhoto();
				}
				if (postType == "audio")
				{
					Posting.PostAudio();
				}
			}
		});
    
    }

}

