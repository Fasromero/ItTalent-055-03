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
@Table(name = "tipopublicacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipopublicacion.findAll", query = "SELECT t FROM Tipopublicacion t")
    , @NamedQuery(name = "Tipopublicacion.findByIdtipopublicacion", query = "SELECT t FROM Tipopublicacion t WHERE t.idtipopublicacion = :idtipopublicacion")
    , @NamedQuery(name = "Tipopublicacion.findByNombre", query = "SELECT t FROM Tipopublicacion t WHERE t.nombre = :nombre")})
public class Tipopublicacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipopublicacion")
    private Integer idtipopublicacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipopublicacion")
    private Collection<Publicacion> publicacionCollection;

    public Tipopublicacion() {
    }

    public Tipopublicacion(Integer idtipopublicacion) {
        this.idtipopublicacion = idtipopublicacion;
    }

    public Tipopublicacion(Integer idtipopublicacion, String nombre) {
        this.idtipopublicacion = idtipopublicacion;
        this.nombre = nombre;
    }

    public Integer getIdtipopublicacion() {
        return idtipopublicacion;
    }

    public void setIdtipopublicacion(Integer idtipopublicacion) {
        this.idtipopublicacion = idtipopublicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        hash += (idtipopublicacion != null ? idtipopublicacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipopublicacion)) {
            return false;
        }
        Tipopublicacion other = (Tipopublicacion) object;
        if ((this.idtipopublicacion == null && other.idtipopublicacion != null) || (this.idtipopublicacion != null && !this.idtipopublicacion.equals(other.idtipopublicacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Tipopublicacion[ idtipopublicacion=" + idtipopublicacion + " ]";
    }
    
}
