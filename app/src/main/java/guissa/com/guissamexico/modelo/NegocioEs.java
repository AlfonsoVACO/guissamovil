package guissa.com.guissamexico.modelo;

public class NegocioEs {

    private Integer idNegocio;
    private String nombre;
    private String direccion;
    private String telefono;
    private String oTelefono;
    private String correo;
    private String descripcion;
    private int visualizacion;
    private Estados idEstado;
    private Municipios idMunicipio;
    private Precios idPrecio;

    public NegocioEs() {
    }

    public NegocioEs(Integer idNegocio) {
        this.idNegocio = idNegocio;
    }

    public NegocioEs(Integer idNegocio, String nombre, String direccion, String telefono, String correo, String descripcion, int visualizacion) {
        this.idNegocio = idNegocio;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.descripcion = descripcion;
        this.visualizacion = visualizacion;
    }

    public Integer getIdNegocio() {
        return idNegocio;
    }

    public void setIdNegocio(Integer idNegocio) {
        this.idNegocio = idNegocio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getOTelefono() {
        return oTelefono;
    }

    public void setOTelefono(String oTelefono) {
        this.oTelefono = oTelefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getVisualizacion() {
        return visualizacion;
    }

    public void setVisualizacion(int visualizacion) {
        this.visualizacion = visualizacion;
    }

    public Estados getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Estados idEstado) {
        this.idEstado = idEstado;
    }

    public Municipios getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Municipios idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public Precios getIdPrecio() {
        return idPrecio;
    }

    public void setIdPrecio(Precios idPrecio) {
        this.idPrecio = idPrecio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNegocio != null ? idNegocio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NegocioEs)) {
            return false;
        }
        NegocioEs other = (NegocioEs) object;
        if ((this.idNegocio == null && other.idNegocio != null) || (this.idNegocio != null && !this.idNegocio.equals(other.idNegocio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.guissa.guissa.models.entidades.NegocioEs[ idNegocio=" + idNegocio + " ]";
    }
    
}
