package com.example.tbs.productoprincipal;

public class models {
    //models es el datainfo del ingeniero


    private String id,vendedor,nombre,descripcion,categoria,estado,registro;
    private Double lat,log;
    private String stock;
    private String foto, precio;
    private Boolean checkbox;

    public Boolean getCheckbox(){
        return checkbox;
    }
    public void setCheckbox(Boolean checkbox){
        this.checkbox=checkbox;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLog() {
        return log;
    }

    public void setLog(Double log) {
        this.log = log;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }




/*
    private Integer imgmisanuncios;
    private String titulomisanuncios;
    private String costomisanuncios;
    private String telefonomisanuncios;
    private String descripcionmisanuncios;


    public models(String title, String descripcirrron, String est, int coco){

    }
    public models( String titulomisanuncios, String descripcionmisanuncios, String costomisanuncios, String telefonomisanuncios, int imgmisanuncios){

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
*/

}
