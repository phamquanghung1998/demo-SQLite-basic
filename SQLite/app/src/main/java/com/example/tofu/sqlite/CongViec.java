package com.example.tofu.sqlite;

public class CongViec {
    private int IdCV;
    private String TenCV;

    public CongViec(int idCV,String tenCV){
        this.IdCV = idCV;
        this.TenCV =tenCV;

    }

    public int getIdCV() {
        return IdCV;
    }

    public void setIdCV(int idCV) {
        IdCV = idCV;
    }

    public String getTenCV() {
        return TenCV;
    }

    public void setTenCV(String tenCV) {
        TenCV = tenCV;
    }
}
