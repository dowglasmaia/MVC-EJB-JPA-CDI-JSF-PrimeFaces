package pdv.dao.interfaces;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T> extends Serializable {

	// salvar
	void saveOrUpdate(T obj) throws Throwable;

	// Salvar ou Atualiza e Retorna o Bjt Salvo
	T merge(T obj) throws Exception;

	// Delete
	void delete(T obj) throws Exception;

	// Carrega a Lista de Dados
	List<T> findList(Class<T> entidades) throws Exception;

	// Buscar Por ID
	T findById(Class<T> entidade, Integer id) throws Exception;

	// limpa a Session do Hibernate
	void clearSession() throws Exception;

	// Retira um Objeto da Sessão do Hibernate
	void evict(T objs) throws Exception;

	// Lista de Dados usando SQL
	List<?> getListSQLDinamica(String sql) throws Exception;

	// Carregamendo dinamico por Demanda, com JSF e PrimeFaces
	List<T> findListByQueryDinamica(String query, int iniciaNoRegistro, int maximoResultado) throws Exception;

}
