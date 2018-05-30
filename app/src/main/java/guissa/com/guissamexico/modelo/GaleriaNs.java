package guissa.com.guissamexico.modelo;

public class GaleriaNs {

    private Integer idImagen;
    private String nombre;
    private String nombreimg;
    private String tipo;
    private byte[] imagen;
    private Negocios idNegocio;

    public GaleriaNs() {
    }

    public GaleriaNs(Integer idImagen) {
        this.idImagen = idImagen;
    }

    public GaleriaNs(Integer idImagen, String nombre, String nombreimg, String tipo, byte[] imagen) {
        this.idImagen = idImagen;
        this.nombre = nombre;
        this.nombreimg = nombreimg;
        this.tipo = tipo;
        this.imagen = imagen;
    }

    public Integer getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(Integer idImagen) {
        this.idImagen = idImagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreimg() {
        return nombreimg;
    }

    public void setNombreimg(String nombreimg) {
        this.nombreimg = nombreimg;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
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
        hash += (idImagen != null ? idImagen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GaleriaNs)) {
            return false;
        }
        GaleriaNs other = (GaleriaNs) object;
        if ((this.idImagen == null && other.idImagen != null) || (this.idImagen != null && !this.idImagen.equals(other.idImagen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.guissa.guissa.models.entidades.GaleriaNs[ idImagen=" + idImagen + " ]";
    }
    
}
