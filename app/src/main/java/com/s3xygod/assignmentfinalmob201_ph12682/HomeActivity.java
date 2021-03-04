package com.s3xygod.assignmentfinalmob201_ph12682;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class HomeActivity extends AppCompatActivity {
    ImageView imageView, course, news, map, page, web;
    TextView txtCourse, txtNews, txtMap, txtPage, txtWeb;
    Animation animation, animation2;
    private long pressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        imageView = findViewById(R.id.logo);
        course = findViewById(R.id.img_course);
        txtCourse = findViewById(R.id.txt_course);
        news = findViewById(R.id.img_news);
        txtNews = findViewById(R.id.txt_news);
        map = findViewById(R.id.img_map);
        txtMap = findViewById(R.id.txt_map);
        page = findViewById(R.id.img_page);
        txtPage = findViewById(R.id.txt_page);
        web = findViewById(R.id.img_web);
        txtWeb = findViewById(R.id.txt_web);

        animation_in();
    }

    @Override
    public void onBackPressed() {
        if (pressedTime + 2000 > System.currentTimeMillis()) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            Intent startMain = new Intent(Intent.ACTION_MAIN);
            startMain.addCategory(Intent.CATEGORY_HOME);
            startActivity(startMain);
            finish();
        } else {
            Toast.makeText(getBaseContext(), "Nhấn phím Back thêm 1 lần nữa để thoát", Toast.LENGTH_SHORT).show();
        }
        pressedTime = System.currentTimeMillis();
    }


    public void animation_in(){
        animation = AnimationUtils.loadAnimation(this, R.anim.slide_down);
        imageView.startAnimation(animation);
        animation2 = AnimationUtils.loadAnimation(this, R.anim.move_in);
        course.startAnimation(animation2);
        txtCourse.startAnimation(animation2);
        news.startAnimation(animation2);
        txtNews.startAnimation(animation2);
        map.startAnimation(animation2);
        txtMap.startAnimation(animation2);
        page.startAnimation(animation2);
        txtPage.startAnimation(animation2);
        web.startAnimation(animation2);
        txtWeb.startAnimation(animation2);
    }
    public void animation_out(){
        animation = AnimationUtils.loadAnimation(this, R.anim.slide_up);
        imageView.startAnimation(animation);
        animation2 = AnimationUtils.loadAnimation(this, R.anim.move_out);
        course.startAnimation(animation2);
        txtCourse.startAnimation(animation2);
        news.startAnimation(animation2);
        txtNews.startAnimation(animation2);
        map.startAnimation(animation2);
        txtMap.startAnimation(animation2);
        page.startAnimation(animation2);
        txtPage.startAnimation(animation2);
        web.startAnimation(animation2);
        txtWeb.startAnimation(animation2);
    }

    public void openFB(View view) {
        animation_out();
        Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();
                int cho = 0;
                try {
                    sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finish();
                Intent i = new Intent(getApplicationContext(),FanPageActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(i);
            }
        };
        thread.start();
    }

    public void openMap(View view) {
        animation_out();
        Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();
                int cho = 0;
                try {
                    sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finish();
                Intent i = new Intent(getApplicationContext(),MapsActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(i);
            }
        };
        thread.start();
    }

    public void openNews(View view) {
        animation_out();
        Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();
                int cho = 0;
                try {
                    sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finish();
                Intent i = new Intent(getApplicationContext(),NewsActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(i);
            }
        };
        thread.start();
    }

    public void openCourse(View view) {
        animation_out();
        Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();
                int cho = 0;
                try {
                    sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finish();
                Intent i = new Intent(getApplicationContext(),CourseActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(i);
            }
        };
        thread.start();
    }

    public void openHomePage(View view) {
        animation_out();
        Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();
                int cho = 0;
                try {
                    sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finish();
                Intent i = new Intent(getApplicationContext(),HomePageActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(i);
            }
        };
        thread.start();
    }
}