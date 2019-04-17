package com.example.interpark.myapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class IntroActivity extends AppCompatActivity {

    Handler handler; //핸들러 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        handler = new Handler();
        handler.postDelayed(mrun,2000); // 시간 2초 딜레이
    }


    Runnable mrun = new Runnable() {
        @Override
        public void run() {
         Intent w = new Intent(IntroActivity.this, MainActivity.class); //인텐트 생성 (현 액티비티, 새로 실행할 액티비티)
            startActivity(w);
            finish();
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            //overridePending Transition : 서서히 사라지는 효과
        }
    };

    //인트로 중에 뒤로가기를 누를 경우 핸들러를 끊어버려 아무일 없게 만든느 부분
    //미 설정시 인트로 중 뒤로가기를 누르면 인트로 후에 홈화면이 나옴.

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        handler.removeCallbacks(mrun);
    }
}
