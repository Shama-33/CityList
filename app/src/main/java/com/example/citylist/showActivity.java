package com.example.citylist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class showActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        Intent intent=getIntent();
        String s=intent.getStringExtra("cityname");

        TextView citynametext=findViewById(R.id.citynametext);
        citynametext.setText(s);

        Button backbutton =findViewById(R.id.backbutton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(showActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}