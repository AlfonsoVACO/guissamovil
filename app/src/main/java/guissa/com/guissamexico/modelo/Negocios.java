package guissa.com.guissamexico.modelo;

import java.util.Date;
import java.util.List;

public class Negocios {

    private Integer idNegocio;
    private String nombre;
    private String direccion;
    private String telefono;
    private String telefono2;
    private String descripcion;
    private int visualizacion;
    private int estado;
    private Date fecha;
    private List<Imagennegocios> imagennegociosList;
    private Estados idEstado;
    private Municipios idMunicipio;
    private User idUser;
    private List<Comentariosn> comentariosnList;
    private List<Menurestaurante> menurestauranteList;
    private List<Userc> usercList;
    private List<ContactNegocios> contactNegociosList;
    private List<GaleriaNs> galeriaNsList;
    private List<Reservacion> reservacionList;
    private List<Reservags> reservagsList;
    private List<Comun> comunList;

    private String imagenData;

    public String getImagenData() {
        return imagenData;
    }

    public void setImagenData(String imagenData) {
        this.imagenData = imagenData;
    }

    public Negocios() {
    }

    public Negocios(Integer idNegocio) {
        this.idNegocio = idNegocio;
    }

    public Negocios(Integer idNegocio, String nombre, String direccion, String telefono, String descripcion, int visualizacion, int estado, Date fecha) {
        this.idNegocio = idNegocio;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.descripcion = descripcion;
        this.visualizacion = visualizacion;
        this.estado = estado;
        this.fecha = fecha;
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

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
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

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<Imagennegocios> getImagennegociosList() {
        return imagennegociosList;
    }

    public void setImagennegociosList(List<Imagennegocios> imagennegociosList) {
        this.imagennegociosList = imagennegociosList;
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

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    public List<Comentariosn> getComentariosnList() {
        return comentariosnList;
    }

    public void setComentariosnList(List<Comentariosn> comentariosnList) {
        this.comentariosnList = comentariosnList;
    }

    public List<Menurestaurante> getMenurestauranteList() {
        return menurestauranteList;
    }

    public void setMenurestauranteList(List<Menurestaurante> menurestauranteList) {
        this.menurestauranteList = menurestauranteList;
    }

    public List<Userc> getUsercList() {
        return usercList;
    }

    public void setUsercList(List<Userc> usercList) {
        this.usercList = usercList;
    }

    public List<ContactNegocios> getContactNegociosList() {
        return contactNegociosList;
    }

    public void setContactNegociosList(List<ContactNegocios> contactNegociosList) {
        this.contactNegociosList = contactNegociosList;
    }

    public List<GaleriaNs> getGaleriaNsList() {
        return galeriaNsList;
    }

    public void setGaleriaNsList(List<GaleriaNs> galeriaNsList) {
        this.galeriaNsList = galeriaNsList;
    }

    public List<Reservacion> getReservacionList() {
        return reservacionList;
    }

    public void setReservacionList(List<Reservacion> reservacionList) {
        this.reservacionList = reservacionList;
    }

    public List<Reservags> getReservagsList() {
        return reservagsList;
    }

    public void setReservagsList(List<Reservags> reservagsList) {
        this.reservagsList = reservagsList;
    }

    public List<Comun> getComunList() {
        return comunList;
    }

    public void setComunList(List<Comun> comunList) {
        this.comunList = comunList;
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
        if (!(object instanceof Negocios)) {
            return false;
        }
        Negocios other = (Negocios) object;
        if ((this.idNegocio == null && other.idNegocio != null) || (this.idNegocio != null && !this.idNegocio.equals(other.idNegocio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.guissa.guissa.models.entidades.Negocios[ idNegocio=" + idNegocio + " ]";
    }
    
}
