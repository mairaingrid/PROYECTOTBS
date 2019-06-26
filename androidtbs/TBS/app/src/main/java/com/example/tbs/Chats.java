package com.example.tbs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;




import java.util.ArrayList;

public class Chats extends AppCompatActivity {

    private ArrayList<modelschats> listdata;
    private ImageView bigimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chats);


        loadComponets();
    }

    private void loadComponets() {
        ListView list = findViewById(R.id.linearlayoutchats);


        listdata = new ArrayList<>();
        Integer[] images = new Integer[]{R.drawable.brand, R.drawable.fresa, R.drawable.coco, R.drawable.coco, R.drawable.brand};
        String[] titles = new String[]{"ARIA", "CENTOS", "Diaria", "Malechor", "Users"};
        String[] descrip = new String[]{"", "2", "3", "4", "5"};

        for (int i = 0; i < images.length; i++) {
            modelschats info = new modelschats();
            info.setImg(images[i]);
            info.setTitle(titles[i]);
            info.setDescripcion(descrip[i]);
            listdata.add(info);

        }

        /*ArrayList<String> datoslist = new ArrayList<>();
        for (int i = 0; i < 100; i++){
            datoslist.add("Item" +i);

        }*/
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,datoslist);

        adapterschats adapter = new adapterschats(this, listdata);

        list.setAdapter(adapter);
       // list.setOnItemClickListener(this);
    }
}