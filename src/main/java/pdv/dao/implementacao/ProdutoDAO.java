package pdv.dao.implementacao;

import java.io.Serializable;

import javax.ejb.Stateless;

import pdv.entidades.Produto;

@Stateless
public class ProdutoDAO<E> extends DAOGenerico<Produto> implements Serializable {
	private static final long serialVersionUID = 1L;

	public ProdutoDAO() {
		super();
		classPersistente = Produto.class;
	}

}
