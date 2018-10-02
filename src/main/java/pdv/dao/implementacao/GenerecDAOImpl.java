package pdv.dao.implementacao;

//import javax.ejb.ApplicationException;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import pdv.dao.interfaces.GenericDAO;

@Dependent
//@ApplicationException(rollback = true)
@Transactional(rollbackOn= {Exception.class})
public class GenerecDAOImpl<T> implements GenericDAO<T>{
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void save(T obj) throws Throwable {
		
		em.persist(obj);
		
		
	}

	@Override
	public void delete(T obj) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
