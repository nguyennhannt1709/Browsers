package com.ngh.huuduc197.myapplication;

/**
 * Created by huuduc on 13/05/2018.
 */

public class getSet {
    public getSet() {
        Idlink = Idlink;
        Tenlink = Tenlink;
    }

    private int Idlink;
    private String Tenlink;

    public int getIdCV() {
        return Idlink;
    }

    public String getTenCV() {
        return Tenlink;
    }

    public void setIdCV(int idCV) {
        Idlink = idCV;
    }

    public void setTenCV(String tenCV) {
        Tenlink = tenCV;
    }
}
