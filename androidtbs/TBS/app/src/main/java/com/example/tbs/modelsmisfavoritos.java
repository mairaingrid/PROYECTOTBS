package com.example.tbs;

public class modelsmisfavoritos {
    private Integer imgmisanuncios;
    private String titulomisanuncios;
    private String costomisanuncios;
    private String telefonomisanuncios;
    private String descripcionmisanuncios;


    public modelsmisfavoritos(String title, String descripcirrron, String est, int coco){

    }
    public modelsmisfavoritos( String titulomisanuncios, String descripcionmisanuncios, String costomisanuncios, String telefonomisanuncios, int imgmisanuncios){

        this.titulomisanuncios= titulomisanuncios;
        this.descripcionmisanuncios=descripcionmisanuncios;
        this.costomisanuncios = costomisanuncios;
        this.titulomisanuncios= telefonomisanuncios;
        this.imgmisanuncios=imgmisanuncios;

    }

    public Integer getImg(){

        return imgmisanuncios;
    }
    public void setImg(Integer image)
    {
        this.imgmisanuncios = imgmisanuncios;
    }

    public String getTitle(){

        return titulomisanuncios;
    }

    public void setTitle(String title){
        this.titulomisanuncios = titulomisanuncios;
    }

    public String getDescripcion(){

        return descripcionmisanuncios;
    }

    public void setDescripcion(String descripcionmisanuncios){
        this.descripcionmisanuncios = descripcionmisanuncios;
    }

    public String getTelefono(){
        return telefonomisanuncios;
    }

    public void setTelefono(String telefonomisanuncios){
        this. telefonomisanuncios= telefonomisanuncios;
    }

    public String getCosto(){
        return  costomisanuncios;
    }

    public void setCosto(String costomisanuncios){
        this.costomisanuncios=costomisanuncios;
    }


}
