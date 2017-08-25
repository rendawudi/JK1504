package com.jk1504.enums;


public enum userStatEnum {
	SUCCESS(1,"ע��ɹ�"),
	ZCSB(0,"ע��ʧ��"),
	DLSB(-1,"��½ʧ��"),
	USERSB(-2,"�˺�����쳣")
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
