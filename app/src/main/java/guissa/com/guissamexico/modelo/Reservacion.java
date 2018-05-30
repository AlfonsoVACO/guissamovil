package guissa.com.guissamexico.modelo;

import java.util.Date;

public class Reservacion {

    private Integer idReservacion;
    private String pedido;
    private Date fechaI;
    private Date fechaT;
    private short activo;
    private Negocios idNegocio;
    private Userc idUserC;

    public Reservacion() {
    }

    public Reservacion(Integer idReservacion) {
        this.idReservacion = idReservacion;
    }

    public Reservacion(Integer idReservacion, String pedido, Date fechaI, Date fechaT, short activo) {
        this.idReservacion = idReservacion;
        this.pedido = pedido;
        this.fechaI = fechaI;
        this.fechaT = fechaT;
        this.activo = activo;
    }

    public Integer getIdReservacion() {
        return idReservacion;
    }

    public void setIdReservacion(Integer idReservacion) {
        this.idReservacion = idReservacion;
    }

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }

    public Date getFechaI() {
        return fechaI;
    }

    public void setFechaI(Date fechaI) {
        this.fechaI = fechaI;
    }

    public Date getFechaT() {
        return fechaT;
    }

    public void setFechaT(Date fechaT) {
        this.fechaT = fechaT;
    }

    public short getActivo() {
        return activo;
    }

    public void setActivo(short activo) {
        this.activo = activo;
    }

    public Negocios getIdNegocio() {
        return idNegocio;
    }

    public void setIdNegocio(Negocios idNegocio) {
        this.idNegocio = idNegocio;
    }

    public Userc getIdUserC() {
        return idUserC;
    }

    public void setIdUserC(Userc idUserC) {
        this.idUserC = idUserC;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReservacion != null ? idReservacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservacion)) {
            return false;
        }
        Reservacion other = (Reservacion) object;
        if ((this.idReservacion == null && other.idReservacion != null) || (this.idReservacion != null && !this.idReservacion.equals(other.idReservacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.guissa.guissa.models.entidades.Reservacion[ idReservacion=" + idReservacion + " ]";
    }
    
}
