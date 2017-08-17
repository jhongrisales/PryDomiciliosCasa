package negocio;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import interfaces.DomiciliosCasaBeanRemote;
import model.TbPersona;

/**
 * Session Bean implementation class DomiciliosCasaBean
 */
@Stateless(mappedName = "prueba")
public class DomiciliosCasaBean implements DomiciliosCasaBeanRemote, DomiciliosCasaBeanLocal {

	@EJB
	private PryDomiCasaBean2Local prueba2;
	
    /**
     * Default constructor. 
     */
    public DomiciliosCasaBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public String probar(String valor) {
		TbPersona persona = prueba2.find(1L);
		return "OK";
	}

}
