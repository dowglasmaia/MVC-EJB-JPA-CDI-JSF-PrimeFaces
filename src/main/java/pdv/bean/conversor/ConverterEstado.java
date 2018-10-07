package pdv.bean.conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pdv.entidades.Estado;

@FacesConverter(value = "converterEstado")
public class ConverterEstado implements Converter {

	@PersistenceContext(unitName = "PDV")
	private EntityManager em;

	@Override
	public Object getAsObject(FacesContext context, UIComponent componet, String value) {
		if (value == null || value.equals("Selecione um registro")) {
			return null;
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent componet, Object value) {
		if (value == null) {
			return null;
		}
		Estado obj = (Estado) value;
		return obj.getId().toString();
	}

}
