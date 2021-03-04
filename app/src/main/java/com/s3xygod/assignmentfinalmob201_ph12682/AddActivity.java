package com.s3xygod.assignmentfinalmob201_ph12682;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import com.s3xygod.database.AdapterKhoaCoSan;
import com.s3xygod.database.KhoaHoc;
import com.s3xygod.database.SQLKhoaHoc;
import com.s3xygod.database.SQLKhoaSan;

import java.util.List;

public class AddActivity extends AppCompatActivity {
    Button add;
    ListView lwThem;
    List<KhoaHoc> lstKhoaSan;
    SQLKhoaSan sql = new SQLKhoaSan(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        add = findViewById(R.id.bnt_add);
        lwThem = findViewById(R.id.lw_dsThem);

        lstKhoaSan = sql.getall();
        AdapterKhoaCoSan adapterKhoaCoSan = new AdapterKhoaCoSan(lstKhoaSan);
        lwThem.setAdapter(adapterKhoaCoSan);

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(), CourseActivity.class);
        startActivity(intent);
    }
}