package guissa.com.guissamexico.modelo;

import java.util.List;

public class Temporadas {

    private Integer idTemporada;
    private String descripcionT;
    private List<Producto> productoList;

    public Temporadas() {
    }

    public Temporadas(Integer idTemporada) {
        this.idTemporada = idTemporada;
    }

    public Temporadas(Integer idTemporada, String descripcionT) {
        this.idTemporada = idTemporada;
        this.descripcionT = descripcionT;
    }

    public Integer getIdTemporada() {
        return idTemporada;
    }

    public void setIdTemporada(Integer idTemporada) {
        this.idTemporada = idTemporada;
    }

    public String getDescripcionT() {
        return descripcionT;
    }

    public void setDescripcionT(String descripcionT) {
        this.descripcionT = descripcionT;
    }

    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTemporada != null ? idTemporada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Temporadas)) {
            return false;
        }
        Temporadas other = (Temporadas) object;
        if ((this.idTemporada == null && other.idTemporada != null) || (this.idTemporada != null && !this.idTemporada.equals(other.idTemporada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.guissa.guissa.models.entidades.Temporadas[ idTemporada=" + idTemporada + " ]";
    }
    
}
