package com.example.admin.testproj;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ItemAdapter extends ArrayAdapter<Item>{
    private int resId;
    ItemAdapter(Context context, int textViewResourceId, List<Item> obj){
        super(context,textViewResourceId,obj);
        resId = textViewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Item item = getItem(position);
        //convertView为缓存View，可以提高运行效率
        View view = convertView;
        ViewHolder holer;
        if(view == null) {
            view = LayoutInflater.from(getContext()).inflate(resId, null);
            holer = new ViewHolder();
            holer.view = (ImageView) view.findViewById(R.id.img);
            holer.text = (TextView) view.findViewById(R.id.name);
            view.setTag(holer);
        }else {
            holer = (ViewHolder)view.getTag();
        }
        holer.view.setImageResource(item.getId());
        holer.text.setText(item.getName());
        return view;
    }
    class ViewHolder{
        ImageView view;
        TextView text;
    }
}
