package com.jk1504.entity;

import java.util.List;

public class DaanPut
{
    Usertask usertask;
    List<Daan> daans;
    public Usertask getUsertask()
    {
        return usertask;
    }
    public void setUsertask(Usertask usertask)
    {
        this.usertask = usertask;
    }
    public List<Daan> getDaans()
    {
        return daans;
    }
    public void setDaans(List<Daan> daans)
    {
        this.daans = daans;
    }


}