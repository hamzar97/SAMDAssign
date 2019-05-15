package com.example.samdassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.os.Handler;
import android.os.Message;

public class MainActivity extends AppCompatActivity {


    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            TextView labelText = (TextView) findViewById(R.id.labelText);
            labelText.setText("Hello World!");
        }
    };








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickButton(View v){

        Runnable r = new Runnable() {
            @Override
            public void run() {
                long futureTime = System.currentTimeMillis() + 5000;
                while (System.currentTimeMillis() < futureTime){
                    synchronized (this){
                        try {
                            wait(futureTime - System.currentTimeMillis());
                        }
                        catch (Exception e){

                        }
                    }
                }
                handler.sendEmptyMessage(0);

            }
        };

        Thread optionThread = new Thread(r);
        optionThread.start();

    }



}
