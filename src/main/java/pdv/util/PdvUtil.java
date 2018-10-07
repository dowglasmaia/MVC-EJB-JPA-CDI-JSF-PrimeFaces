package pdv.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class PdvUtil {

	//Recupera o Erro 
	public static String getMensagemErro(Exception e) {
		while (e.getCause() != null) {
			e = (Exception) e.getCause();
		}
		String retorno = e.getMessage();
		if (retorno.contains("viola restrição de chave estrangeira")) {
			retorno = "Registro não pode ser excluido por possuir referências no sistema...";
		}
		return retorno;
	}

	// msg Infor
	public static void mensagemInformacao(String msg) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.getExternalContext().getFlash().setKeepMessages(true);
		FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, "");
		facesContext.addMessage(null, mensagem);
	}

	// msg Error
	public static void mensagemErro(String msg) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.getExternalContext().getFlash().setKeepMessages(true);
		FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, "");
		facesContext.addMessage(null, mensagem);
	}

}
