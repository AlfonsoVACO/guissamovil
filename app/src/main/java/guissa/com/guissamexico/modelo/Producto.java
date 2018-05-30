package guissa.com.guissamexico.modelo;

import java.util.Date;
import java.util.List;

public class Producto {

    private Integer idProducto;
    private String nombre;
    private String descripcion;
    private Date fechaH;
    private List<Receta> recetaList;
    private Estados idEstado;
    private Municipios idMunicipio;
    private Temporadas idTemporada;
    private Tipo idTipo;
    private User idUser;
    private List<Comentariosp> comentariospList;
    private List<Galeria> galeriaList;

    public Producto() {
    }

    public Producto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Producto(Integer idProducto, String nombre, String descripcion, Date fechaH) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaH = fechaH;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
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

    public Date getFechaH() {
        return fechaH;
    }

    public void setFechaH(Date fechaH) {
        this.fechaH = fechaH;
    }

    public List<Receta> getRecetaList() {
        return recetaList;
    }

    public void setRecetaList(List<Receta> recetaList) {
        this.recetaList = recetaList;
    }

    public Estados getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Estados idEstado) {
        this.idEstado = idEstado;
    }

    public Municipios getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Municipios idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public Temporadas getIdTemporada() {
        return idTemporada;
    }

    public void setIdTemporada(Temporadas idTemporada) {
        this.idTemporada = idTemporada;
    }

    public Tipo getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Tipo idTipo) {
        this.idTipo = idTipo;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    public List<Comentariosp> getComentariospList() {
        return comentariospList;
    }

    public void setComentariospList(List<Comentariosp> comentariospList) {
        this.comentariospList = comentariospList;
    }

    public List<Galeria> getGaleriaList() {
        return galeriaList;
    }

    public void setGaleriaList(List<Galeria> galeriaList) {
        this.galeriaList = galeriaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.guissa.guissa.models.entidades.Producto[ idProducto=" + idProducto + " ]";
    }
    
}
