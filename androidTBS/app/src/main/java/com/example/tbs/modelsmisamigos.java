package com.example.tbs;

public class modelsmisamigos {
    private Integer imgmisamigos;
    private String titulomisamigos;
   
    private String telefonomisamigos;



    public modelsmisamigos( String titulomisamigos, String telefonomisamigos, int imgmisamigos){

        this.titulomisamigos= titulomisamigos;
        this.titulomisamigos= telefonomisamigos;
        this.imgmisamigos=imgmisamigos;

    }



    public Integer getImg(){

        return imgmisamigos;
    }
    public void setImg(Integer image)
    {
        this.imgmisamigos = imgmisamigos;
    }

    public String getTitle(){

        return titulomisamigos;
    }

    public void setTitle(String title){
        this.titulomisamigos = titulomisamigos;
    }

 

    public String getTelefono(){
        return telefonomisamigos;
    }

    public void setTelefono(String telefonomisanuncios){
        this. telefonomisamigos= telefonomisanuncios;
    }


}
