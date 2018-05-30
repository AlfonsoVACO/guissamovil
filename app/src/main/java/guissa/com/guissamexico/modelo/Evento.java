package guissa.com.guissamexico.modelo;

import java.util.Date;
import java.util.List;

public class Evento {

    private Integer idEvento;
    private String nombre;
    private String descripcion;
    private Date fechaI;
    private Date fechaF;
    private List<Comentariose> comentarioseList;
    private Estados idEstado;
    private Imagenev idImagen;
    private Municipios idMunicipio;
    private User idUser;

    public Evento() {
    }

    public Evento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public Evento(Integer idEvento, String nombre, String descripcion, Date fechaI, Date fechaF) {
        this.idEvento = idEvento;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaI = fechaI;
        this.fechaF = fechaF;
    }

    public Integer getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
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

    public Date getFechaI() {
        return fechaI;
    }

    public void setFechaI(Date fechaI) {
        this.fechaI = fechaI;
    }

    public Date getFechaF() {
        return fechaF;
    }

    public void setFechaF(Date fechaF) {
        this.fechaF = fechaF;
    }

    public List<Comentariose> getComentarioseList() {
        return comentarioseList;
    }

    public void setComentarioseList(List<Comentariose> comentarioseList) {
        this.comentarioseList = comentarioseList;
    }

    public Estados getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Estados idEstado) {
        this.idEstado = idEstado;
    }

    public Imagenev getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(Imagenev idImagen) {
        this.idImagen = idImagen;
    }

    public Municipios getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Municipios idMunicipio) {
        this.idMunicipio = idMunicipio;
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
        hash += (idEvento != null ? idEvento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evento)) {
            return false;
        }
        Evento other = (Evento) object;
        if ((this.idEvento == null && other.idEvento != null) || (this.idEvento != null && !this.idEvento.equals(other.idEvento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.guissa.guissa.models.entidades.Evento[ idEvento=" + idEvento + " ]";
    }
    
}
