package guissa.com.guissamexico.modelo;

import java.util.List;

public class Municipios {

    private Integer idMunicipio;
    private String nombreMun;
    private List<Producto> productoList;
    private List<Negocios> negociosList;
    private List<Evento> eventoList;
    private List<NegocioEs> negocioEsList;

    public Municipios() {
    }

    public Municipios(Integer idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public Municipios(Integer idMunicipio, String nombreMun) {
        this.idMunicipio = idMunicipio;
        this.nombreMun = nombreMun;
    }

    public Integer getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Integer idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getNombreMun() {
        return nombreMun;
    }

    public void setNombreMun(String nombreMun) {
        this.nombreMun = nombreMun;
    }

    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    public List<Negocios> getNegociosList() {
        return negociosList;
    }

    public void setNegociosList(List<Negocios> negociosList) {
        this.negociosList = negociosList;
    }

    public List<Evento> getEventoList() {
        return eventoList;
    }

    public void setEventoList(List<Evento> eventoList) {
        this.eventoList = eventoList;
    }

    public List<NegocioEs> getNegocioEsList() {
        return negocioEsList;
    }

    public void setNegocioEsList(List<NegocioEs> negocioEsList) {
        this.negocioEsList = negocioEsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMunicipio != null ? idMunicipio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Municipios)) {
            return false;
        }
        Municipios other = (Municipios) object;
        if ((this.idMunicipio == null && other.idMunicipio != null) || (this.idMunicipio != null && !this.idMunicipio.equals(other.idMunicipio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.guissa.guissa.models.entidades.Municipios[ idMunicipio=" + idMunicipio + " ]";
    }
    
}
