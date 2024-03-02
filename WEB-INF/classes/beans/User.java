package beans;

import java.io.*;

public class User implements Serializable {
	private String	name;
	private String	pwd;

	public User(String name, String pwd) {
		this.name = name;
		this.pwd = pwd;
	}
	public User() {
		this("dummy","dummy");
	}

	public String getName() { return this.name; }
	public String getPwd() { return this.pwd; }

	public void setName(String name) { this.name = name; }
	public void setPwd(String pwd) { this.pwd = pwd; }

	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (!(obj instanceof User)) return false;
		User usr = (User)obj;
		if (this.name.equals(usr.name) && this.pwd.equals(usr.pwd)) {
			return true;
		}
		return false;
	}
}
