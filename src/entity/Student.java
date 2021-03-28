package entity;

/**
 * 学生类
 * @author Mr.Yu
 *
 */
public class Student {
	private String sid;//学号--登陆账号
	private int sgrade;//年级
	private float sscore;//考试分数
	private String sname;//姓名
	private String ssex;//性别
	private String scollege;//学院
	private String sprofe;//专业
	private String spwd;//登陆密码
	
	public float getSscore() {
		return sscore;
	}
	public void setSscore(float sscore) {
		this.sscore = sscore;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public int getSgrade() {
		return sgrade;
	}
	public void setSgrade(int sgrade) {
		this.sgrade = sgrade;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSsex() {
		return ssex;
	}
	public void setSsex(String ssex) {
		this.ssex = ssex;
	}
	public String getScollege() {
		return scollege;
	}
	public void setScollege(String scollege) {
		this.scollege = scollege;
	}
	public String getSprofe() {
		return sprofe;
	}
	public void setSprofe(String sprofe) {
		this.sprofe = sprofe;
	}
	public String getSpwd() {
		return spwd;
	}
	public void setSpwd(String spwd) {
		this.spwd = spwd;
	}
	
	public Student(String sid, int sgrade, String sname, String ssex, String scollege, String sprofe, String spwd) {
		super();
		this.sid = sid;
		this.sgrade = sgrade;
		this.sname = sname;
		this.ssex = ssex;
		this.scollege = scollege;
		this.sprofe = sprofe;
		this.spwd = spwd;
	}
	
	public Student(String sid, String spwd) {
		this.sid = sid;
		this.spwd = spwd;
	}
	
	public Student(String sid, float sscore) {
		super();
		this.sid = sid;
		this.sscore = sscore;
	}
	
	public Student(String sid) {
		this.sid = sid;
	}
	
	public Student() {
	}
}