package negocio;

import javax.ejb.Local;

import model.TbPersona;

@Local
public interface PryDomiCasaBean2Local {

	public TbPersona find(Long pk);
	
}
