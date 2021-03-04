package com.s3xygod.assignmentfinalmob201_ph12682;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.Layout;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();
                int cho = 0;
                while (cho < 2000){
                    try {
                        sleep(1000);
                    }
                    catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    cho += 700;
                }
                Intent i = new Intent(MainActivity.this,HomeActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(i);
                finish();
            }
        };
        thread.start();
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this,"Không thể Back ở màn hình này.\nVui lòng chờ giây lát",Toast.LENGTH_LONG).show();
    }
}