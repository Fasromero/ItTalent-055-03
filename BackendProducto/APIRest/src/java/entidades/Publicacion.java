/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author david
 */
@Entity
@Table(name = "publicacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Publicacion.findAll", query = "SELECT p FROM Publicacion p")
    , @NamedQuery(name = "Publicacion.findByIdpublicacion", query = "SELECT p FROM Publicacion p WHERE p.idpublicacion = :idpublicacion")
    , @NamedQuery(name = "Publicacion.findByFechahora", query = "SELECT p FROM Publicacion p WHERE p.fechahora = :fechahora")
    , @NamedQuery(name = "Publicacion.findByTitulo", query = "SELECT p FROM Publicacion p WHERE p.titulo = :titulo")
    , @NamedQuery(name = "Publicacion.findByContenido", query = "SELECT p FROM Publicacion p WHERE p.contenido = :contenido")
    , @NamedQuery(name = "Publicacion.findByTags", query = "SELECT p FROM Publicacion p WHERE p.tags = :tags")
    , @NamedQuery(name = "Publicacion.findByPuntaje", query = "SELECT p FROM Publicacion p WHERE p.puntaje = :puntaje")})
public class Publicacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpublicacion")
    private Integer idpublicacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechahora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechahora;
    @Size(max = 30)
    @Column(name = "titulo")
    private String titulo;
    @Size(max = 500)
    @Column(name = "contenido")
    private String contenido;
    @Size(max = 50)
    @Column(name = "tags")
    private String tags;
    @Column(name = "puntaje")
    private Integer puntaje;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpublicacion")
    private Collection<Detallepublicacion> detallepublicacionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "publicacion")
    private Collection<Reaccionpublicacion> reaccionpublicacionCollection;
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idusuario;
    @JoinColumn(name = "idtipopublicacion", referencedColumnName = "idtipopublicacion")
    @ManyToOne(optional = false)
    private Tipopublicacion idtipopublicacion;
    @JoinColumn(name = "idhumedal", referencedColumnName = "idhumedal")
    @ManyToOne(optional = false)
    private Humedal idhumedal;
    @JoinColumn(name = "idestadopublicacion", referencedColumnName = "idestadopublicacion")
    @ManyToOne(optional = false)
    private Estadopublicacion idestadopublicacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpublicacionpadre")
    private Collection<Publicacion> publicacionCollection;
    @JoinColumn(name = "idpublicacionpadre", referencedColumnName = "idpublicacion")
    @ManyToOne(optional = false)
    private Publicacion idpublicacionpadre;

    public Publicacion() {
    }

    public Publicacion(Integer idpublicacion) {
        this.idpublicacion = idpublicacion;
    }

    public Publicacion(Integer idpublicacion, Date fechahora) {
        this.idpublicacion = idpublicacion;
        this.fechahora = fechahora;
    }

    public Integer getIdpublicacion() {
        return idpublicacion;
    }

    public void setIdpublicacion(Integer idpublicacion) {
        this.idpublicacion = idpublicacion;
    }

    public Date getFechahora() {
        return fechahora;
    }

    public void setFechahora(Date fechahora) {
        this.fechahora = fechahora;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Integer getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }

    @XmlTransient
    public Collection<Detallepublicacion> getDetallepublicacionCollection() {
        return detallepublicacionCollection;
    }

    public void setDetallepublicacionCollection(Collection<Detallepublicacion> detallepublicacionCollection) {
        this.detallepublicacionCollection = detallepublicacionCollection;
    }

    @XmlTransient
    public Collection<Reaccionpublicacion> getReaccionpublicacionCollection() {
        return reaccionpublicacionCollection;
    }

    public void setReaccionpublicacionCollection(Collection<Reaccionpublicacion> reaccionpublicacionCollection) {
        this.reaccionpublicacionCollection = reaccionpublicacionCollection;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    public Tipopublicacion getIdtipopublicacion() {
        return idtipopublicacion;
    }

    public void setIdtipopublicacion(Tipopublicacion idtipopublicacion) {
        this.idtipopublicacion = idtipopublicacion;
    }

    public Humedal getIdhumedal() {
        return idhumedal;
    }

    public void setIdhumedal(Humedal idhumedal) {
        this.idhumedal = idhumedal;
    }

    public Estadopublicacion getIdestadopublicacion() {
        return idestadopublicacion;
    }

    public void setIdestadopublicacion(Estadopublicacion idestadopublicacion) {
        this.idestadopublicacion = idestadopublicacion;
    }

    @XmlTransient
    public Collection<Publicacion> getPublicacionCollection() {
        return publicacionCollection;
    }

    public void setPublicacionCollection(Collection<Publicacion> publicacionCollection) {
        this.publicacionCollection = publicacionCollection;
    }

    public Publicacion getIdpublicacionpadre() {
        return idpublicacionpadre;
    }

    public void setIdpublicacionpadre(Publicacion idpublicacionpadre) {
        this.idpublicacionpadre = idpublicacionpadre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpublicacion != null ? idpublicacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Publicacion)) {
            return false;
        }
        Publicacion other = (Publicacion) object;
        if ((this.idpublicacion == null && other.idpublicacion != null) || (this.idpublicacion != null && !this.idpublicacion.equals(other.idpublicacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Publicacion[ idpublicacion=" + idpublicacion + " ]";
    }
    
}
