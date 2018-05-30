package guissa.com.guissamexico.modelo;

import java.util.Date;
import java.util.List;

public class Comentariosn {

    private Integer idComentario;
    private String nombre;
    private String comentario;
    private Date fecha;
    private int estado;
    private Negocios idNegocio;
    private List<Replican> replicanList;

    public Comentariosn() {
    }

    public Comentariosn(Integer idComentario) {
        this.idComentario = idComentario;
    }

    public Comentariosn(Integer idComentario, String nombre, String comentario, Date fecha, int estado) {
        this.idComentario = idComentario;
        this.nombre = nombre;
        this.comentario = comentario;
        this.fecha = fecha;
        this.estado = estado;
    }

    public Integer getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(Integer idComentario) {
        this.idComentario = idComentario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Negocios getIdNegocio() {
        return idNegocio;
    }

    public void setIdNegocio(Negocios idNegocio) {
        this.idNegocio = idNegocio;
    }

    public List<Replican> getReplicanList() {
        return replicanList;
    }

    public void setReplicanList(List<Replican> replicanList) {
        this.replicanList = replicanList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComentario != null ? idComentario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comentariosn)) {
            return false;
        }
        Comentariosn other = (Comentariosn) object;
        if ((this.idComentario == null && other.idComentario != null) || (this.idComentario != null && !this.idComentario.equals(other.idComentario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.guissa.guissa.models.entidades.Comentariosn[ idComentario=" + idComentario + " ]";
    }
    
}
