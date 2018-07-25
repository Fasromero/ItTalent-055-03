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
import javax.persistence.Lob;
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
@Table(name = "tiporeaccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tiporeaccion.findAll", query = "SELECT t FROM Tiporeaccion t")
    , @NamedQuery(name = "Tiporeaccion.findByIdtiporeaccion", query = "SELECT t FROM Tiporeaccion t WHERE t.idtiporeaccion = :idtiporeaccion")
    , @NamedQuery(name = "Tiporeaccion.findByNombre", query = "SELECT t FROM Tiporeaccion t WHERE t.nombre = :nombre")})
public class Tiporeaccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtiporeaccion")
    private Integer idtiporeaccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "icono")
    private byte[] icono;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtiporeaccion")
    private Collection<Reaccionpublicacion> reaccionpublicacionCollection;

    public Tiporeaccion() {
    }

    public Tiporeaccion(Integer idtiporeaccion) {
        this.idtiporeaccion = idtiporeaccion;
    }

    public Tiporeaccion(Integer idtiporeaccion, String nombre, byte[] icono) {
        this.idtiporeaccion = idtiporeaccion;
        this.nombre = nombre;
        this.icono = icono;
    }

    public Integer getIdtiporeaccion() {
        return idtiporeaccion;
    }

    public void setIdtiporeaccion(Integer idtiporeaccion) {
        this.idtiporeaccion = idtiporeaccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte[] getIcono() {
        return icono;
    }

    public void setIcono(byte[] icono) {
        this.icono = icono;
    }

    @XmlTransient
    public Collection<Reaccionpublicacion> getReaccionpublicacionCollection() {
        return reaccionpublicacionCollection;
    }

    public void setReaccionpublicacionCollection(Collection<Reaccionpublicacion> reaccionpublicacionCollection) {
        this.reaccionpublicacionCollection = reaccionpublicacionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtiporeaccion != null ? idtiporeaccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tiporeaccion)) {
            return false;
        }
        Tiporeaccion other = (Tiporeaccion) object;
        if ((this.idtiporeaccion == null && other.idtiporeaccion != null) || (this.idtiporeaccion != null && !this.idtiporeaccion.equals(other.idtiporeaccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Tiporeaccion[ idtiporeaccion=" + idtiporeaccion + " ]";
    }
    
}
