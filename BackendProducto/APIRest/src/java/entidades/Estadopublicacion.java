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
@Table(name = "estadopublicacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estadopublicacion.findAll", query = "SELECT e FROM Estadopublicacion e")
    , @NamedQuery(name = "Estadopublicacion.findByIdestadopublicacion", query = "SELECT e FROM Estadopublicacion e WHERE e.idestadopublicacion = :idestadopublicacion")
    , @NamedQuery(name = "Estadopublicacion.findByDescripcion", query = "SELECT e FROM Estadopublicacion e WHERE e.descripcion = :descripcion")})
public class Estadopublicacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idestadopublicacion")
    private Integer idestadopublicacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idestadopublicacion")
    private Collection<Publicacion> publicacionCollection;

    public Estadopublicacion() {
    }

    public Estadopublicacion(Integer idestadopublicacion) {
        this.idestadopublicacion = idestadopublicacion;
    }

    public Estadopublicacion(Integer idestadopublicacion, String descripcion) {
        this.idestadopublicacion = idestadopublicacion;
        this.descripcion = descripcion;
    }

    public Integer getIdestadopublicacion() {
        return idestadopublicacion;
    }

    public void setIdestadopublicacion(Integer idestadopublicacion) {
        this.idestadopublicacion = idestadopublicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        hash += (idestadopublicacion != null ? idestadopublicacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadopublicacion)) {
            return false;
        }
        Estadopublicacion other = (Estadopublicacion) object;
        if ((this.idestadopublicacion == null && other.idestadopublicacion != null) || (this.idestadopublicacion != null && !this.idestadopublicacion.equals(other.idestadopublicacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Estadopublicacion[ idestadopublicacion=" + idestadopublicacion + " ]";
    }
    
}
