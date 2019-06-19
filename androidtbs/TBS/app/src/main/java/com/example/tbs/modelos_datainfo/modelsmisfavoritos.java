package com.example.tbs;

import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.CheckBox;

public class modelsmisfavoritos {
    private Integer imgmisanuncio;
    private String titulomisanuncios;
    private String costomisanuncios;
    private String telefonomisanuncios;
    private String descripcionmisanuncios;
 //   private boolean star;


    public modelsmisfavoritos(//CheckBox star,
                              String title, String descripcirrron, String est, int imagen){

    }
    public modelsmisfavoritos(//CheckBox star,
                              String titulomisanuncios, String descripcionmisanuncios, String costomisanuncios, String telefonomisanuncios, int imgmisanuncios){

        this.titulomisanuncios= titulomisanuncios;
        this.descripcionmisanuncios=descripcionmisanuncios;
        this.costomisanuncios = costomisanuncios;
        this.titulomisanuncios= telefonomisanuncios;
        this.imgmisanuncio=imgmisanuncios;
      //  this.star=star;

    }

//    public boolean getStar(){
  //      return star;
   // }

  /*  public void setStar(boolean star) {
      //  if (star && getStar() instanceof View && (View) getParent().isPressed()){
    //        return;}
  //      super.setStar(star);
        this.star = star;
    }
*/
    public Integer getImg(){

        return imgmisanuncio;
    }
    public void setImg(Integer image)
    {
        this.imgmisanuncio = imgmisanuncio;
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
