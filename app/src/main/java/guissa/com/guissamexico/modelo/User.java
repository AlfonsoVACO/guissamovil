package guissa.com.guissamexico.modelo;

import java.util.List;

public class User {

    private Integer idUser;
    private String nombre;
    private String apellidos;
    private String correo;
    private String nic;
    private String pass;
    private byte[] avatar;
    private List<Receta> recetaList;
    private List<Notas> notasList;
    private List<Producto> productoList;
    private List<Negocios> negociosList;
    private List<Evento> eventoList;
    private List<Patrocinador> patrocinadorList;
    private List<Resetopass> resetopassList;
    private List<Banner> bannerList;
    private TipoUsuario idTipousuario;

    public User() {
    }

    public User(Integer idUser) {
        this.idUser = idUser;
    }

    public User(Integer idUser, String nombre, String apellidos, String correo, String nic, String pass, byte[] avatar) {
        this.idUser = idUser;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.nic = nic;
        this.pass = pass;
        this.avatar = avatar;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
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

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public List<Receta> getRecetaList() {
        return recetaList;
    }

    public void setRecetaList(List<Receta> recetaList) {
        this.recetaList = recetaList;
    }

    public List<Notas> getNotasList() {
        return notasList;
    }

    public void setNotasList(List<Notas> notasList) {
        this.notasList = notasList;
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

    public List<Patrocinador> getPatrocinadorList() {
        return patrocinadorList;
    }

    public void setPatrocinadorList(List<Patrocinador> patrocinadorList) {
        this.patrocinadorList = patrocinadorList;
    }

    public List<Resetopass> getResetopassList() {
        return resetopassList;
    }

    public void setResetopassList(List<Resetopass> resetopassList) {
        this.resetopassList = resetopassList;
    }

    public List<Banner> getBannerList() {
        return bannerList;
    }

    public void setBannerList(List<Banner> bannerList) {
        this.bannerList = bannerList;
    }

    public TipoUsuario getIdTipousuario() {
        return idTipousuario;
    }

    public void setIdTipousuario(TipoUsuario idTipousuario) {
        this.idTipousuario = idTipousuario;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUser != null ? idUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.guissa.guissa.models.entidades.User[ idUser=" + idUser + " ]";
    }
    
}
