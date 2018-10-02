package pdv.dao.interfaces;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

@SessionScoped
public interface GenericDAO <T> extends Serializable{
	
	//salvar
	void save(T obj) throws Throwable;
	
	//Delete
	void delete (T obj) throws Exception;
	
	

}
