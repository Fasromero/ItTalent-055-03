/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author david
 */
@Entity
@Table(name = "humedal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Humedal.findAll", query = "SELECT h FROM Humedal h")
    , @NamedQuery(name = "Humedal.findByIdhumedal", query = "SELECT h FROM Humedal h WHERE h.idhumedal = :idhumedal")
    , @NamedQuery(name = "Humedal.findByNombre", query = "SELECT h FROM Humedal h WHERE h.nombre = :nombre")
    , @NamedQuery(name = "Humedal.findByDescripcion", query = "SELECT h FROM Humedal h WHERE h.descripcion = :descripcion")
    , @NamedQuery(name = "Humedal.findByLatitud", query = "SELECT h FROM Humedal h WHERE h.latitud = :latitud")
    , @NamedQuery(name = "Humedal.findByLongitud", query = "SELECT h FROM Humedal h WHERE h.longitud = :longitud")})
public class Humedal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idhumedal")
    private Integer idhumedal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @Lob
    @Column(name = "imghumedal")
    private byte[] imghumedal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "latitud")
    private long latitud;
    @Basic(optional = false)
    @NotNull
    @Column(name = "longitud")
    private long longitud;
    @JoinColumn(name = "idlocalidad", referencedColumnName = "idlocalidad")
    @ManyToOne(optional = false)
    private Localidad idlocalidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idhumedal")
    private Collection<Publicacion> publicacionCollection;

    public Humedal() {
    }

    public Humedal(Integer idhumedal) {
        this.idhumedal = idhumedal;
    }

    public Humedal(Integer idhumedal, String nombre, String descripcion, long latitud, long longitud) {
        this.idhumedal = idhumedal;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public Integer getIdhumedal() {
        return idhumedal;
    }

    public void setIdhumedal(Integer idhumedal) {
        this.idhumedal = idhumedal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public byte[] getImghumedal() {
        return imghumedal;
    }

    public void setImghumedal(byte[] imghumedal) {
        this.imghumedal = imghumedal;
    }

    public long getLatitud() {
        return latitud;
    }

    public void setLatitud(long latitud) {
        this.latitud = latitud;
    }

    public long getLongitud() {
        return longitud;
    }

    public void setLongitud(long longitud) {
        this.longitud = longitud;
    }

    public Localidad getIdlocalidad() {
        return idlocalidad;
    }

    public void setIdlocalidad(Localidad idlocalidad) {
        this.idlocalidad = idlocalidad;
    }

    @XmlTransient
    public Collection<Publicacion> getPublicacionCollection() {
        return publicacionCollection;
    }

    public void setPublicacionCollection(Collection<Publicacion> publicacionCollection) {
        this.publicacionCollection = publicacionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idhumedal != null ? idhumedal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Humedal)) {
            return false;
        }
        Humedal other = (Humedal) object;
        if ((this.idhumedal == null && other.idhumedal != null) || (this.idhumedal != null && !this.idhumedal.equals(other.idhumedal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Humedal[ idhumedal=" + idhumedal + " ]";
    }
    
}
