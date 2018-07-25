/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author david
 */
@Entity
@Table(name = "detallepublicacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detallepublicacion.findAll", query = "SELECT d FROM Detallepublicacion d")
    , @NamedQuery(name = "Detallepublicacion.findByIddetallepublicacion", query = "SELECT d FROM Detallepublicacion d WHERE d.iddetallepublicacion = :iddetallepublicacion")
    , @NamedQuery(name = "Detallepublicacion.findByNombre", query = "SELECT d FROM Detallepublicacion d WHERE d.nombre = :nombre")
    , @NamedQuery(name = "Detallepublicacion.findByUrl", query = "SELECT d FROM Detallepublicacion d WHERE d.url = :url")})
public class Detallepublicacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddetallepublicacion")
    private Integer iddetallepublicacion;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Lob
    @Column(name = "contenido")
    private byte[] contenido;
    @Size(max = 50)
    @Column(name = "url")
    private String url;
    @JoinColumn(name = "idpublicacion", referencedColumnName = "idpublicacion")
    @ManyToOne(optional = false)
    private Publicacion idpublicacion;

    public Detallepublicacion() {
    }

    public Detallepublicacion(Integer iddetallepublicacion) {
        this.iddetallepublicacion = iddetallepublicacion;
    }

    public Integer getIddetallepublicacion() {
        return iddetallepublicacion;
    }

    public void setIddetallepublicacion(Integer iddetallepublicacion) {
        this.iddetallepublicacion = iddetallepublicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte[] getContenido() {
        return contenido;
    }

    public void setContenido(byte[] contenido) {
        this.contenido = contenido;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Publicacion getIdpublicacion() {
        return idpublicacion;
    }

    public void setIdpublicacion(Publicacion idpublicacion) {
        this.idpublicacion = idpublicacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddetallepublicacion != null ? iddetallepublicacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detallepublicacion)) {
            return false;
        }
        Detallepublicacion other = (Detallepublicacion) object;
        if ((this.iddetallepublicacion == null && other.iddetallepublicacion != null) || (this.iddetallepublicacion != null && !this.iddetallepublicacion.equals(other.iddetallepublicacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Detallepublicacion[ iddetallepublicacion=" + iddetallepublicacion + " ]";
    }
    
}
