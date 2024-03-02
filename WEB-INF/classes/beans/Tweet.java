package beans;

import java.io.*;
import java.util.*;


public class Tweet implements Serializable {
	private User	usr;
	private String	tweet;

	public Tweet(User usr, String tweet) {
		this.usr = usr;
		this.tweet = tweet;
	}
	public Tweet() {;}

	public User getUsr() { return this.usr; }
	public String getTweet() { return this.tweet; }

	public void setUsr(User usr) { this.usr = usr; }
	public void setTweet(String tweet) { this.tweet = tweet; }

	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Tweet)) return false;
		Tweet obj = (Tweet)o;
		if (this.usr.equals(obj.usr) && this.tweet.equals(obj.tweet))
			return true;
		return false;
	}
}
