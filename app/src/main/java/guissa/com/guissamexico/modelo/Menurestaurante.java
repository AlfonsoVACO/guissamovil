package guissa.com.guissamexico.modelo;

import java.util.List;

public class Menurestaurante {

    private Integer idItem;
    private String nombre;
    private String menu;
    private double precio;
    private String categoria;
    private List<Imagenmenurestaurante> imagenmenurestauranteList;
    private Negocios idNegocio;

    public Menurestaurante() {
    }

    public Menurestaurante(Integer idItem) {
        this.idItem = idItem;
    }

    public Menurestaurante(Integer idItem, String nombre, String menu, double precio, String categoria) {
        this.idItem = idItem;
        this.nombre = nombre;
        this.menu = menu;
        this.precio = precio;
        this.categoria = categoria;
    }

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<Imagenmenurestaurante> getImagenmenurestauranteList() {
        return imagenmenurestauranteList;
    }

    public void setImagenmenurestauranteList(List<Imagenmenurestaurante> imagenmenurestauranteList) {
        this.imagenmenurestauranteList = imagenmenurestauranteList;
    }

    public Negocios getIdNegocio() {
        return idNegocio;
    }

    public void setIdNegocio(Negocios idNegocio) {
        this.idNegocio = idNegocio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idItem != null ? idItem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menurestaurante)) {
            return false;
        }
        Menurestaurante other = (Menurestaurante) object;
        if ((this.idItem == null && other.idItem != null) || (this.idItem != null && !this.idItem.equals(other.idItem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.guissa.guissa.models.entidades.Menurestaurante[ idItem=" + idItem + " ]";
    }
    
}
