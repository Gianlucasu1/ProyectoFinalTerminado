/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionproyectos.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gianlucasorem
 */
@Entity
@Table(name = "tareaInfo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TareaInfo.findAll", query = "SELECT t FROM TareaInfo t")
    , @NamedQuery(name = "TareaInfo.findById", query = "SELECT t FROM TareaInfo t WHERE t.id = :id")
    , @NamedQuery(name = "TareaInfo.findByIdtarea", query = "SELECT t FROM TareaInfo t WHERE t.idtarea = :idtarea")
    , @NamedQuery(name = "TareaInfo.findByIdusuario", query = "SELECT t FROM TareaInfo t WHERE t.idusuario = :idusuario")
    , @NamedQuery(name = "TareaInfo.findByDescripcion", query = "SELECT t FROM TareaInfo t WHERE t.descripcion = :descripcion")
    , @NamedQuery(name = "TareaInfo.findByTiempoTotal", query = "SELECT t FROM TareaInfo t WHERE t.tiempoTotal = :tiempoTotal")})
public class TareaInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "idtarea")
    private Integer idtarea;
    @Column(name = "idusuario")
    private Integer idusuario;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "tiempoTotal")
    private Integer tiempoTotal;

    public TareaInfo() {
    }

    public TareaInfo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdtarea() {
        return idtarea;
    }

    public void setIdtarea(Integer idtarea) {
        this.idtarea = idtarea;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getTiempoTotal() {
        return tiempoTotal;
    }

    public void setTiempoTotal(Integer tiempoTotal) {
        this.tiempoTotal = tiempoTotal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TareaInfo)) {
            return false;
        }
        TareaInfo other = (TareaInfo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gestionproyectos.modelo.TareaInfo[ id=" + id + " ]";
    }
    
}
