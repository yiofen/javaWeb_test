package entity;
/**
 * 错题类
 * @author Mr.Yu
 *
 */
public class ErrorExam {
	
	private int eid;
	private String etitle;
	private String ea;
	private String eb;
	private String ec;
	private String ed;
	private String ekey;
	private String pname;

	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	private String studkey;
	
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
	public String getStudkey() {
		return studkey;
	}
	public void setStudkey(String studkey) {
		this.studkey = studkey;
	}
	
	public ErrorExam() {
	}
	
	@Override
	public String toString() {
		return "ErrorExam [eid=" + eid + ", etitle=" + etitle + ", ea=" + ea + ", eb=" + eb + ", ec=" + ec + ", ed="
				+ ed + ", ekey=" + ekey + ", pname=" + pname + ", studkey=" + studkey + "]";
	}
}
