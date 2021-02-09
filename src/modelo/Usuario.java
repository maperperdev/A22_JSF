package modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(name="usuario")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;


	@Id
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="codigo",nullable = false)
    private Persona codigo;
	
	private String usuario;
	
	private String clave;

	private short estado =1;

	private String tipo;

	public Usuario() {
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public short getEstado() {
		return this.estado;
	}

	public void setEstado(short estado) {
		this.estado = estado;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Persona getPersona() {
		return this.codigo;
	}

	public void setPersona(Persona persona) {
		this.codigo = persona;
	}

}