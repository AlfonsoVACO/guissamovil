package guissa.com.guissamexico.modelo;

import java.util.Date;

public class Replicae {

    private Integer idReplica;
    private String nombre;
    private String replica;
    private Date fecha;
    private Comentariose idComentario;

    public Replicae() {
    }

    public Replicae(Integer idReplica) {
        this.idReplica = idReplica;
    }

    public Replicae(Integer idReplica, String nombre, String replica, Date fecha) {
        this.idReplica = idReplica;
        this.nombre = nombre;
        this.replica = replica;
        this.fecha = fecha;
    }

    public Integer getIdReplica() {
        return idReplica;
    }

    public void setIdReplica(Integer idReplica) {
        this.idReplica = idReplica;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getReplica() {
        return replica;
    }

    public void setReplica(String replica) {
        this.replica = replica;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Comentariose getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(Comentariose idComentario) {
        this.idComentario = idComentario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReplica != null ? idReplica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Replicae)) {
            return false;
        }
        Replicae other = (Replicae) object;
        if ((this.idReplica == null && other.idReplica != null) || (this.idReplica != null && !this.idReplica.equals(other.idReplica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.guissa.guissa.models.entidades.Replicae[ idReplica=" + idReplica + " ]";
    }
    
}
