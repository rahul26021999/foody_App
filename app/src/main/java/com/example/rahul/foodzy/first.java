package com.example.rahul.foodzy;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class first extends AppCompatActivity implements View.OnClickListener {

    TextView marquee;
    Button orderbtn;
    MediaPlayer mediaplayer;
    public  static List<product> mlist;
    public static  int cartq;
    TextView cartqty;
    ImageView cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        mlist=new ArrayList<>();
        cartq=0;
        cartqty=(TextView)findViewById(R.id.cartqty0);
        cartqty.setText(String.valueOf(cartq));
        cart=(ImageView)findViewById(R.id.cart0);
        cart.setOnClickListener(this);
        marquee=(TextView)findViewById(R.id.marquee);
        marquee.setSelected(true);
        orderbtn=(Button)findViewById(R.id.orderbutton);
        orderbtn.setOnClickListener(this);

        mediaplayer= MediaPlayer.create(this,R.raw.sample);
        mediaplayer.setLooping(true);
    }
    @Override
    protected void onStop() {
        super.onStop();
        mediaplayer.stop();

    }
    @Override
    protected void onResume() {
        super.onResume();
        mediaplayer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaplayer.stop();
        mediaplayer.release();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaplayer.stop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mediaplayer.start();
        cartqty.setText(String.valueOf(cartq));
    }

    @Override
    protected void onStart() {
        super.onStart();
        mediaplayer.start();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.cart0:
                Intent i=new Intent(getApplicationContext(),cart.class);
                startActivity(i);
                break;
            case R.id.orderbutton:
                Intent j=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(j);
                break;
        }

    }

    @Override
    public void onBackPressed() {

    }
}
