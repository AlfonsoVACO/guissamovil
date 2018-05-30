package guissa.com.guissamexico.modelo;

import java.util.List;

public class Userc {

    private Integer idUserC;
    private String nombre;
    private String apellidos;
    private String correo;
    private String telefono;
    private String direccion;
    private Negocios idNegocio;
    private List<Reservacion> reservacionList;

    public Userc() {
    }

    public Userc(Integer idUserC) {
        this.idUserC = idUserC;
    }

    public Userc(Integer idUserC, String nombre, String apellidos, String correo, String telefono, String direccion) {
        this.idUserC = idUserC;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Integer getIdUserC() {
        return idUserC;
    }

    public void setIdUserC(Integer idUserC) {
        this.idUserC = idUserC;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Negocios getIdNegocio() {
        return idNegocio;
    }

    public void setIdNegocio(Negocios idNegocio) {
        this.idNegocio = idNegocio;
    }

    public List<Reservacion> getReservacionList() {
        return reservacionList;
    }

    public void setReservacionList(List<Reservacion> reservacionList) {
        this.reservacionList = reservacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUserC != null ? idUserC.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userc)) {
            return false;
        }
        Userc other = (Userc) object;
        if ((this.idUserC == null && other.idUserC != null) || (this.idUserC != null && !this.idUserC.equals(other.idUserC))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.guissa.guissa.models.entidades.Userc[ idUserC=" + idUserC + " ]";
    }
    
}
