package pdv.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import org.omnifaces.util.Messages;

import pdv.dao.implementacao.CategoriaDAO;
import pdv.entidades.Categoria;

@SessionScoped
@Model
public class CategoriaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private Categoria categoria;

	@Inject
	private CategoriaDAO dao;

	private List<Categoria> categorias = new ArrayList<>();

	// Salvar
	public String save() {
		try {
			dao.saveOrUpdate(categoria);
			Messages.addGlobalInfo("Categoria Salva Com Sucesso!");
		} catch (Throwable e) {
			Messages.addGlobalError("Erro ao Salvar a Categoria!");
			e.printStackTrace();
		}
		return "Categorias-Listagem";
	}

	// Listar Todos
	public void listarTodos() {
		try {
			this.categorias = dao.findList(Categoria.class);
		} catch (Exception e) {
			Messages.addGlobalError("Erro ao Listar os Dados!");
			e.printStackTrace();
		}

	}

	// **Getters e Setters**//
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

}
