package main.java.com.Facebook;

import facebook4j.Facebook;
import facebook4j.FacebookFactory;
import facebook4j.conf.ConfigurationBuilder;
import main.java.Application.Config;
import main.java.com.Network;

public class FacebookHandler implements Network{


	public FacebookHandler(){
		//setting the config
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		  .setOAuthAppId(Config.FACEBOOK_APP_ID)
		  .setOAuthAppSecret(Config.FACEBOOK_APP_SECRET)
		  .setOAuthAccessToken("**************************************************")
		  .setOAuthPermissions("email,publish_stream,...");
		FacebookFactory ff = new FacebookFactory(cb.build());
		
		Facebook facebook = ff.getInstance();
		
		
		
	}
	
	@Override
	public void Authenticate() {
		
	}

	@Override
	public void Post() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getPosts() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getComments() {
		// TODO Auto-generated method stub
		
	}

}
