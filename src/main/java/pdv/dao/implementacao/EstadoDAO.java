package pdv.dao.implementacao;

import java.io.Serializable;

import javax.ejb.Stateless;

import pdv.entidades.Estado;

/*
 * Skype:live:dowglasmaia
 * */

@Stateless
public class EstadoDAO<E> extends DAOGenerico<Estado> implements Serializable {
	private static final long serialVersionUID = 1L;

	public EstadoDAO() {
		super();
		classPersistente = Estado.class;

	}

}
