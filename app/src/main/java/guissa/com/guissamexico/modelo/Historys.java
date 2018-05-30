package guissa.com.guissamexico.modelo;

public class Historys {

    private Integer idHistory;
    private String nombreH;
    private String nombre;
    private String tipo;
    private String temporada;
    private String municipio;
    private String descripcion;
    private int estado;

    public Historys() {
    }

    public Historys(Integer idHistory) {
        this.idHistory = idHistory;
    }

    public Historys(Integer idHistory, String nombreH, String nombre, String tipo, String temporada, String municipio, String descripcion, int estado) {
        this.idHistory = idHistory;
        this.nombreH = nombreH;
        this.nombre = nombre;
        this.tipo = tipo;
        this.temporada = temporada;
        this.municipio = municipio;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Integer getIdHistory() {
        return idHistory;
    }

    public void setIdHistory(Integer idHistory) {
        this.idHistory = idHistory;
    }

    public String getNombreH() {
        return nombreH;
    }

    public void setNombreH(String nombreH) {
        this.nombreH = nombreH;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHistory != null ? idHistory.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Historys)) {
            return false;
        }
        Historys other = (Historys) object;
        if ((this.idHistory == null && other.idHistory != null) || (this.idHistory != null && !this.idHistory.equals(other.idHistory))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.guissa.guissa.models.entidades.Historys[ idHistory=" + idHistory + " ]";
    }
    
}
