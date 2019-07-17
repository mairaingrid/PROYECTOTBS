package com.example.tbs.personas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.tbs.R;

import java.util.ArrayList;

public class personas extends AppCompatActivity {

    private ArrayList<modelspersonas> listdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personas);
        loadComponets();
    }

    private void loadComponets() {
        ListView list = findViewById(R.id.listaa);
        //   bigimg = findViewById(R.id.bigimage);
        //GridView grid = findViewById(R.id.gridview);
        //Spinner spinner = findViewById(R.id.spinner);

        listdata = new ArrayList<>();
        Integer[] images = new Integer[]{R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_background};
        String[] titles = new String[]{"sdf", "", "uytre", "rda", "vw"};
        String[] descrip = new String[]{"vsfsd", "we", "vsdf", "vgfd", "rdx"};
        //ArrayList<DataInfo> listdata =new ArrayList<>();
        for (int i = 0; i < images.length; i++) {
            modelspersonas info = new modelspersonas();
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

        adapterspersonas adapter = new adapterspersonas(this, listdata);

        list.setAdapter(adapter);
//        list.setOnItemClickListener((AdapterView.OnItemClickListener) this);
        //grid.setAdapter(adapter);
        //spinner.setAdapter(adapter);}
    }
}