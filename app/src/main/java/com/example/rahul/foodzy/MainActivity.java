package com.example.rahul.foodzy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.media.audiofx.BassBoost;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static android.R.attr.key;
import static android.R.attr.value;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static com.example.rahul.foodzy.R.id.list;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener,
        RadioGroup.OnCheckedChangeListener, AdapterView.OnItemSelectedListener,View.OnClickListener{

    LinearLayout choosepizza;
    ImageButton pizzaplus,pizzaminus;
    CheckBox pizza,pizzach;
    TextView pizzaprice,topping,pizzaqty,crustname,aboutcrust;
    ImageView pizzaimage;
    ImageView pizzasimg;
    LinearLayout main;
    RadioGroup pizzabase,pizzasize;
    Spinner pizzaspin;

    ImageView drinksimg,drinkimg;
    Spinner drinkspin;
    ImageButton drinkminus,drinkplus;
    CheckBox drinks;
    TextView drinkqty,drinkprice;
    LinearLayout drinkchoose;

    ImageView pastaimg,manchurianimg;
    LinearLayout choosepasta,choosemanchurian;
    CheckBox pasta,manchurian;
    TextView pastaqty,manchurianqty,pastaprice,manchurianprice;
    ImageButton manchurianplus,manchurianminus,pastaplus,pastaminus;


    Button pizzacart,manchuriancart,pastacart,drinkcart;
    ImageView cart;
    TextView cartqty;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialise();
        initialise1();
        initialise2();
        initialise3();
        choosepizza.setVisibility(View.GONE);
        drinkchoose.setVisibility(View.GONE);
        choosemanchurian.setVisibility(View.GONE);
        choosepasta.setVisibility(View.GONE);

        cartqty.setText(String.valueOf(first.cartq));
    }
    public void initialise3()
    {
        cart=(ImageView)findViewById(R.id.cart);
        cartqty=(TextView)findViewById(R.id.cartqty);
        pizzacart=(Button)findViewById(R.id.pizzacart);
        manchuriancart=(Button)findViewById(R.id.manchuriancart);
        pastacart=(Button)findViewById(R.id.pastacart);
        drinkcart=(Button)findViewById(R.id.drinkcart);

        pizzacart.setOnClickListener(this);
        manchuriancart.setOnClickListener(this);
        pastacart.setOnClickListener(this);
        drinkcart.setOnClickListener(this);
        cart.setOnClickListener(this);
    }
    public  void initialise2()
{
    pastaimg=(ImageView)findViewById(R.id.pastaimg);
    manchurianimg=(ImageView)findViewById(R.id.manchurianimg);
    choosepasta=(LinearLayout)findViewById(R.id.choosepasta);
    choosemanchurian=(LinearLayout)findViewById(R.id.choosemanchurian);
    pasta=(CheckBox)findViewById(R.id.pasta);
    manchurian=(CheckBox)findViewById(R.id.manchurian);
    manchurianplus=(ImageButton)findViewById(R.id.manchurianplus);
    manchurianminus=(ImageButton)findViewById(R.id.manchurianminus);
    manchurianqty=(TextView)findViewById(R.id.manchurianqty);
    pastaplus=(ImageButton)findViewById(R.id.pastaplus);
    pastaminus=(ImageButton)findViewById(R.id.pastaminus);
    pastaqty=(TextView)findViewById(R.id.pastaqty);
    pastaprice=(TextView)findViewById(R.id.pastaprice);
    manchurianprice=(TextView)findViewById(R.id.manchurianprice);


    pastaplus.setOnClickListener(this);
    manchurianplus.setOnClickListener(this);
    manchurianminus.setOnClickListener(this);
    pastaminus.setOnClickListener(this);
    manchurian.setOnCheckedChangeListener(this);
    pasta.setOnCheckedChangeListener(this);

}
public  void initialise1()
{
    drinkimg=(ImageView)findViewById(R.id.drinkimg);
    drinkminus=(ImageButton)findViewById(R.id.drinkminus);
    drinkplus=(ImageButton)findViewById(R.id.drinkplus);
    drinksimg=(ImageView)findViewById(R.id.drinksimg);
    drinkqty=(TextView)findViewById(R.id.drinkqty);
    drinkspin=(Spinner)findViewById(R.id.drinkspin);
    drinkprice=(TextView)findViewById(R.id.drinkprice);
    drinkchoose=(LinearLayout)findViewById(R.id.choosedrink);
    drinks=(CheckBox)findViewById(R.id.drinks);

    drinks.setOnCheckedChangeListener(this);
    drinkplus.setOnClickListener(this);
    drinkminus.setOnClickListener(this);
    drinkspin.setOnItemSelectedListener(this);
}
    public  void initialise()
    {
        pizzaprice=(TextView)findViewById(R.id.pizza_prize);
        pizzabase=(RadioGroup)findViewById(R.id.pizzabase);
        pizzaspin=(Spinner)findViewById(R.id.pizzaspin);
        pizzasize=(RadioGroup)findViewById(R.id.pizzasize);
        pizzaimage=(ImageView)findViewById(R.id.pizzaimg);
        topping=(TextView)findViewById(R.id.toppings);
        pizzaqty=(TextView)findViewById(R.id.pizzaqty);
        pizzaminus=(ImageButton)findViewById(R.id.pizzaminus);
        pizzaplus=(ImageButton)findViewById(R.id.pizzaplus);
        pizzach=(CheckBox)findViewById(R.id.pizzach);

        pizzasimg=(ImageView)findViewById(R.id.pizzasimg);
        crustname=(TextView)findViewById(R.id.crustname);
        aboutcrust=(TextView)findViewById(R.id.aboutcrust);


        choosepizza=(LinearLayout)findViewById(R.id.choosepizza);
        pizza=(CheckBox)findViewById(R.id.pizzas);

        pizzabase.setOnCheckedChangeListener(this);
        pizza.setOnCheckedChangeListener(this);
        pizzach.setOnCheckedChangeListener(this);
        pizzaspin.setOnItemSelectedListener(this);
        pizzaminus.setOnClickListener(this);
        pizzaplus.setOnClickListener(this);
        pizzasize.setOnCheckedChangeListener(this);
    }

    public  void findprice()
    {
        int price=0;
        int pos=pizzaspin.getSelectedItemPosition();
        RadioButton r=(RadioButton)findViewById(pizzasize.getCheckedRadioButtonId());
        String size=r.getText().toString();

        switch (size)
        {
            case "Medium":
                price=getResources().getIntArray(R.array.medium_pizes)[pos];
                break;
            case "Large":
                price=getResources().getIntArray(R.array.large_pizes)[pos];
                break;
            case "Regular":
                price=getResources().getIntArray(R.array.regular_pizes)[pos];
                break;
        }
        price+=calculatebaseprice();
        if(pizzach.isChecked())
        {
            switch (size)
            {
                case "Medium":
                    price=price+40;
                    break;
                case "Large":
                    price=price+50;
                    break;
                case "Regular":
                    price=price+30;
                    break;
            }
        }
        price=price*Integer.parseInt(pizzaqty.getText().toString());
        pizzaprice.setText(String.valueOf(price));

    }
    public int calculatebaseprice()
    {
        int p=0;
        RadioButton r=(RadioButton)findViewById(pizzasize.getCheckedRadioButtonId());
        String size = r.getText().toString();
        int m=pizzabase.indexOfChild((RadioButton)findViewById(pizzabase.getCheckedRadioButtonId()));

        if(m==0 || m==4)
        {
            p=0;
        }
        else if(m==1 || m==3){
            switch (size) {
                case "Medium":
                        p=40;
                    break;
                case "Large":
                        p=50;
                    break;
                case "Regular":
                        p=30;
                 break;
            }
        }
        else if(m==2) {
            switch (size) {
                case "Medium":
                    p=75;
                break;
                case "Large":
                    p=105;
                break;
                case "Regular":
                    p=55;
                break;
            }
        }
        return p;
    }
    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b)
    {
        switch(compoundButton.getId())
        {
            case R.id.pizzas:
                if(compoundButton.isChecked())
                {
                    pizzasimg.setVisibility(View.GONE);
                    choosepizza.setVisibility(View.VISIBLE);
                    pizzasize.check(pizzasize.getChildAt(0).getId());
                    pizzabase.check(pizzabase.getChildAt(0).getId());
                    pizzaspin.setSelection(0);
                    pizzaqty.setText("1");
                    pizzach.setChecked(false);
                    findprice();
                }
                else
                {
                    choosepizza.setVisibility(View.GONE);
                    pizzasimg.setVisibility(View.VISIBLE);
                    pizzaprice.setText("0");
                }
                break;
            case R.id.pizzach:
                    findprice();
                break;
            case R.id.drinks:
                if(compoundButton.isChecked())
                {
                    drinksimg.setVisibility(View.GONE);
                    drinkchoose.setVisibility(View.VISIBLE);
                    drinkspin.setSelection(0);
                    drinkprice.setText("40");
                    drinkqty.setText("1");
                }
                else
                {
                    drinksimg.setVisibility(View.VISIBLE);
                    drinkchoose.setVisibility(View.GONE);
                    drinkprice.setText("0");
                }
                break;
            case R.id.pasta:
                if(compoundButton.isChecked())
                {
                    pastaimg.setVisibility(View.GONE);
                    choosepasta.setVisibility(View.VISIBLE);
                    pastaprice.setText("110");
                    pastaqty.setText("1");
                }
                else
                {
                    pastaimg.setVisibility(View.VISIBLE);
                    choosepasta.setVisibility(View.GONE);
                    pastaprice.setText("0");
                }
                break;
            case R.id.manchurian:
                if(compoundButton.isChecked())
                {
                    manchurianimg.setVisibility(View.GONE);
                    choosemanchurian.setVisibility(View.VISIBLE);
                    manchurianprice.setText("100");
                    manchurianqty.setText("1");
                }
                else
                {
                    manchurianimg.setVisibility(View.VISIBLE);
                    choosemanchurian.setVisibility(View.GONE);
                    manchurianprice.setText("0");
                }
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {

        switch (radioGroup.getId())
        {
            case R.id.pizzabase:
                radiocolor(radioGroup);
                changecrust();
                findprice();
                break;
            case R.id.pizzasize:
                radiocolor(radioGroup);
                findprice();
                break;
        }
    }
    public void changecrust()
    {
        RadioButton r=(RadioButton)findViewById(pizzabase.getCheckedRadioButtonId());
        crustname.setText(r.getText().toString());
        int pos=pizzabase.indexOfChild(r);
        aboutcrust.setText(getResources().getStringArray(R.array.aboutcrust)[pos]);
    }
    public  void radiocolor(RadioGroup r)
    {
        for(int i=0;i<r.getChildCount();i++)
        {
            if(r.getChildAt(i).getId()==r.getCheckedRadioButtonId())
            {
                RadioButton r1=(RadioButton)findViewById(r.getChildAt(i).getId());
                r1.setTextColor(getResources().getColor(R.color.colorAccent));
            }
            else
            {
                RadioButton r1=(RadioButton)findViewById(r.getChildAt(i).getId());
                r1.setTextColor(getResources().getColor(R.color.black));
            }
        }

    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        switch (adapterView.getId())
        {
            case R.id.pizzaspin:
                pizzabase.check(pizzabase.getChildAt(0).getId());
                pizzasize.check(pizzasize.getChildAt(0).getId());
                pizzaqty.setText("1");
                switch (pizzaspin.getSelectedItem().toString())
                {
                case "Margherita":
                    pizzaimage.setImageResource(R.drawable.margherit);
                    topping.setText(getResources().getStringArray(R.array.toppings)[0]);
                    break;
                case "Deluxe Veggie":
                    pizzaimage.setImageResource(R.drawable.deluxeveggie);
                    topping.setText(getResources().getStringArray(R.array.toppings)[1]);
                    break;
                case "5 Pepper":
                    pizzaimage.setImageResource(R.drawable.pepper5);
                    topping.setText(getResources().getStringArray(R.array.toppings)[2]);
                    break;
                case "Farmhouse":
                    pizzaimage.setImageResource(R.drawable.farmhouse);
                    topping.setText(getResources().getStringArray(R.array.toppings)[3]);
                    break;
                case "Peppy Panner":
                    pizzaimage.setImageResource(R.drawable.peppypaneer);
                    topping.setText(getResources().getStringArray(R.array.toppings)[4]);
                    break;
                case "Cheese n Corn":
                    pizzaimage.setImageResource(R.drawable.corncheese);
                    topping.setText(getResources().getStringArray(R.array.toppings)[5]);
                    break;
                case "Mexican Green Wave":
                    pizzaimage.setImageResource(R.drawable.mexicangreenwave);
                    topping.setText(getResources().getStringArray(R.array.toppings)[6]);
                    break;
                case "Panner Makhini":
                    pizzaimage.setImageResource(R.drawable.paneermakhni);
                    topping.setText(getResources().getStringArray(R.array.toppings)[7]);
                    break;
                }
                findprice();
                break;
            case R.id.drinkspin:
                drinkqty.setText("1");
                drinkprice.setText("40");
                switch (drinkspin.getSelectedItem().toString())
                {
                    case "Coco Cola":
                        drinkimg.setImageResource(R.drawable.coc);
                        break;
                    case "Fanta":
                        drinkimg.setImageResource(R.drawable.fanta);
                        break;
                    case "Sprite":
                        drinkimg.setImageResource(R.drawable.sprite);
                        break;
                    case "Minute Made Orange":
                        drinkimg.setImageResource(R.drawable.orangepuply);
                        break;
                }
                break;
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
public void addtoqty(TextView qty,TextView p)
{
    int price;
    price=Integer.parseInt(p.getText().toString());
    price=price/Integer.parseInt(qty.getText().toString());
    qty.setText(String.valueOf(Integer.parseInt(qty.getText().toString())+1));
    price=price*Integer.parseInt(qty.getText().toString());
    p.setText(String.valueOf(price));
}
public void subtracttoqty(TextView qty,TextView p)
{
    int price;
    if((Integer.parseInt(qty.getText().toString())-1)!=0)
    {
        price=Integer.parseInt(p.getText().toString());
        price=price/Integer.parseInt(qty.getText().toString());
        qty.setText(String.valueOf(Integer.parseInt(qty.getText().toString())-1));
        price=price*Integer.parseInt(qty.getText().toString());
        p.setText(String.valueOf(price));
    }
}
public  Integer getImage(String d)
{
    Integer i = null;
    switch (d)
    {
        case "Margherita":
            i=R.drawable.margherit;
            break;
        case "Deluxe Veggie":
            i=R.drawable.deluxeveggie;
            break;
        case "5 Pepper":
            i=R.drawable.pepper5;
            break;
        case "Farmhouse":
            i=R.drawable.farmhouse;
            break;
        case "Peppy Panner":
            i=R.drawable.peppypaneer;
            break;
        case "Cheese n Corn":
            i=R.drawable.corncheese;
            break;
        case "Mexican Green Wave":
            i=R.drawable.mexicangreenwave;
            break;
        case "Panner Makhini":
            i=R.drawable.paneermakhni;
            break;
        case "Manchurian":
            i=R.drawable.manchurian;
            break;
        case "Pasta":
            i=R.drawable.pasta;
            break;
        case "Coco Cola":
            i=R.drawable.coc;
            break;
        case "Fanta":
            i=R.drawable.fanta;
            break;
        case "Sprite":
            i=R.drawable.sprite;
            break;
        case "Minute Made Orange":
            i=R.drawable.orangepuply;
            break;

    }
    return i;
}
    @Override
    public void onClick(View view) {

        int price;
        switch (view.getId())
        {
            case R.id.pizzaplus:
                addtoqty(pizzaqty,pizzaprice);
                break;
            case R.id.pizzaminus:
                subtracttoqty(pizzaqty,pizzaprice);
                break;
            case R.id.drinkminus:
                subtracttoqty(drinkqty,drinkprice);
                break;
            case R.id.drinkplus:
                addtoqty(drinkqty,drinkprice);
                break;
            case R.id.pastaminus:
                subtracttoqty(pastaqty,pastaprice);
                break;
            case R.id.pastaplus:
                addtoqty(pastaqty,pastaprice);
                break;
            case R.id.manchurianplus:
                addtoqty(manchurianqty,manchurianprice);
                break;
            case R.id.manchurianminus:
                subtracttoqty(manchurianqty,manchurianprice);
                break;
            case R.id.cart:

//                using shared preference

//                SharedPreferences sharedPreferences = getSharedPreferences("rahul", Context.MODE_PRIVATE);
//                SharedPreferences.Editor editor = sharedPreferences.edit();
//                Gson gson = new Gson();
//                String json = gson.toJson(mlist);
//                editor.putString("list",json);
//                editor.commit();

                Intent intent = new Intent(this,cart.class);
                //intent.putExtra("mylist", (Serializable) mlist);
                startActivity(intent);

                 break;
            case R.id.pizzacart:
                String name=pizzaspin.getSelectedItem().toString();
                String des=topping.getText().toString();
                String sbc=((RadioButton)findViewById(pizzasize.getCheckedRadioButtonId())).getText().toString()+
                        " | "+((RadioButton)findViewById(pizzabase.getCheckedRadioButtonId())).getText().toString();
                if(pizzach.isChecked())
                {
                    sbc=sbc+" | Extra Cheese";
                }
                String qty=pizzaqty.getText().toString();
                String pr=pizzaprice.getText().toString();
                Integer image=getImage(name);
                if(checkdupli(name,sbc,des,qty,pr))
                {
                    first.mlist.add(new product(name, des, sbc, qty, pr, image));
                }
                first.cartq=first.cartq+Integer.parseInt(qty);
                cartqty.setText(String.valueOf(first.cartq));
                break;
            case R.id.manchuriancart:
                if(checkdupli("Manchurian","","",manchurianqty.getText().toString(), manchurianprice.getText().toString()))
                {
                    first.mlist.add(new product("Manchurian", manchurianqty.getText().toString(), manchurianprice.getText().toString(), getImage("Manchurian")));
                }
                first.cartq=first.cartq+Integer.parseInt(manchurianqty.getText().toString());
                cartqty.setText(String.valueOf(first.cartq));
                break;
            case R.id.pastacart:
                if(checkdupli("Pasta","","",pastaqty.getText().toString(), pastaprice.getText().toString()))
                {
                    first.mlist.add(new product("Pasta", pastaqty.getText().toString(), pastaprice.getText().toString(), getImage("Pasta")));
                }
                first.cartq=first.cartq+Integer.parseInt(pastaqty.getText().toString());
                cartqty.setText(String.valueOf(first.cartq));
                break;
            case R.id.drinkcart:
                if(checkdupli(drinkspin.getSelectedItem().toString(),"","",drinkqty.getText().toString(),drinkprice.getText().toString()))
                {
                    first.mlist.add(new product(drinkspin.getSelectedItem().toString(),drinkqty.getText().toString(),drinkprice.getText().toString(),getImage(drinkspin.getSelectedItem().toString())));
                }
                first.cartq=first.cartq+Integer.parseInt(drinkqty.getText().toString());
                cartqty.setText(String.valueOf(first.cartq));
                break;
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        cartqty.setText(String.valueOf(first.cartq));
    }
    boolean checkdupli(String name,String sbc,String des,String qty,String price)
    {
        for(int i=0;i<first.mlist.size();i++)
        {
            if(name.equals(first.mlist.get(i).getName()) &&
                    sbc.equals(first.mlist.get(i).getSize()) &&
                    des.equals(first.mlist.get(i).getDescription())
                    )
            {
                first.mlist.get(i).setPrice(String.valueOf(Integer.parseInt(first.mlist.get(i).getPrice())+Integer.parseInt(price)));
                first.mlist.get(i).setQty(String.valueOf(Integer.parseInt(first.mlist.get(i).getQty())+Integer.parseInt(qty)));
                return false;
            }
        }
        return true;
    }
}
