package pdv.dao.implementacao;

import java.util.List;

//import javax.ejb.ApplicationException;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import pdv.dao.interfaces.GenericDAO;

@Dependent
// @ApplicationException(rollback = true)
@Transactional(rollbackOn = { Exception.class })
public class GenerecDAOImpl<T> implements GenericDAO<T> {
	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private static EntityManager em; // Injeta o EntiteManager

	@Override
	public void saveOrUpdate(T obj) throws Throwable {
		em.persist(obj);
		em.flush(); // Roda Instantaneamente o SQL no banco de Dados

	}

	@Override
	public T merge(T obj) throws Exception {
		obj = em.merge(obj);
		em.flush();
		return obj;
	}

	@Override
	public void delete(T obj) throws Exception {
		em.remove(obj);
		em.flush();
	}

	@Override
	public List<T> findList(Class<T> entidades) throws Exception {
		StringBuilder query = new StringBuilder();
		query.append(" select distinct(entity) from ").append(entidades.getSimpleName()).append(" entity ");

		List<T> lista = em.createQuery(query.toString()).getResultList();
		return lista;
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

	/*
	 * // Garante o Commit nas Transações Ajax private void commitProcessoAjax() {
	 * em.getTransaction().commit(); }
	 * 
	 * // Garante o rollBack nas Transações Ajax private void rollBackProcessoAjax()
	 * { em.getTransaction().rollback();
	 * 
	 * }
	 * 
	 */

}
