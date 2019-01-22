package com.example.loopertextview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private NoticeTextView noticeTextview;
    private ArrayList<String> titleList = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noticeTextview = findViewById(R.id.verticalView);
        init();
    }

    private void init() {

        titleList.add("联想旗舰：骁龙855");
        titleList.add("4800w像素，红米Note7发售");
        titleList.add("本田车型7w首付");
        titleList.add("年货促销");
        noticeTextview.setTextList(titleList);
        noticeTextview.setText(14, 5, Color.GRAY);//设置属性
        noticeTextview.setTextStillTime(3000);//设置停留时长间隔
        noticeTextview.setAnimTime(300);//设置进入和退出的时间间隔
        noticeTextview.setOnItemClickListener(new NoticeTextView.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(MainActivity.this, "点击了 : " + titleList.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        noticeTextview.startAutoScroll();
    }

    @Override
    protected void onPause() {
        super.onPause();
        noticeTextview.stopAutoScroll();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        noticeTextview.remove();
    }
}
