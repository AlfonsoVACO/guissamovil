/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guissa.com.guissamexico.modelo;

public class Banner {

    private Integer idBanner;
    private String nombre;
    private String subTitle;
    private byte[] imagen;
    private User idUser;

    public Banner() {
    }

    public Banner(Integer idBanner) {
        this.idBanner = idBanner;
    }

    public Banner(Integer idBanner, String nombre, String subTitle, byte[] imagen) {
        this.idBanner = idBanner;
        this.nombre = nombre;
        this.subTitle = subTitle;
        this.imagen = imagen;
    }

    public Integer getIdBanner() {
        return idBanner;
    }

    public void setIdBanner(Integer idBanner) {
        this.idBanner = idBanner;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBanner != null ? idBanner.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Banner)) {
            return false;
        }
        Banner other = (Banner) object;
        if ((this.idBanner == null && other.idBanner != null) || (this.idBanner != null && !this.idBanner.equals(other.idBanner))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.guissa.guissa.models.entidades.Banner[ idBanner=" + idBanner + " ]";
    }
    
}
