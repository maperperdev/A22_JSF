package ejb;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class CategoriaFacadeImpl
 */
@Stateless
@Local(AbstractFacadeJPA.class)
@LocalBean
public class CategoriaFacadeImpl extends AbstractFacadeJPAImpl implements AbstractFacadeJPA {

    /**
     * Default constructor. 
     */
    public CategoriaFacadeImpl() {
        // TODO Auto-generated constructor stub
    }
       
    /**
     * @see AbstractFacadeJPAImpl#AbstractFacadeJPAImpl(Class<T>)
     */
    public CategoriaFacadeImpl(Class<T> entityClass) {
        super(entityClass);
        // TODO Auto-generated constructor stub
    }

}
