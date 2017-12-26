package com.jk1504.entity;

public class jsdto
{
	 public String code = "1";
	    //成功或者异常信息
	    public String msg = "success";
	    //数据体
	    public Object data;

	    public String getCode() {
	        return code;
	    }

	    public void setCode(String code) {
	        this.code = code;
	    }

	    public String getMsg() {
	        return msg;
	    }

	    public void setMsg(String msg) {
	        this.msg = msg;
	    }

	    public Object getData() {
	        return data;
	    }

	    public void setData(Object data) {
	        this.data = data;
	    }
}
