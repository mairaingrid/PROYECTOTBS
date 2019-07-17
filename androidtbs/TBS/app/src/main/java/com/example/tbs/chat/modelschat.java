package com.example.tbs.chat;

public class modelschat {
    private String usuario;
    private String mensaje;
    private String escribir;

    public modelschat(String usuario, String mensaje, String escribir) {

        this.usuario = usuario;
        this.mensaje = mensaje;
        this.escribir = escribir;
    }
    public String getEscribir(){return escribir;}

    public void setEscribir(String escribir){
        this.escribir=escribir;
    }


    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}


