package pdv.dao.implementacao;

import java.util.List;

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

	@Override
	public List<T> findList(Class<T> objs) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T findById(Class<T> entidade, Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clearSession() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void evict(T objs) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<?> getListSQLDinamica(String sql) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findListByQueryDinamica(String query, int iniciaNoRegistro, int maximoResultado) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
