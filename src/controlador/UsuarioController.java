package controlador;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ejb.UsuarioFacade2;
import modelo.Persona;
import modelo.Usuario;

@Named
@ViewScoped
public class UsuarioController implements Serializable{
	private static final long serialVersionUID=1L;
	
	@Inject
	private Usuario usuario;
	
	@Inject
	private Persona persona;
	
	@EJB
	private UsuarioFacade2 usuarioEJB;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	public void registrar() {
		try {
			this.usuario.setPersona(persona);
			usuarioEJB.create(usuario);
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso", "Se registro correctamente"));
		}catch(Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso", "No se registro"));
			e.printStackTrace();
		}
	}
}
