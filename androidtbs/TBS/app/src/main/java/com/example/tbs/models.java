package com.example.tbs;

public class models {
    //models es el datainfo del ingeniero

    private Integer img;
    private String title;
    private String descripcion;
    private String adicional;


    public models(){

    }
    public models( String title, String descripcion, String adicional, int img){

        this.title = title;
        this.descripcion=descripcion;
        this.adicional = adicional;
        this.img=img;

    }

    public Integer getImg(){

        return img;
    }
    public void setImg(Integer image)
    {
        this.img = img;
    }

    public String getTitle(){

        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getDescripcion(){

        return descripcion;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public String getAdicional(){
        return adicional;
    }

    public void setAdicional(String adicional){
        this.adicional = adicional;
    }


}
