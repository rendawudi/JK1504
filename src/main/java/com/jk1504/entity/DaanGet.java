package com.jk1504.entity;

public class DaanGet {
    Integer timuid;//需要前端填充timuid,stuid
    Integer stuid;
    Boolean rightdaan;//对错

    public Integer getTimuid() {
        return timuid;
    }

    public void setTimuid(Integer timuid) {
        this.timuid = timuid;
    }

    public Integer getStuid() {
        return stuid;
    }

    public void setStuid(Integer stuid) {
        this.stuid = stuid;
    }

    public Boolean getRightdaan() {
        return rightdaan;
    }

    public void setRightdaan(Boolean rightdaan) {
        this.rightdaan = rightdaan;
    }
}
