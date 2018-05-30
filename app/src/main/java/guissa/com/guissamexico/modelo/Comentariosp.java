package guissa.com.guissamexico.modelo;

import java.util.Date;
import java.util.List;

public class Comentariosp  {

    private Integer idComentario;
    private String nombre;
    private String comentario;
    private Date fecha;
    private Producto idProducto;
    private List<Replicap> replicapList;

    public Comentariosp() {
    }

    public Comentariosp(Integer idComentario) {
        this.idComentario = idComentario;
    }

    public Comentariosp(Integer idComentario, String nombre, String comentario, Date fecha) {
        this.idComentario = idComentario;
        this.nombre = nombre;
        this.comentario = comentario;
        this.fecha = fecha;
    }

    public Integer getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(Integer idComentario) {
        this.idComentario = idComentario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public List<Replicap> getReplicapList() {
        return replicapList;
    }

    public void setReplicapList(List<Replicap> replicapList) {
        this.replicapList = replicapList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComentario != null ? idComentario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comentariosp)) {
            return false;
        }
        Comentariosp other = (Comentariosp) object;
        if ((this.idComentario == null && other.idComentario != null) || (this.idComentario != null && !this.idComentario.equals(other.idComentario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.guissa.guissa.models.entidades.Comentariosp[ idComentario=" + idComentario + " ]";
    }
    
}
