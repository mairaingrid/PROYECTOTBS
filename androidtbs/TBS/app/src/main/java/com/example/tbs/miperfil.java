package com.example.tbs;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class miperfil extends AppCompatActivity  implements
        misanuncios.OnFragmentInteractionListener,
        miscitas.OnFragmentInteractionListener,
        misfavoritos.OnFragmentInteractionListener,
        misamigos.OnFragmentInteractionListener{

    misamigos  misamigos;
    misfavoritos misfavoritos;
    misanuncios misanuncios;
    miscitas miscitas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miperfil);
     //   loadComponents();

            misanuncios=new misanuncios();
            misfavoritos= new misfavoritos();
            misamigos = new misamigos();
            miscitas = new miscitas();

           getSupportFragmentManager().beginTransaction().add(R.id.contenedoroficial,misanuncios).commit();
   /*     recyclerV=(RecyclerView) findViewById(R.id.recicler);
        recyclerV.setLayoutManager(new LinearLayoutManager(this));

        adapter=new adapters(obtencion());
        recyclerV.setAdapter(adapter);*/

    }

    public void clickfragments(View v){
       FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();

        switch (v.getId()){
            case R.id.btnmisanuncios:
                transaction.replace(R.id.contenedoroficial,misanuncios);
                break;
            case R.id.btnmisfavoritos:
                transaction.replace(R.id.contenedoroficial,misfavoritos);
                break;

            case R.id.btnmisamigos:
                transaction.replace(R.id.contenedoroficial,misamigos);
                break;
            case R.id.btnmiscitas:
                transaction.replace(R.id.contenedoroficial,miscitas);
                break;
        }
        transaction.commit();
    }/*
public List<models> obtencion(){
        List<models> datos= new ArrayList<>();
        datos.add(new models("title","descripcion","est",R.drawable.coco));
    datos.add(new models("title","descripcion","est",R.drawable.coco));
        return datos;

}*/

    /**
     * Called when pointer capture is enabled or disabled for the current window.
     *
     * @param hasCapture True if the window has pointer capture.
     */
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
//importante
    @Override
    public void onFragmentInteraction(Uri uri) {

    }
   /* private void loadComponents() {


//agarra las imagenes de drwable
        Integer[] image = new Integer[]{R.drawable.fresa, R.drawable.uvas, R.drawable.pina, R.drawable.coco};
        String[] titles = new String[]{"fresa", "uvas", "pina", "coco"};
        String[] descrip = new String[]{"mel", "cat", "hca", "pe"};
        String[] adicional = new String[]{"adi", "cio", "nal", "izar"};
      //crear instncia
        ArrayList<models> listdata = new ArrayList<>();
        for (int i = 0; i < image.length; i++) {
            models info = new models();
            info.setImg(image[i]);
            info.setTitle(titles[i]);
            info.setDescripcion(descrip[i]);
            info.setAdicional(adicional[i]);
            listdata.add(info);
        }


                 /*  ArrayList<String> datoslist = new ArrayList<>();
            for (int i = 0; i < 20; i++){
                datoslist.add("Item" + i);
            }
   //     ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datoslist);
            adapters adapter = new adapters(this,listdata);
            list.setAdapter(adapter);
        }
*/

    }

