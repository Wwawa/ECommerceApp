package com.oum.e_commerceapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.oum.e_commerceapp.R;

/**
 * Created by seqato on 14/03/18.
 */

public class CategoryAdapter extends BaseAdapter {
    String[] Title;
    int[] imge;
    LayoutInflater layoutInflater;
Context context;

    CategoryAdapter() {
        Title = null;
        imge=null;
    }

    public CategoryAdapter(String[] text,int[] text3,Context context) {
        Title = text;
        imge = text3;
        this.context=context;

    }

    public int getCount() {
        // TODO Auto-generated method stub
        return Title.length;
    }

    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {



        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.category_item, null);
        }

       TextView title = (TextView) convertView.findViewById(R.id.category_name);
        ImageView img=(ImageView)convertView.findViewById(R.id.flag);


        // setting the image resource and title
        title.setText(Title[position]);
        img.setImageResource(imge[position]);

        return convertView;


    }
}


