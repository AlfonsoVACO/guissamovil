package guissa.com.guissamexico.modelo;

import java.util.Date;

public class Resetopass {

    private Integer idResetoPass;
    private String nick;
    private String token;
    private Date creado;
    private User idUser;

    public Resetopass() {
    }

    public Resetopass(Integer idResetoPass) {
        this.idResetoPass = idResetoPass;
    }

    public Resetopass(Integer idResetoPass, String nick, String token, Date creado) {
        this.idResetoPass = idResetoPass;
        this.nick = nick;
        this.token = token;
        this.creado = creado;
    }

    public Integer getIdResetoPass() {
        return idResetoPass;
    }

    public void setIdResetoPass(Integer idResetoPass) {
        this.idResetoPass = idResetoPass;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getCreado() {
        return creado;
    }

    public void setCreado(Date creado) {
        this.creado = creado;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idResetoPass != null ? idResetoPass.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resetopass)) {
            return false;
        }
        Resetopass other = (Resetopass) object;
        if ((this.idResetoPass == null && other.idResetoPass != null) || (this.idResetoPass != null && !this.idResetoPass.equals(other.idResetoPass))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.guissa.guissa.models.entidades.Resetopass[ idResetoPass=" + idResetoPass + " ]";
    }
    
}
