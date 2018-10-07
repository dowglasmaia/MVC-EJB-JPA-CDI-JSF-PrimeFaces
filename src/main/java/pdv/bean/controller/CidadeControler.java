package pdv.bean.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import pdv.dao.implementacao.CidadeDAO;
import pdv.dao.implementacao.EstadoDAO;
import pdv.entidades.Cidade;
import pdv.entidades.Estado;
import pdv.util.PdvUtil;

@Named(value = "controleCidade")
@ViewScoped
public class CidadeControler implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	private CidadeDAO<Cidade> dao;
	
	@EJB
	private EstadoDAO<Estado> daoEstado;
	
	private Cidade objeto;
	private Boolean editando;

	

	// Construtor Padrão
	public CidadeControler() {
		editando = false;
	}

	// redirecionar para cidade listar
	public String listar() {
		return "/privado/cidade/listar?faces-redirect=true";
	}

	// novo
	public void novo() {
		objeto = new Cidade();
		editando = true;
	}

	// atualizar
	public void atualizar(Integer id) {
		try {
			objeto = dao.getObjectById(id);
			editando = true;
		} catch (Exception e) {
			PdvUtil.mensagemErro("Erro ao Recuperar Objeto: " + PdvUtil.getMensagemErro(e));
		}
	}

	// Remove
	public void remover(Integer id) {
		try {
			objeto = dao.getObjectById(id);
			dao.remove(objeto);
		} catch (Exception e) {
			PdvUtil.mensagemErro("Erro ao Remover Objeto: " + PdvUtil.getMensagemErro(e));
		}
	}

	// Salvar
	public void salvar() {
		try {
			if (objeto.getId() == null) {
				dao.persist(objeto);
				PdvUtil.mensagemInformacao("Objeto Salvo Com Sucesso!");
			} else {
				dao.merge(objeto);
				PdvUtil.mensagemInformacao("Objeto Atualizado Com Sucesso!");
			}
			editando = false;
		} catch (Exception e) {
			PdvUtil.mensagemErro("Erro ao Tentar Salvar Objeto: " + PdvUtil.getMensagemErro(e));
		}
	}

	// **Getters e Setters**//
	public CidadeDAO<Cidade> getDao() {
		return dao;
	}

	public void setDao(CidadeDAO<Cidade> dao) {
		this.dao = dao;
	}

	public Cidade getObjeto() {
		return objeto;
	}

	public void setObjeto(Cidade objeto) {
		this.objeto = objeto;
	}

	public Boolean getEditando() {
		return editando;
	}

	public void setEditando(Boolean editando) {
		this.editando = editando;
	}

	public EstadoDAO<Estado> getDaoEstado() {
		return daoEstado;
	}

	public void setDaoEstado(EstadoDAO<Estado> daoEstado) {
		this.daoEstado = daoEstado;
	}

}
