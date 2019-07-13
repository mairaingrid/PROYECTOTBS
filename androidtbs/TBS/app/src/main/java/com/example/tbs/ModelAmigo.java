package com.example.tbs;

public class ModelAmigo {
    private String img,titulo,telefono;


    public ModelAmigo(String img, String titulo, String telefono) {
        this.img = img;
        this.titulo = titulo;
        this.telefono = telefono;
    }

    public String  getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
