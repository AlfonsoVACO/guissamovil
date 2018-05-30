package guissa.com.guissamexico.modelo;

import java.util.Date;

public class ContactNegocios {

    private Integer idComentario;
    private String comentario;
    private Date fecha;
    private Negocios idNegocio;

    public ContactNegocios() {
    }

    public ContactNegocios(Integer idComentario) {
        this.idComentario = idComentario;
    }

    public ContactNegocios(Integer idComentario, String comentario, Date fecha) {
        this.idComentario = idComentario;
        this.comentario = comentario;
        this.fecha = fecha;
    }

    public Integer getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(Integer idComentario) {
        this.idComentario = idComentario;
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

    public Negocios getIdNegocio() {
        return idNegocio;
    }

    public void setIdNegocio(Negocios idNegocio) {
        this.idNegocio = idNegocio;
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
        if (!(object instanceof ContactNegocios)) {
            return false;
        }
        ContactNegocios other = (ContactNegocios) object;
        if ((this.idComentario == null && other.idComentario != null) || (this.idComentario != null && !this.idComentario.equals(other.idComentario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.guissa.guissa.models.entidades.ContactNegocios[ idComentario=" + idComentario + " ]";
    }
    
}
