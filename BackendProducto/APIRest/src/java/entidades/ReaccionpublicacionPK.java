/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author david
 */
@Embeddable
public class ReaccionpublicacionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idpublicacion")
    private int idpublicacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idusuario")
    private int idusuario;

    public ReaccionpublicacionPK() {
    }

    public ReaccionpublicacionPK(int idpublicacion, int idusuario) {
        this.idpublicacion = idpublicacion;
        this.idusuario = idusuario;
    }

    public int getIdpublicacion() {
        return idpublicacion;
    }

    public void setIdpublicacion(int idpublicacion) {
        this.idpublicacion = idpublicacion;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idpublicacion;
        hash += (int) idusuario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReaccionpublicacionPK)) {
            return false;
        }
        ReaccionpublicacionPK other = (ReaccionpublicacionPK) object;
        if (this.idpublicacion != other.idpublicacion) {
            return false;
        }
        if (this.idusuario != other.idusuario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.ReaccionpublicacionPK[ idpublicacion=" + idpublicacion + ", idusuario=" + idusuario + " ]";
    }
    
}
