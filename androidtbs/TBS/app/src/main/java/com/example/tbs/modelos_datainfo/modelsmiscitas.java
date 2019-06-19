package com.example.tbs.modelos_datainfo;

import android.widget.CheckBox;
import android.widget.ImageButton;

public class modelsmiscitas {

    private String nombremiscitas;
    private Integer imagenmiscitas;
    private String descripcionmiscitas;
    private String fechamiscitas;
    private CheckBox checkbox;
 //   private ImageButton llamarmiscita;

    public modelsmiscitas(String title, String descripcirrron, String est, int imagenmiscitas, int coco){

    }
    public modelsmiscitas( String fechamiscitas, String nombremiscitas, String descripcionmiscitas, int imagenmiscitas ){//,ImageButton llamarmiscita){

        this.nombremiscitas= nombremiscitas;
        this.descripcionmiscitas=descripcionmiscitas;
        this.fechamiscitas = fechamiscitas;
    //    this.llamarmiscita= llamarmiscita;
        this.imagenmiscitas=imagenmiscitas;

    }

    public Integer getImg(){

        return imagenmiscitas;
    }
    public void setImg(Integer image)
    {
        this.imagenmiscitas = imagenmiscitas;
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
