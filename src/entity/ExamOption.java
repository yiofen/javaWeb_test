package entity;
/**
 * 题库类
 * @author Mr.Yu
 *
 */
public class ExamOption {
	private int eid;
	private String etitle;
	private String ea;
	private String eb;
	private String ec;
	private String ed;
	private String ekey;
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEtitle() {
		return etitle;
	}
	public void setEtitle(String etitle) {
		this.etitle = etitle;
	}
	public String getEa() {
		return ea;
	}
	public void setEa(String ea) {
		this.ea = ea;
	}
	public String getEb() {
		return eb;
	}
	public void setEb(String eb) {
		this.eb = eb;
	}
	public String getEc() {
		return ec;
	}
	public void setEc(String ec) {
		this.ec = ec;
	}
	public String getEd() {
		return ed;
	}
	public void setEd(String ed) {
		this.ed = ed;
	}
	public String getEkey() {
		return ekey;
	}
	public void setEkey(String ekey) {
		this.ekey = ekey;
	}
	
	public ExamOption(int eid, String etitle, String ea, String eb, String ec, String ed, String ekey) {
		this.eid = eid;
		this.etitle = etitle;
		this.ea = ea;
		this.eb = eb;
		this.ec = ec;
		this.ed = ed;
		this.ekey = ekey;
	}
	
	public ExamOption(int eid) {
		this.eid = eid;
	}
	
	public ExamOption(int eid, String etitle) {
		this.eid = eid;
		this.etitle = etitle;
	}
	
	public ExamOption() {
	}
}
