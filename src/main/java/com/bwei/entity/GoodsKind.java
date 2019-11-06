package com.bwei.entity;

public class GoodsKind {

	private Integer sid;
	private String sname;
	private Integer bid;
	
	
	@Override
	public String toString() {
		return "GoodsKind [sid=" + sid + ", sname=" + sname + ", bid=" + bid + "]";
	}
	public GoodsKind() {
		super();
	}
	public GoodsKind(Integer sid, String sname, Integer bid) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.bid = bid;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	
}
