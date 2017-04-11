package com.example.user.android_hw3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static int FROM_SAY_HELLO = 1;
    public static String NAME ="Name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Button say_hello ;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        say_hello = (Button) findViewById(R.id.GoSayHello);
        say_hello.setOnClickListener(Listen_go_to_say_hello);

    }

    private View.OnClickListener Listen_go_to_say_hello = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent nextPage = new Intent();
            nextPage.setClass(MainActivity.this,SayHelloActivity.class);
            startActivityForResult(nextPage,FROM_SAY_HELLO);
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        else{
            Uri url = Uri.parse("http://google.com.tw");
            Intent web = new Intent();
            web.setAction(Intent.ACTION_VIEW);
            web.setData(url);
            startActivity(web);

        }

        return super.onOptionsItemSelected(item);
    }

    protected void onActivityResult(int RequestCode,int ResultCode,Intent intent){
        if(intent==null)return;
        String name = intent.getStringExtra(NAME);
        Toast.makeText(MainActivity.this,"Hello "+name+"!!!",Toast.LENGTH_SHORT).show();
    }
}
