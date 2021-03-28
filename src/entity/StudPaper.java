package entity;

public class StudPaper {
	private String sid;
	private String spid;
	private int eid;
	private String studkey;
	private int studstate;
	private String pname;
	private int rightcount;//正确的题数
	private int errorcount;//错误的题数
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getSpid() {
		return spid;
	}
	public void setSpid(String spid) {
		this.spid = spid;
	}
	public int getRightcount() {
		return rightcount;
	}
	public void setRightcount(int rightcount) {
		this.rightcount = rightcount;
	}
	public int getErrorcount() {
		return errorcount;
	}
	public void setErrorcount(int errorcount) {
		this.errorcount = errorcount;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getStudkey() {
		return studkey;
	}
	public void setStudkey(String studkey) {
		this.studkey = studkey;
	}
	public int getStudstate() {
		return studstate;
	}
	public void setStudstate(int studstate) {
		this.studstate = studstate;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}

	public StudPaper() {
	}
	
	@Override
	public String toString() {
		return "StudPaper [sid=" + sid + ", spid=" + spid + ", eid=" + eid + ", studkey=" + studkey + ", studstate="
				+ studstate + ", pname=" + pname + ", rightcount=" + rightcount + ", errorcount=" + errorcount + "]";
	}
}