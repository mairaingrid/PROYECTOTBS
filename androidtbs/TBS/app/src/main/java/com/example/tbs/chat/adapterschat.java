package com.example.tbs.chat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tbs.R;

import java.security.AccessControlContext;
import java.util.List;

public class adapterschat extends RecyclerView.Adapter<adapterschat.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{
 EditText chat;
Button enviar;
        TextView usuario;
        TextView mensaje;
        EditText escribir;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            enviar = (Button) itemView.findViewById(R.id.send);
            chat =(EditText) itemView.findViewById(R.id.escribir);
            usuario = (TextView) itemView.findViewById(R.id.usuario_comprador);
            mensaje = (TextView)itemView.findViewById(R.id.mensaje);
      //      escribir = (EditText)
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mensaje2= null;
                mensaje2=chat.getText().toString();
                mensaje.setText(mensaje2);
            }
        });
        }
    }
    public List<modelschat> listaa;

    public adapterschat(AccessControlContext context, List<modelschat> listaa){
        this.listaa = listaa;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        holder.usuario.setText(listaa.get(position).getUsuario());
        holder.mensaje.setText(listaa.get(position).getMensaje());
    }

    @Override
    public int getItemCount(){
        return listaa.size();
    }

}
