package com.jk1504.entity;

public class Ceshi
{
    Integer timuid;
    Integer taskid;
    String timujson;
    Integer qtype;
    Integer num;
    Integer errornum;
    float errorpercent;

    public Integer getErrornum() {
        return errornum;
    }

    public void setErrornum(Integer errornum) {
        this.errornum = errornum;
    }

    public Integer getTimuid()
    {
        return timuid;
    }
    public void setTimuid(Integer timuid)
    {
        this.timuid = timuid;
    }
    public Integer getTaskid()
    {
        return taskid;
    }
    public void setTaskid(Integer taskid)
    {
        this.taskid = taskid;
    }
    public String getTimujson()
    {
        return timujson;
    }
    public void setTimujson(String timujson)
    {
        this.timujson = timujson;
    }

    public Integer getQtype() {
        return qtype;
    }

    public void setQtype(Integer qtype) {
        this.qtype = qtype;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public float getErrorpercent() {
        return errorpercent;
    }

    public void setErrorpercent(float errorpercent) {
        this.errorpercent = errorpercent;
    }
}