package com.example.tbs;

import android.widget.ImageButton;

public class modelsmiscitas {

    private String nombremiscitas;
    private Integer imgmiscitas;
    private String descripcionmiscitas;
    private String fechamiscitas;
 //   private ImageButton llamarmiscita;

    public modelsmiscitas(String title, String descripcirrron, String est, int imgmiscitas, int coco){

    }
    public modelsmiscitas( String fechamiscitas, String nombremiscitas, String descripcionmiscitas, int imgmiscitas ){//,ImageButton llamarmiscita){

        this.nombremiscitas= nombremiscitas;
        this.descripcionmiscitas=descripcionmiscitas;
        this.fechamiscitas = fechamiscitas;
    //    this.llamarmiscita= llamarmiscita;
        this.imgmiscitas=imgmiscitas;

    }

    public Integer getImg(){

        return imgmiscitas;
    }
    public void setImg(Integer image)
    {
        this.imgmiscitas = imgmiscitas;
    }

    public String getTitle(){

        return nombremiscitas;
    }

    public void setTitle(String title){
        this.nombremiscitas = nombremiscitas;
    }

    public String getDescripcion(){

        return descripcionmiscitas;
    }

    public void setDescripcion(String descripcionmiscitas){
        this.descripcionmiscitas = descripcionmiscitas;
    }

    public String getFechamiscitas(){
        return fechamiscitas;
    }

    public void setFechamiscitas(String fechamiscitas){
        this. fechamiscitas= fechamiscitas;
    }

 /*   public  ImageButton getLlamada(){
        return  llamarmiscita;
    }

    public void setLlamada(ImageButton llamarmiscita){
        this.llamarmiscita=llamarmiscita;
    }
*/

}
