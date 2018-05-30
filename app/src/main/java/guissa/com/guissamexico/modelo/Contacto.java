package guissa.com.guissamexico.modelo;

import java.util.Date;

public class Contacto {

    private Integer idContacto;
    private String nombre;
    private String correo;
    private String motivo;
    private String mensaje;
    private Date fecha;
    private Integer estado;

    public Contacto() {
    }

    public Contacto(Integer idContacto) {
        this.idContacto = idContacto;
    }

    public Contacto(Integer idContacto, String nombre, String correo, String motivo, Date fecha) {
        this.idContacto = idContacto;
        this.nombre = nombre;
        this.correo = correo;
        this.motivo = motivo;
        this.fecha = fecha;
    }

    public Integer getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(Integer idContacto) {
        this.idContacto = idContacto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idContacto != null ? idContacto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contacto)) {
            return false;
        }
        Contacto other = (Contacto) object;
        if ((this.idContacto == null && other.idContacto != null) || (this.idContacto != null && !this.idContacto.equals(other.idContacto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.guissa.guissa.models.entidades.Contacto[ idContacto=" + idContacto + " ]";
    }
    
}
