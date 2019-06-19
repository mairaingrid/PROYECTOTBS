package com.example.tbs;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class adaptersmiscitas  extends RecyclerView.Adapter<adaptersmiscitas.ViewHolder> {

    private View.OnClickListener listener;



    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imagenmiscitas;
        TextView nombremiscitas;
        TextView descripcionmiscitas;
        TextView fechamiscitas;
        CheckBox checkbox1;
        LinearLayout horizontal;

        private View.OnClickListener listener;


        Context context;
        // ImageButton llamadamiscitas;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            nombremiscitas = (TextView) itemView.findViewById(R.id.nombremiscitas);
            descripcionmiscitas = (TextView) itemView.findViewById(R.id.descripcionmiscitas);
            fechamiscitas = (TextView) itemView.findViewById(R.id.fechamiscita);
            //     llamadamiscitas = itemView.findViewById(R.id.llamarmiscitas);
            imagenmiscitas = (ImageView) itemView.findViewById(R.id.imagenmiscitas);
//                    itemView.setOnClickListener((View.OnClickListener) this);

            horizontal = (LinearLayout) itemView.findViewById(R.id.horizontal);
            //         checkbox1 =(CheckBox)itemView.findViewById(R.id.checkBox1);
              /*      checkbox2 =(CheckBox)itemView.findViewById(R.id.checkBox2);
                    checkbox3 =(CheckBox)itemView.findViewById(R.id.checkBox3);
                    checkbox4 =(CheckBox)itemView.findViewById(R.id.checkBox4);
                    checkbox5 =(CheckBox)itemView.findViewById(R.id.checkBox5);
*/
             /*       checkbox1.setOnClickListener(chkListener);
                    checkbox2.setOnClickListener(chkListener);
                    checkbox3.setOnClickListener(chkListener);
                    checkbox4.setOnClickListener(chkListener);
                    checkbox5.setOnClickListener(chkListener);
                    checkbox1.setOnClickListener(chkListenr);
                    checkbox2.setOnClickListener(chkListenr);
                    checkbox1.setOnClickListener(chkListenr);
                    checkbox1.setOnClickListener(chkListenr);
                    checkbox1.setOnClickListener(chkListenr);
                    checkbox1.setOnClickListener(chkListenr);
///crea las estrellas copiar
*/
          /*          for (int i = 1; i < 5; i++) {
                        checkbox1 = (CheckBox) horizontal.findViewById(Integer.parseInt(String.valueOf(i)));
                        checkbox1.setOnClickListener(starslistener);

                    }
                }
                    private View.OnClickListener starslistener=new View.OnClickListener(){
                        public void onClick(View v){
                            int tag = Integer.valueOf((String)v.getTag());

                            for (int i=1 ; i< tag; i++){
                                checkbox1=(CheckBox) horizontal.findViewById(Integer.parseInt(String.valueOf(i)));
                                checkbox1.setChecked(true);
                            }
                            for (int i =tag+1; i<=5 ; i++){
                                checkbox1=(CheckBox)horizontal.findViewWithTag(String.valueOf(i));
                                checkbox1.setChecked(false);

                            }

                        }
                    };

                }

*/
        }
    }

   //     private  View.OnClickListener onClickListener(=new View.OnClickListener()){

 //   }
    public List<modelsmiscitas> listaa;

    public adaptersmiscitas(List<modelsmiscitas> listaa) {
        this.listaa = listaa;
    }

    @Override
    public adaptersmiscitas.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.miscitas, parent, false);
       adaptersmiscitas.ViewHolder viewHolder = new adaptersmiscitas.ViewHolder(view);




//        holder.context;

 /*       LinearLayout ratito = (LinearLayout) vista.findViewById(R.id.ratito);
        for(int i=1; i<=5; i++){
            star=(CheckBox)ratito.findViewById(Integer.parseInt(String.valueOf(i)));
            star.setOnClickListener(starListener);
        }
   */

     return viewHolder;

    }
      public void setOnClickListener(View.OnClickListener listener){

        this.listener=listener;
        }
/*@Override
public void onClick(View v) {
        if (listener!=null){
            listener.onClick(v);
        }

        }
    /*private View.OnClickListener starListener=new View.OnClickListener(){

        /**
         * Called when a view has been clicked.
         *
         * @param v The view that was clicked.
         */
/*        @Override
        public void onClick(View v) {
            int tag = Integer.valueOf((String)v.getTag());

            for(int i =1; i<= tag; i++){
                star = (CheckBox) ratito.findViewById(Integer.parseInt(String.valueOf(i)));
                star.setChecked(true);
            }

            for(int i = tag+1; i<=5; i++){
                star=(CheckBox)ratito.findViewById(Integer.parseInt(String.valueOf(i)));
                star.setChecked(false);

            }
        }
    };
*/
    @Override
    public void onBindViewHolder(adaptersmiscitas.ViewHolder holder, int position) {
        holder.nombremiscitas.setText(listaa.get(position).getTitle());
        holder.descripcionmiscitas.setText(listaa.get(position).getDescripcion());
        holder.fechamiscitas.setText(listaa.get(position).getFechamiscitas());
        holder.imagenmiscitas.setImageResource(listaa.get(position).getImg());
    /*    holder.relative.setO
        //       holder.llamadamiscitas.setTag(listaa.get(position).getLlamada());

        @Override
                public void onclick(VIew v){

        }
    }*/
    }

    @Override
    public int getItemCount() {
        return listaa.size();
    }
}