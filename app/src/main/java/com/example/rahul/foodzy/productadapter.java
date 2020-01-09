package com.example.rahul.foodzy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Rahul on 14-10-2017.
 */

public class productadapter extends BaseAdapter{
    private Context mcontext;
    private List<product> mlist;


    public productadapter(Context mcontext, List<product> mlist) {
        this.mcontext = mcontext;
        this.mlist = mlist;
    }
    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public Object getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View v=View.inflate(mcontext,R.layout.item,null);

        TextView qty=(TextView)v.findViewById(R.id.qty);
        TextView name=(TextView)v.findViewById(R.id.name);
        TextView description=(TextView)v.findViewById(R.id.description);
        TextView size=(TextView)v.findViewById(R.id.size);
        TextView price=(TextView)v.findViewById(R.id.price);
        ImageView image=(ImageView)v.findViewById(R.id.image);


        ImageView delete=(ImageView)v.findViewById(R.id.deletefromcart);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                first.cartq=first.cartq-Integer.parseInt(mlist.get(position).getQty());
                cart.cartqty.setText(String.valueOf(first.cartq));
                mlist.remove(position);
                Toast.makeText(mcontext,"done",Toast.LENGTH_SHORT).show();
                if(mlist.isEmpty())
                {

                    cart.lv.setVisibility(View.GONE);
                    cart.l.setVisibility(View.VISIBLE);
                    cart.b.setVisibility(View.GONE);
                }
                productadapter.this.notifyDataSetChanged();
            }
        });

        name.setText(mlist.get(position).getName());
        price.setText(mlist.get(position).getPrice());
        size.setText(mlist.get(position).getSize());
        description.setText(mlist.get(position).getDescription());
        qty.setText(mlist.get(position).getQty());
        image.setImageResource(mlist.get(position).getImage());

        return v;
    }

}
