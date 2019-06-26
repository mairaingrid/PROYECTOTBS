package com.example.tbs;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class realizarcita extends AppCompatActivity implements View.OnClickListener {

   Button fijarfecha;
    Button fijarhora;
    TextView fijarf;
    TextView fijarh;




    private  int dia;
    private  int mes;
    private  int año;
    private  int hora;
    private  int minutos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realizarcita);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fijarfecha=(Button)findViewById(R.id.fijarfeha);
        fijarhora=(Button)findViewById(R.id.fijarhora);
        fijarf= (TextView) findViewById(R.id.fijartextf);
        fijarh=(TextView)findViewById(R.id.fijartexth);
        fijarfecha.setOnClickListener(this);
        fijarhora.setOnClickListener(this);
        fijarf.setOnClickListener(this);
        fijarh.setOnClickListener(this);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        if(v==fijarfecha){
            final Calendar c = Calendar.getInstance();
            dia=c.get(Calendar.DAY_OF_MONTH);
            mes=c.get(Calendar.MONTH);
            año=c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog= new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    fijarf.setText(dayOfMonth+"/"+(month+1)+"/"+year);

                }
            },dia,mes,año);
            datePickerDialog.show();


        }
        if(v==fijarhora){
            final Calendar c = Calendar.getInstance();
            hora=c.get(Calendar.HOUR_OF_DAY);
            minutos=c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog= new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    fijarh.setText(hourOfDay+":"+minute);
                }
            },hora,minutos,false);
            timePickerDialog.show();




        }


    }

}
