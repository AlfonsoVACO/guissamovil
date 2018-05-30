package guissa.com.guissamexico.modelo;

import java.util.Date;

public class Reservags {

    private Long idVentas;
    private int contador;
    private Date fecha;
    private Negocios idNegocio;

    public Reservags() {
    }

    public Reservags(Long idVentas) {
        this.idVentas = idVentas;
    }

    public Reservags(Long idVentas, int contador) {
        this.idVentas = idVentas;
        this.contador = contador;
    }

    public Long getIdVentas() {
        return idVentas;
    }

    public void setIdVentas(Long idVentas) {
        this.idVentas = idVentas;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
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
        hash += (idVentas != null ? idVentas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservags)) {
            return false;
        }
        Reservags other = (Reservags) object;
        if ((this.idVentas == null && other.idVentas != null) || (this.idVentas != null && !this.idVentas.equals(other.idVentas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.guissa.guissa.models.entidades.Reservags[ idVentas=" + idVentas + " ]";
    }
    
}
