package ejb;

import java.util.List;

import modelo.Categoria;

public interface CategoriaFacade extends AbstractFacadeJPA<Categoria>{
	public List<Categoria> findAll();
}
