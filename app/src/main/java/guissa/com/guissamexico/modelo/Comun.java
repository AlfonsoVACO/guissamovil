package guissa.com.guissamexico.modelo;


public class Comun  {

    private Integer idComun;
    private String descripcion;
    private Negocios idNegocio;

    public Comun() {
    }

    public Comun(Integer idComun) {
        this.idComun = idComun;
    }

    public Comun(Integer idComun, String descripcion) {
        this.idComun = idComun;
        this.descripcion = descripcion;
    }

    public Integer getIdComun() {
        return idComun;
    }

    public void setIdComun(Integer idComun) {
        this.idComun = idComun;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        hash += (idComun != null ? idComun.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comun)) {
            return false;
        }
        Comun other = (Comun) object;
        if ((this.idComun == null && other.idComun != null) || (this.idComun != null && !this.idComun.equals(other.idComun))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.guissa.guissa.models.entidades.Comun[ idComun=" + idComun + " ]";
    }
    
}
