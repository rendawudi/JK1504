package com.jk1504.entity;

public class Daan
{
    Integer taskid;//前端需要填taskid,stuid
    String stuid;
    String qtime;
    float correctpercent;

    public Integer getTaskid() {
        return taskid;
    }

    public void setTaskid(Integer taskid) {
        this.taskid = taskid;
    }

    public String getStuid() {
        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid;
    }

    public String getQtime() {
        return qtime;
    }

    public void setQtime(String qtime) {
        this.qtime = qtime;
    }

    public float getCorrectpercent() {
        return correctpercent;
    }

    public void setCorrectpercent(float correctpercent) {
        this.correctpercent = correctpercent;
    }
}