package com.example.assigmentnum2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class MainController extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String activityType = getIntent().getStringExtra("activityType");
        if (activityType == null) {
            showSplashScreen();
        } else if (activityType.equals("MainActivity")) {
            showMainActivity();
        } else if (activityType.equals("CourseDetailActivity")) {
            showCourseDetailActivity();
        }
    }
    private void showSplashScreen() {
        setContentView(R.layout.splash_screen);
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(MainController.this, MainController.class);
            intent.putExtra("activityType", "MainActivity");
            startActivity(intent);
            finish();
        }, 3000);
    }

    private void showMainActivity() {
        setContentView(R.layout.activity_main);

        findViewById(R.id.android_course_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCourseDetail("Android", R.drawable.android_pic, R.string.content_Adroid);
            }
        });

        findViewById(R.id.ios_course_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCourseDetail("iOS", R.drawable.ios_pic, R.string.Content_IOS);
            }
        });
        findViewById(R.id.fullstack_course_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCourseDetail("Full Stack", R.drawable.fullstack_pic, R.string.Content_Full_Stack);
            }
        });
    }
    private void showCourseDetailActivity() {
        setContentView(R.layout.data_screen);
        String courseName = getIntent().getStringExtra("courseName");
        int courseImage = getIntent().getIntExtra("courseImage", 0);
        int courseDescription = getIntent().getIntExtra("courseDescription", 0);
        ImageView courseImageView = findViewById(R.id.course_image);
        TextView courseDescriptionTextView = findViewById(R.id.course_description);


        courseImageView.setImageResource(courseImage);
        courseDescriptionTextView.setText(courseDescription);
    }
    private void openCourseDetail(String courseName, int courseImage, int courseDescription) {
        Intent intent = new Intent(MainController.this, MainController.class);
        intent.putExtra("activityType", "CourseDetailActivity");
        intent.putExtra("courseName", courseName);
        intent.putExtra("courseImage", courseImage);
        intent.putExtra("courseDescription", courseDescription);
        startActivity(intent);
    }
}
