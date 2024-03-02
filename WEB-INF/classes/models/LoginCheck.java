package models;

import java.io.*;
import java.util.*;
import beans.*;

public class LoginCheck {
	public static boolean checkName(List<User> usrs, User usr) {
		User chName = serchSameName(usrs,usr);
		if (chName == null) {
			return false;
		}else {
			return true;
		}
	}
	public static boolean execute(List<User> usrs, User usr) {
		User beforeUsr = serchSameName(usrs,usr);
		if (beforeUsr.equals(usr)) {
			return true;
		}else {
			return false;
		}
	}
	protected static User serchSameName(List<User> usrs, User usr) {
		for (User u : usrs) {
			if (usr.getName().equals(u.getName()))
				return u;
		}
		return null;
	}
}
