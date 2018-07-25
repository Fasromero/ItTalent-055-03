/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author david
 */
@Entity
@Table(name = "reaccionpublicacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reaccionpublicacion.findAll", query = "SELECT r FROM Reaccionpublicacion r")
    , @NamedQuery(name = "Reaccionpublicacion.findByIdpublicacion", query = "SELECT r FROM Reaccionpublicacion r WHERE r.reaccionpublicacionPK.idpublicacion = :idpublicacion")
    , @NamedQuery(name = "Reaccionpublicacion.findByIdusuario", query = "SELECT r FROM Reaccionpublicacion r WHERE r.reaccionpublicacionPK.idusuario = :idusuario")
    , @NamedQuery(name = "Reaccionpublicacion.findByPuntajeobtenido", query = "SELECT r FROM Reaccionpublicacion r WHERE r.puntajeobtenido = :puntajeobtenido")
    , @NamedQuery(name = "Reaccionpublicacion.findByFechahora", query = "SELECT r FROM Reaccionpublicacion r WHERE r.fechahora = :fechahora")})
public class Reaccionpublicacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReaccionpublicacionPK reaccionpublicacionPK;
    @Column(name = "puntajeobtenido")
    private Integer puntajeobtenido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechahora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechahora;
    @JoinColumn(name = "idpublicacion", referencedColumnName = "idpublicacion", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Publicacion publicacion;
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "idtiporeaccion", referencedColumnName = "idtiporeaccion")
    @ManyToOne(optional = false)
    private Tiporeaccion idtiporeaccion;

    public Reaccionpublicacion() {
    }

    public Reaccionpublicacion(ReaccionpublicacionPK reaccionpublicacionPK) {
        this.reaccionpublicacionPK = reaccionpublicacionPK;
    }

    public Reaccionpublicacion(ReaccionpublicacionPK reaccionpublicacionPK, Date fechahora) {
        this.reaccionpublicacionPK = reaccionpublicacionPK;
        this.fechahora = fechahora;
    }

    public Reaccionpublicacion(int idpublicacion, int idusuario) {
        this.reaccionpublicacionPK = new ReaccionpublicacionPK(idpublicacion, idusuario);
    }

    public ReaccionpublicacionPK getReaccionpublicacionPK() {
        return reaccionpublicacionPK;
    }

    public void setReaccionpublicacionPK(ReaccionpublicacionPK reaccionpublicacionPK) {
        this.reaccionpublicacionPK = reaccionpublicacionPK;
    }

    public Integer getPuntajeobtenido() {
        return puntajeobtenido;
    }

    public void setPuntajeobtenido(Integer puntajeobtenido) {
        this.puntajeobtenido = puntajeobtenido;
    }

    public Date getFechahora() {
        return fechahora;
    }

    public void setFechahora(Date fechahora) {
        this.fechahora = fechahora;
    }

    public Publicacion getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Tiporeaccion getIdtiporeaccion() {
        return idtiporeaccion;
    }

    public void setIdtiporeaccion(Tiporeaccion idtiporeaccion) {
        this.idtiporeaccion = idtiporeaccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reaccionpublicacionPK != null ? reaccionpublicacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reaccionpublicacion)) {
            return false;
        }
        Reaccionpublicacion other = (Reaccionpublicacion) object;
        if ((this.reaccionpublicacionPK == null && other.reaccionpublicacionPK != null) || (this.reaccionpublicacionPK != null && !this.reaccionpublicacionPK.equals(other.reaccionpublicacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Reaccionpublicacion[ reaccionpublicacionPK=" + reaccionpublicacionPK + " ]";
    }
    
}
