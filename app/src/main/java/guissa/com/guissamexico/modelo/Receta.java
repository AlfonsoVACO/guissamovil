package guissa.com.guissamexico.modelo;

public class Receta {

    private Integer idReceta;
    private String nombre;
    private String descripcionreceta;
    private Producto idProducto;
    private User idUser;

    public Receta() {
    }

    public Receta(Integer idReceta) {
        this.idReceta = idReceta;
    }

    public Receta(Integer idReceta, String nombre) {
        this.idReceta = idReceta;
        this.nombre = nombre;
    }

    public Integer getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(Integer idReceta) {
        this.idReceta = idReceta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcionreceta() {
        return descripcionreceta;
    }

    public void setDescripcionreceta(String descripcionreceta) {
        this.descripcionreceta = descripcionreceta;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
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
        hash += (idReceta != null ? idReceta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Receta)) {
            return false;
        }
        Receta other = (Receta) object;
        if ((this.idReceta == null && other.idReceta != null) || (this.idReceta != null && !this.idReceta.equals(other.idReceta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.guissa.guissa.models.entidades.Receta[ idReceta=" + idReceta + " ]";
    }
    
}
