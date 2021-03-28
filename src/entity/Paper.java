package entity;

/**
 * 试卷类
 * @author Mr.Yu
 *
 */
public class Paper {
	private int pid;
	private String pname;//试卷名
	private int ecount;//试卷题目数量
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public int getEcount() {
		return ecount;
	}
	public void setEcount(int ecount) {
		this.ecount = ecount;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
}
