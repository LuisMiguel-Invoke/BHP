package cl.bhp.middleware.bean;

import cl.bhp.middleware.dao.DataAccessObject;
import cl.bhp.middleware.exception.ServiceException;
import org.apache.camel.Exchange;
import org.json.JSONObject;


public class bean {

	public JSONObject reclamo(Exchange ex)  throws ServiceException {
		String rut = null;
		rut = (String) ex.getIn().getHeader("rut");

		if(rut == null) {
			throw new ServiceException("400");
		}	
		
		return new DataAccessObject().generarReclamo(rut);
	}
	
}
