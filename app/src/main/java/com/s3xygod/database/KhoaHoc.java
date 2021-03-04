package com.s3xygod.database;

public class KhoaHoc {
    public String id, ten;

    public KhoaHoc() {
    }

    public KhoaHoc(String id, String ten) {
        this.id = id;
        this.ten = ten;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

}
