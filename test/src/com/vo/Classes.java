package com.vo;

public class Classes {
	private String mainclass;
	private String otherclass;
	public Classes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Classes(String mainclass, String otherclass) {
		super();
		this.mainclass = mainclass;
		this.otherclass = otherclass;
	}
	public String getMainclass() {
		return mainclass;
	}
	public void setMainclass(String mainclass) {
		this.mainclass = mainclass;
	}
	public String getOtherclass() {
		return otherclass;
	}
	public void setOtherclass(String otherclass) {
		this.otherclass = otherclass;
	}
	@Override
	public String toString() {
		return "Classes [mainclass=" + mainclass + ", otherclass=" + otherclass
				+ "]";
	}
	
	  
}
