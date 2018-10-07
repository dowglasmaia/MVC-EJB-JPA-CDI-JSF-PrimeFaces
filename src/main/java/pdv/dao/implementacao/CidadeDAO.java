package pdv.dao.implementacao;

import java.io.Serializable;

import javax.ejb.Stateless;

import pdv.entidades.Cidade;

@Stateless
public class CidadeDAO<E> extends DAOGenerico<Cidade> implements Serializable {
	private static final long serialVersionUID = 1L;

	public CidadeDAO() {
		super();
		classPersistente = Cidade.class;
	}

}
