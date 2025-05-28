package org.steven.prManejosdeSesiones.models;

public class Categoria {
    //implementar e incializar las variables de objeto
    //encapsulamiento
    private int idCategoria;
    private String nombre;
    private String descripcion;
    private int condicion;
    public Categoria() {


    }
    public Categoria(int idCategoria, String nombre, String descripcion, int condicion) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.condicion = condicion;
    }
    //implementar los getters y setters

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
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

    public int getCondicion() {
        return condicion;
    }

    public void setCondicion(int condicion) {
        this.condicion = condicion;
    }
}
