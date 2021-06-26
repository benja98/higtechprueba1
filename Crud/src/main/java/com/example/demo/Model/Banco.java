package com.example.demo.Model;

import java.io.Serializable;

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

public class Banco implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "tipo_tarjeta")
    private String tipoTarjeta;
    @Column(name = "saldo")
    private String saldo;
    
    @ManyToOne
    @JoinColumn(name = "idpersona", referencedColumnName = "id") 
    private Datos idpersona;

	public Banco(Integer id, String tipoTarjeta, String saldo, Datos idpersona) {
		super();
		this.id = id;
		this.tipoTarjeta = tipoTarjeta;
		this.saldo = saldo;
		this.idpersona = idpersona;
	}

	public Banco() {
		super();
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

    
    

    
    
}
