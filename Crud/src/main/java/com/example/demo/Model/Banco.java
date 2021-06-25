package com.example.demo.Model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "tarjeta_de_credito")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "TarjetaDeCredito.findAll", query = "SELECT t FROM TarjetaDeCredito t")
//    , @NamedQuery(name = "TarjetaDeCredito.findById", query = "SELECT t FROM TarjetaDeCredito t WHERE t.id = :id")
//    , @NamedQuery(name = "TarjetaDeCredito.findByTipoTarjeta", query = "SELECT t FROM TarjetaDeCredito t WHERE t.tipoTarjeta = :tipoTarjeta")
//    , @NamedQuery(name = "TarjetaDeCredito.findBySaldo", query = "SELECT t FROM TarjetaDeCredito t WHERE t.saldo = :saldo")})

public class Banco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "tipo_tarjeta")
    private String tipoTarjeta;
    @Column(name = "saldo")
    private String saldo;
    @JoinColumn(name = "idpersona", referencedColumnName = "id")
    @ManyToOne
    private Datos idpersona;

    public Banco() {
    }

    public Banco(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    public Datos getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Datos idpersona) {
        this.idpersona = idpersona;
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
        if (!(object instanceof Banco)) {
            return false;
        }
        Banco other = (Banco) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.modelo.TarjetaDeCredito[ id=" + id + " ]";
    }
    
}
