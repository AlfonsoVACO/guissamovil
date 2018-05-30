package guissa.com.guissamexico.modelo;


public class Patrocinador {

    private Integer idPatrocinador;
    private String nombre;
    private String localizacion;
    private String web;
    private byte[] imagen;
    private User idUser;

    public Patrocinador() {
    }

    public Patrocinador(Integer idPatrocinador) {
        this.idPatrocinador = idPatrocinador;
    }

    public Patrocinador(Integer idPatrocinador, String nombre, String localizacion, String web, byte[] imagen) {
        this.idPatrocinador = idPatrocinador;
        this.nombre = nombre;
        this.localizacion = localizacion;
        this.web = web;
        this.imagen = imagen;
    }

    public Integer getIdPatrocinador() {
        return idPatrocinador;
    }

    public void setIdPatrocinador(Integer idPatrocinador) {
        this.idPatrocinador = idPatrocinador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
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
        hash += (idPatrocinador != null ? idPatrocinador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patrocinador)) {
            return false;
        }
        Patrocinador other = (Patrocinador) object;
        if ((this.idPatrocinador == null && other.idPatrocinador != null) || (this.idPatrocinador != null && !this.idPatrocinador.equals(other.idPatrocinador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.guissa.guissa.models.entidades.Patrocinador[ idPatrocinador=" + idPatrocinador + " ]";
    }
    
}
