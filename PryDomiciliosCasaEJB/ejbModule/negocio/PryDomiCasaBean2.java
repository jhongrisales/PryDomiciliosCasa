package negocio;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.TbPersona;

/**
 * Session Bean implementation class PryDomiCasaBean2
 */
@Stateless(mappedName = "prueba2")
public class PryDomiCasaBean2 implements PryDomiCasaBean2Local {

	@PersistenceContext
	private EntityManager entityManager;
	
	
    /**
     * Default constructor. 
     */
    public PryDomiCasaBean2() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public TbPersona find(Long pk) {
		TbPersona persona = entityManager.find(TbPersona.class, pk);
		return persona;
	}

}
