package com.jk1504.entity;

import java.util.List;

public class DaanPut
{
    Daan daan;
    List<DaanGet> daans;

    public Daan getDaan() {
        return daan;
    }

    public void setDaan(Daan daan) {
        this.daan = daan;
    }

    public List<DaanGet> getDaans() {
        return daans;
    }

    public void setDaans(List<DaanGet> daans) {
        this.daans = daans;
    }
}