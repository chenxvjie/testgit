package com.vo;

public class Buyer {
  private String buyername;
  private String buyerid;
  private String buyerpw;
  private String buyeraddress;
  private String buyerphone;
  private String buyersex;
public String getBuyername() {
	return buyername;
}
public void setBuyername(String buyername) {
	this.buyername = buyername;
}
public String getBuyerid() {
	return buyerid;
}
public void setBuyerid(String buyerid) {
	this.buyerid = buyerid;
}
public String getBuyerpw() {
	return buyerpw;
}
public void setBuyerpw(String buyerpw) {
	this.buyerpw = buyerpw;
}
public String getBuyeraddress() {
	return buyeraddress;
}
public void setBuyeraddress(String buyeraddress) {
	this.buyeraddress = buyeraddress;
}
public String getBuyerphone() {
	return buyerphone;
}
public void setBuyerphone(String buyerphone) {
	this.buyerphone = buyerphone;
}
public String getBuyersex() {
	return buyersex;
}
public void setBuyersex(String buyersex) {
	this.buyersex = buyersex;
}
public Buyer(String buyername, String buyerid, String buyerpw, String buyeraddress, String buyerphone,
		String buyersex) {
	super();
	this.buyername = buyername;
	this.buyerid = buyerid;
	this.buyerpw = buyerpw;
	this.buyeraddress = buyeraddress;
	this.buyerphone = buyerphone;
	this.buyersex = buyersex;
}
public Buyer() {
	super();
	// TODO Auto-generated constructor stub
}

}
