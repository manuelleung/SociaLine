package main.java.com;

import java.io.File;

public interface SocialNetwork {

	void Authenticate();
	
	void PostMessage(String message);
	
	void PostLink(String message);

	void getNewsFeed();
	
	void uploadPicture(File pic, String PhotoName);
		
}
