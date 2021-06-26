package com.example.demo.Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "datos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Datos.findAll", query = "SELECT d FROM Datos d")
    , @NamedQuery(name = "Datos.findById", query = "SELECT d FROM Datos d WHERE d.id = :id")
    , @NamedQuery(name = "Datos.findByNombre", query = "SELECT d FROM Datos d WHERE d.nombre = :nombre")
    , @NamedQuery(name = "Datos.findByApellido", query = "SELECT d FROM Datos d WHERE d.apellido = :apellido")
    , @NamedQuery(name = "Datos.findByTelefono", query = "SELECT d FROM Datos d WHERE d.telefono = :telefono")})
public class Datos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "telefono")
    private String telefono;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pais", referencedColumnName = "id") 
    private Pais pais;

    
    public Datos() {
    }

    
    
    
    
    
    public Datos(Integer id, String nombre, String apellido, String telefono, Pais pais) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.pais = pais;
	}






	public Datos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

     
    
}

