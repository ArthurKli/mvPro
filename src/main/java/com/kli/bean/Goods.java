package com.kli.bean;

public class Goods extends BaseEntity<Goods>{
	private int gid;
	private String goodsName;
	private int goodsCount;
	private String goodsCode;
	
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getGoodsCount() {
		return goodsCount;
	}
	public void setGoodsCount(int goodsCount) {
		this.goodsCount = goodsCount;
	}
	public String getGoodsCode() {
		return goodsCode;
	}
	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}
	@Override
	public String toString() {
		return "Goods [gid=" + gid + ", goodsName=" + goodsName
				+ ", goodsCount=" + goodsCount + ", goodsCode=" + goodsCode
				+ "]";
	}

	
	
}
