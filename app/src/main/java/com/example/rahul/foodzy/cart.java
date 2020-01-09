package com.example.rahul.foodzy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.support.constraint.solver.SolverVariable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class cart extends AppCompatActivity implements View.OnClickListener {

    public static ListView lv;
    public  static LinearLayout l;
    productadapter productadapter;
    ImageView cart;
    TextView gtm;
    public  static Button b;
    static TextView cartqty;
    int total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);


        cart=(ImageView)findViewById(R.id.cart1);
        cart.setOnClickListener(this);
        lv=(ListView)findViewById(R.id.list);
        b= (Button)findViewById(R.id.orderbutton);
        b.setOnClickListener(this);
        l= (LinearLayout) findViewById(R.id.emptyview);
        gtm= (TextView) findViewById(R.id.gotomenu);
        gtm.setOnClickListener(this);
        cartqty=(TextView)findViewById(R.id.cartqty1);
        cartqty.setText(String.valueOf(first.cartq));
       // mlist=(List<product>)(getIntent().getSerializableExtra("mylist"));
//         using shared preference

//        SharedPreferences sharedPrefs =getSharedPreferences("rahul",Context.MODE_PRIVATE);
//        Gson gson = new Gson();
//        String json = sharedPrefs.getString("list", null);
//        Type type = new TypeToken<List<product>>(){}.getType();
//        list = gson.fromJson(json, type);
        if(first.mlist.size()==0)
        {
            lv.setVisibility(View.GONE);
            l.setVisibility(View.VISIBLE);
            b.setVisibility(View.GONE);

        }
        else
        {
            l.setVisibility(View.GONE);
            lv.setVisibility(View.VISIBLE);
            b.setVisibility(View.VISIBLE);
        }

        productadapter=new productadapter(this,first.mlist);
        lv.setAdapter(productadapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.gotomenu:
                Intent i=new Intent(this,MainActivity.class);
                startActivity(i);
                break;
            case R.id.orderbutton:
                total=0;
                for(int k=0;k<first.mlist.size();k++)
                {
                    total=total+Integer.parseInt(first.mlist.get(k).getPrice());
                }
                Toast.makeText(getApplicationContext(), String.valueOf(total),Toast.LENGTH_SHORT).show();

                break;
        }
    }
}
