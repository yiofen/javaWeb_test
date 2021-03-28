package entity;
/**
 * 管理员类
 * @author Mr.Yu
 *
 */
public class Admin {
	private String uid;
	private String uname;
	private String asex;
	private String apwd;
	private String rname;
	
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getAsex() {
		return asex;
	}
	public void setAsex(String asex) {
		this.asex = asex;
	}
	public String getApwd() {
		return apwd;
	}
	public void setApwd(String apwd) {
		this.apwd = apwd;
	}
	
	public Admin() {
	}
	
	@Override
	public String toString() {
		return "Admin [uid=" + uid + ", uname=" + uname + ", asex=" + asex + ", apwd=" + apwd + ", rname=" + rname
				+ "]";
	}
}
