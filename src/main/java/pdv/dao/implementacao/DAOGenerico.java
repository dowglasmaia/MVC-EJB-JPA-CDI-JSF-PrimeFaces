package pdv.dao.implementacao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/*
 * Skype:live:dowglasmaia
 * 
 * */

@Transactional(rollbackOn = {Exception.class})
public class DAOGenerico<E> implements Serializable {
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "PDV")
	protected EntityManager em;

	protected Class classPersistente;
	private List<E> listaObjetos;

	public DAOGenerico() {

	}

	// Lista Todos
	public List<E> getListaObjetos() {
		String jpql = "from " + classPersistente.getSimpleName();
		return em.createQuery(jpql).getResultList();
	}

	// Salva
	public void persist(E obj) throws Exception {
		em.persist(obj);
		em.flush();
	}

	// Atualizar e Salva
	public void merge(E obj) throws Exception {
		em.merge(obj);
		em.flush();
	}

	// Remove
	public void remove(E obj) throws Exception {
		obj = em.merge(obj);
		em.remove(obj);
		em.flush();
	}

	// Busar Por ID
	public E getObjectById(Object id) throws Exception {
		return (E) em.find(classPersistente, id);
	}

	/// *********************//////********************
	public void setListaObjetos(List<E> listaObjetos) {
		this.listaObjetos = listaObjetos;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

}
