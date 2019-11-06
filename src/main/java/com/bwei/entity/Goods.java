package com.bwei.entity;

public class Goods {

	private Integer gid;
	private String gname;
	private String gename;
	private Integer bid;
	private Integer sid;
	private Double size;
	private Double price;
	private Integer count;
	private String gset;
	private String img;
	
	
	//临时字段
    private String bname;
    private String sname;
	
	
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getGename() {
		return gename;
	}
	public void setGename(String gename) {
		this.gename = gename;
	}
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public Double getSize() {
		return size;
	}
	public void setSize(Double size) {
		this.size = size;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getGset() {
		return gset;
	}
	public void setGset(String gset) {
		this.gset = gset;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Goods(Integer gid, String gname, String gename, Integer bid, Integer sid, Double size, Double price,
			Integer count, String gset, String img) {
		super();
		this.gid = gid;
		this.gname = gname;
		this.gename = gename;
		this.bid = bid;
		this.sid = sid;
		this.size = size;
		this.price = price;
		this.count = count;
		this.gset = gset;
		this.img = img;
	}
	public Goods() {
		super();
	}
	@Override
	public String toString() {
		return "Goods [gid=" + gid + ", gname=" + gname + ", gename=" + gename + ", bid=" + bid + ", sid=" + sid
				+ ", size=" + size + ", price=" + price + ", count=" + count + ", gset=" + gset + ", img=" + img + "]";
	}
	
	
}
