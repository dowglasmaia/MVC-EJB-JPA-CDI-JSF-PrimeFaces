package pdv.bean;

import java.io.Serializable;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import org.omnifaces.util.Messages;

import pdv.dao.implementacao.CategoriaDAO;
import pdv.entidades.Categoria;

@Model
public class CategoriaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	 @Inject
	private Categoria categoria;

	@Inject
	private CategoriaDAO dao;

	public String save() {
		try {			
			dao.save(categoria);
			Messages.addGlobalInfo("Categoria Salva Com Sucesso!");				
		} catch (Throwable e) {
			Messages.addGlobalError("Erro ao Salvar a Categoria!");
			e.printStackTrace();			
		}
		return "Categorias";
	}

	// **Getters e Setters**//
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
