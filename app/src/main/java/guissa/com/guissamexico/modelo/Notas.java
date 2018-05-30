package guissa.com.guissamexico.modelo;

import java.util.Date;

public class Notas {

    private Integer idNota;
    private String nota;
    private Date fecha;
    private User idUser;

    public Notas() {
    }

    public Notas(Integer idNota) {
        this.idNota = idNota;
    }

    public Notas(Integer idNota, String nota, Date fecha) {
        this.idNota = idNota;
        this.nota = nota;
        this.fecha = fecha;
    }

    public Integer getIdNota() {
        return idNota;
    }

    public void setIdNota(Integer idNota) {
        this.idNota = idNota;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
        hash += (idNota != null ? idNota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notas)) {
            return false;
        }
        Notas other = (Notas) object;
        if ((this.idNota == null && other.idNota != null) || (this.idNota != null && !this.idNota.equals(other.idNota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.guissa.guissa.models.entidades.Notas[ idNota=" + idNota + " ]";
    }
    
}
