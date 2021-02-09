package controlador;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ejb.CategoriaFacade;
import modelo.Categoria;

@Named
@ViewScoped
public class CategoriaControllerConCDI implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private CategoriaFacade categoriaEJB;
	
	@Inject
	private Categoria categoria;
/*
	@PostConstruct
	public void init() {
		categoria = new Categoria();
	}*/
	public void registrar() {
		try {
			categoriaEJB.create(categoria);
		}catch(Exception e) {
			
		}
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public CategoriaFacade getCategoriaEJB() {
		return categoriaEJB;
	}
	public void setCategoriaEJB(CategoriaFacade categoriaEJB) {
		this.categoriaEJB = categoriaEJB;
	}
	
}
