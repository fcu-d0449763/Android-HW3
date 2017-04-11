package com.example.user.android_hw3;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.R.attr.onClick;

public class SayHelloActivity extends AppCompatActivity {

    Button back_button;
    EditText input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_say_hello);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        input = (EditText)findViewById(R.id.Name);
        back_button = (Button) findViewById(R.id.back_to_main) ;
        View.OnClickListener back_listener = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String UserName = input.getText().toString();

                Intent last_page = new Intent();
                last_page.putExtra(MainActivity.NAME,UserName);
                setResult(RESULT_OK,last_page);
                finish();
            }
        };
        back_button.setOnClickListener(back_listener);

    }


}
