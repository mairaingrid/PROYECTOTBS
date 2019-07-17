package com.example.tbs.cambiado;

public class modelsperfil {
    private Integer imgmisanuncios;
    private String titulomisanuncios;
    private String costomisanuncios;
    private String cantidad;
    private String descripcionmisanuncios;
    private String categoria;
    private Integer imagecitas;
    private Integer imagemensaje;
    private Boolean imgfavorito;

/*
    holder.imagecita.setImageResource(listaa.get(position.getButtoCita());
        holder.imafavorito.setChecked(listaa.get(position).getCheck()); ;
        holder.imagetxt.setImageResource(listaa.get(position).getButtonTxt());
    imagecita= (ImageButton) itemView.findViewById(R.id.imagecitas);
    imafavorito= (CheckBox) itemView.findViewById(R.id.imgfavorito);
    imagetxt= (ImageButton)itemView.findViewById(R.id.imagemensaje);
*/

    public modelsperfil(Integer imagecitas, Integer imagemensaje, Boolean imgfavorito, String titulomisanuncios, String descripcionmisanuncios, String costomisanuncios, String categoria, String cantidad, int imgmisanuncios) {

        this.titulomisanuncios = titulomisanuncios;
        this.descripcionmisanuncios = descripcionmisanuncios;
        this.costomisanuncios = costomisanuncios;
        this.cantidad = cantidad;
        this.categoria = categoria;
        this.imgmisanuncios = imgmisanuncios;
        this.imagecitas = imagecitas;
        this.imagemensaje = imagemensaje;
        this.imgfavorito = imgfavorito;

    }

    public String getCantidad() {

        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getImg() {

        return imgmisanuncios;
    }

    public void setImg(Integer image) {
        this.imgmisanuncios = imgmisanuncios;
    }

    public String getTitle() {

        return titulomisanuncios;
    }

    public void setTitle(String title) {
        this.titulomisanuncios = titulomisanuncios;
    }

    public String getDescripcion() {

        return descripcionmisanuncios;
    }

    public void setDescripcion(String descripcionmisanuncios) {
        this.descripcionmisanuncios = descripcionmisanuncios;
    }

    /*    public String getTelefono(){
            return telefonomisanuncios;
        }

        public void setTelefono(String telefonomisanuncios){
            this. telefonomisanuncios= telefonomisanuncios;
        }
    */
    public String getCosto() {
        return costomisanuncios;
    }

    public void setCosto(String costomisanuncios) {
        this.costomisanuncios = costomisanuncios;
    }


    public String getCategoria() {

        return categoria;
    }

    public void setCategoria(String cateogoria) {
        this.categoria = categoria;
    }

    /*     this.imagecitas=imagecitas;
          this.imagemensaje= imagemensaje;
          this.imgfavorito=imgfavorito;
  */
    public Integer getImagecitas() {
        return imagecitas;
    }

    public void setImagecitas(Integer imagecitas) {
        this.imagecitas = imagecitas;
    }

    public Integer getImagemensaje() {
        return imagemensaje;
    }

    public void setImagemensaje(Integer imagemensaje) {
        this.imagemensaje = imagemensaje;
    }

    public Boolean getImagefavorito() {
        return imgfavorito;
    }

    public void setImgfavorito(Boolean check) {
        this.imgfavorito = check;
    }

}
