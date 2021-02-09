package ejb;

import java.util.List;

import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import modelo.Categoria;

@Stateless
public class CategoriaFacadeImpl extends AbstractFacadeJPAImpl<Categoria> implements CategoriaFacade{
	
	@PersistenceContext(unitName = "Persistencia")
	private EntityManager em;
	
	
	public CategoriaFacadeImpl() {
		super(Categoria.class);
	}

	@PreDestroy
    public void destruct() {
        getEm().close();
    }

	@Override
	public List<Categoria> findAll() {
		TypedQuery<Categoria> q=getEm().createQuery("select c from categoria c", Categoria.class);
		List<Categoria> lista=q.getResultList();
		return lista;
	}

	@Override
	protected EntityManager getEm() {
		return em;
	}

}
