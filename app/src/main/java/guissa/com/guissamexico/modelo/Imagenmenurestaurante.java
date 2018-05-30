package guissa.com.guissamexico.modelo;

public class Imagenmenurestaurante {

    private Integer idImagen;
    private byte[] imagen;
    private Menurestaurante idItem;

    public Imagenmenurestaurante() {
    }

    public Imagenmenurestaurante(Integer idImagen) {
        this.idImagen = idImagen;
    }

    public Imagenmenurestaurante(Integer idImagen, byte[] imagen) {
        this.idImagen = idImagen;
        this.imagen = imagen;
    }

    public Integer getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(Integer idImagen) {
        this.idImagen = idImagen;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public Menurestaurante getIdItem() {
        return idItem;
    }

    public void setIdItem(Menurestaurante idItem) {
        this.idItem = idItem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idImagen != null ? idImagen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Imagenmenurestaurante)) {
            return false;
        }
        Imagenmenurestaurante other = (Imagenmenurestaurante) object;
        if ((this.idImagen == null && other.idImagen != null) || (this.idImagen != null && !this.idImagen.equals(other.idImagen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.guissa.guissa.models.entidades.Imagenmenurestaurante[ idImagen=" + idImagen + " ]";
    }
    
}
