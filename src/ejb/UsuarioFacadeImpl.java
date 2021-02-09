package ejb;

import java.util.List;

import javax.annotation.PreDestroy;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import modelo.Usuario;

/**
 * Session Bean implementation class UsuarioFacadeImpl
 */
@Stateless
public class UsuarioFacadeImpl extends AbstractFacadeJPAImpl<Usuario> implements UsuarioFacade2 {

	 @PersistenceContext(unitName="Persistencia")
	 private EntityManager em;
	    
	    
	   
	    public UsuarioFacadeImpl() {
	        super(Usuario.class);
	        
	    }

		@Override
		protected EntityManager getEm() {
			// TODO Auto-generated method stub
			return em;
		}
		
		
		
		@PreDestroy public void destruct() { getEm().close(); }
		
		
		public Usuario iniciarSesion(Usuario us) {
			Usuario usuario=null;
			String consulta;
			try {
				consulta="SELECT u FROM Usuario u WHERE u.usuario= :usuario AND u.clave= :clave";
				TypedQuery<Usuario> query=em.createQuery(consulta, Usuario.class);
				query.setParameter("usuario", us.getUsuario());
				query.setParameter("clave", us.getClave());
				List<Usuario> lista=query.getResultList();
				if(!lista.isEmpty()) {
					usuario=lista.get(0);
				}	
			
			}catch(Exception e) {
				throw e;
			}
			return usuario;
		}
	}

