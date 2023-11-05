package com.example.myapplication.card;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class card extends AppCompatActivity {

    EditText e1,e2,e3,e4,e5,e6,e7,e8;
    TextView t1,t2,t3,t4,t5;
    Button proceed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        e1 = (EditText) findViewById(R.id.et1);
        e2 = (EditText) findViewById(R.id.et2);
        e3 = (EditText) findViewById(R.id.et3);
        e4 = (EditText) findViewById(R.id.et4);
        e5 = (EditText) findViewById(R.id.et5);
        e6 = (EditText) findViewById(R.id.et6);
        e7 = (EditText) findViewById(R.id.et7);
        e8 = (EditText) findViewById(R.id.et8);

        t1 = (TextView) findViewById(R.id.code);
        t2 = (TextView) findViewById(R.id.cardholder);
        t3 = (TextView) findViewById(R.id.month);
        t4 = (TextView) findViewById(R.id.year);
        t5 = (TextView) findViewById(R.id.cvv);

        proceed = (Button)  findViewById(R.id.btn);
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.push_down);
                RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.r11);
                relativeLayout.setAnimation(animation);

                String code1,code2,code3,code4;

                code1 = e1.getText().toString();
                code2 = e2.getText().toString();
                code3 = e3.getText().toString();
                code4 = e4.getText().toString();

                t1.setText(code1 + "\t" + code2 + "\t" + code3 + "\t" + code4);

                String name,month,year,cvv;

                name = e5.getText().toString();
                t2.setText(name);

                month = e6.getText().toString();
                t3.setText(month);

                year = e7.getText().toString();
                t4.setText(year);

                cvv = e8.getText().toString();
                t5.setText(cvv);
            }
        });


    }
}