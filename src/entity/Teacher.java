package entity;
/**
 * 老师类
 * @author Mr.Yu
 *
 */
public class Teacher {
	private String uid;
	private String uname;
	private String tsex;
	private String tpwd;
	private String tsubject;//老师对应的学科
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
	public String getTsex() {
		return tsex;
	}
	public void setTsex(String tsex) {
		this.tsex = tsex;
	}
	public String getTpwd() {
		return tpwd;
	}
	public void setTpwd(String tpwd) {
		this.tpwd = tpwd;
	}
	public String getTsubject() {
		return tsubject;
	}
	public void setTsubject(String tsubject) {
		this.tsubject = tsubject;
	}
	
	public Teacher() {
	}

	@Override
	public String toString() {
		return "Teacher [uid=" + uid + ", uname=" + uname + ", tsex=" + tsex + ", tpwd=" + tpwd + ", tsubject="
				+ tsubject + ", rname=" + rname + "]";
	}
}
