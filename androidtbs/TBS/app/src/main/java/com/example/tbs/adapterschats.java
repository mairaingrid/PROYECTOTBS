package com.example.tbs;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class adapterschats extends BaseAdapter {

    private Context context;
    private ArrayList<modelschats> list;
    LinearLayout linearchats;
    public adapterschats(Context context, ArrayList<modelschats> list){
        this.context = context;
        this.list = list;

    }
    @Override
    public int getCount() {
        return this.list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            LayoutInflater inflate = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView =inflate.inflate(R.layout.item_chat, null);
        }
        ImageView img =  convertView.findViewById(R.id.imgenchat);
        TextView des =   convertView.findViewById(R.id.adicional);
        TextView title = convertView.findViewById(R.id.title);
        LinearLayout linearchats=convertView.findViewById(R.id.linearlayoutchats);

        img.setImageResource(this.list.get(position).getImg());
        des.setText(this.list.get(position).getDescripcion());
        title.setText(this.list.get(position).getTitle());
/*
        linearchats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                    Intent intent= new Intent(context,chatprincipal.class);
                    intent.putExtra("img",list.get(position).getImg());
                    intent.putExtra("titulo",list.get(position).getDescripcion());
                    intent.putExtra("adicional",list.get(position).getTitle());
                    context.startActivity(intent);
                }
            });*/
        return convertView;
    }
}
