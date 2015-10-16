package main.java.com.Facebook;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import facebook4j.BatchAttachment;
import facebook4j.BatchRequest;
import facebook4j.BatchRequests;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Media;
import facebook4j.Post;
import facebook4j.ResponseList;
import facebook4j.conf.ConfigurationBuilder;
import facebook4j.internal.http.RequestMethod;
import main.java.Application.Config;
import main.java.com.SocialNetwork;

public class FacebookHandler implements SocialNetwork{

	private ConfigurationBuilder cb = new ConfigurationBuilder();

	private FacebookFactory ff;

	private Facebook facebook;
	

	public FacebookHandler(){
		//setting the config
		cb.setDebugEnabled(true)
		  .setOAuthAppId(Config.FACEBOOK_APP_ID)
		  .setOAuthAppSecret(Config.FACEBOOK_APP_SECRET)
		  .setOAuthAccessToken("**************************************************")
		  .setOAuthPermissions("email,publish_stream,read_mailbox,read_page_mailboxes,read_stream");
		
		ff = new FacebookFactory(cb.build());
		
		facebook = ff.getInstance();
		
	}

	@Override
	public void Authenticate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void PostMessage(String message) {
		try {
			facebook.postStatusMessage(message);
		} catch (FacebookException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void PostLink(String message) {
		try {
			facebook.postLink(new URL(message));
		} catch (MalformedURLException | FacebookException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void getNewsFeed() {
		try {
			ResponseList<Post> feed = facebook.getFeed();
		} catch (FacebookException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void uploadPicture(File pic, String PhotoName) {
		BatchRequests<BatchRequest> batch = new BatchRequests<BatchRequest>();
		Media file = new Media(pic);
		BatchAttachment attachment = new BatchAttachment(PhotoName, file);
		batch.add(new BatchRequest(RequestMethod.POST, "me/photos")
		              .body("message=" + PhotoName)
		              .attachedFile(attachment));
	}
	
	

}
