package com.s3xygod.assignmentfinalmob201_ph12682;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.s3xygod.database.AdapterKhoaHoc;
import com.s3xygod.database.KhoaHoc;
import com.s3xygod.database.SQLKhoaHoc;
import com.s3xygod.database.SQLKhoaSan;

import java.io.Serializable;
import java.util.List;

public class CourseActivity extends AppCompatActivity {
    Button xoa;
    ListView lwDaDk;
    List<KhoaHoc> lstKhoaDK;
    SQLKhoaHoc sql = new SQLKhoaHoc(this);
    SQLKhoaSan sql1 = new SQLKhoaSan(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        xoa = findViewById(R.id.bnt_del);
        lwDaDk = findViewById(R.id.lw_ds);

//        KhoaDK();
        KhoaSan();

        lstKhoaDK = sql.getall();
        AdapterKhoaHoc adapterKhoaHoc = new AdapterKhoaHoc(lstKhoaDK);
        lwDaDk.setAdapter(adapterKhoaHoc);

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    public void openAdd(View view) {
        Intent intent = new Intent(this, AddActivity.class);
        startActivity(intent);

    }
    public void KhoaDK(){
        KhoaHoc khoaHoc = new KhoaHoc("K01", "IT");
        KhoaHoc khoaHoc2 = new KhoaHoc("K02", "Toan");
        KhoaHoc khoaHoc3 = new KhoaHoc("K03", "Van");
        sql.addKhoaHoc(khoaHoc);
        sql.addKhoaHoc(khoaHoc2);
        sql.addKhoaHoc(khoaHoc3);
    }
    public void KhoaSan(){
        KhoaHoc khoaHoc = new KhoaHoc("K01", "IT");
        KhoaHoc khoaHoc2 = new KhoaHoc("K02", "Toan");
        KhoaHoc khoaHoc3 = new KhoaHoc("K03", "Van");
        KhoaHoc khoaHoc4 = new KhoaHoc("K04", "LTMT");
        KhoaHoc khoaHoc5 = new KhoaHoc("K05", "TKTW");
        KhoaHoc khoaHoc6 = new KhoaHoc("K06", "QTKD");
        if (sql.check(khoaHoc)){
            sql1.addKhoaHoc(khoaHoc);
        }
        if (sql.check(khoaHoc2)) {
            sql1.addKhoaHoc(khoaHoc2);
        }
        if (sql.check(khoaHoc3)) {
            sql1.addKhoaHoc(khoaHoc3);
        }
        if (sql.check(khoaHoc4)){
            sql1.addKhoaHoc(khoaHoc4);
        }
        if (sql.check(khoaHoc5)) {
            sql1.addKhoaHoc(khoaHoc5);
        }
        if (sql.check(khoaHoc6)) {
            sql1.addKhoaHoc(khoaHoc6);
        }
    }
}