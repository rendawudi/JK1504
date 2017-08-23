package com.jk1504.enums;


public enum userStatEnum {
	SUCCESS(1,"×¢²á³É¹¦"),
	ZCSB(0,"×¢²áÊ§°Ü"),
	DLSB(-1,"µÇÂ½Ê§°Ü"),
	USERSB(-2,"ÕËºÅÏà¹ØÒì³£")
	;
	private int state;
	private String stateinfo;
	private userStatEnum(int state, String stateinfo) {
		this.state = state;
		this.stateinfo = stateinfo;
	}
	public int getState() {
		return state;
	}
	public String getStateinfo() {
		return stateinfo;
	}
	
	public static userStatEnum stateof(int index)
	{
		for(userStatEnum stat:values())
		{
			if (stat.getState()==index) {
				return stat;
			}
		}
		return null;
	}
}
