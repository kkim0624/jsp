package kr.or.ddit.member.model;

public class MemberVo {
	
	private String mem_id;
	private String mem_pass;
	private String mem_name;
	private String mem_regno1;
	private String mem_regno2;
	
	public MemberVo() {

	}
	
	public MemberVo(String mem_id, String mem_pass, String mem_name,
			String mem_regno1, String mem_regno2) {
		super();
		this.mem_id = mem_id;
		this.mem_pass = mem_pass;
		this.mem_name = mem_name;
		this.mem_regno1 = mem_regno1;
		this.mem_regno2 = mem_regno2;
	}
	
	@Override
	public String toString() {
		return "MemberVo [mem_id=" + mem_id + ", mem_pass=" + mem_pass
				+ ", mem_name=" + mem_name + ", mem_regno1=" + mem_regno1
				+ ", mem_regno2=" + mem_regno2 + "]";
	}

	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pass() {
		return mem_pass;
	}
	public void setMem_pass(String mem_pass) {
		this.mem_pass = mem_pass;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_regno1() {
		return mem_regno1;
	}
	public void setMem_regno1(String mem_regno1) {
		this.mem_regno1 = mem_regno1;
	}
	public String getMem_regno2() {
		return mem_regno2;
	}
	public void setMem_regno2(String mem_regno2) {
		this.mem_regno2 = mem_regno2;
	}

}
