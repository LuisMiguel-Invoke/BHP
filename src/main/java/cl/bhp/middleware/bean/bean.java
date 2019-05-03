package cl.bhp.middleware.bean;

import cl.bhp.middleware.dao.DataAccessObject;
import cl.bhp.middleware.exception.ServiceException;
import org.apache.camel.Exchange;
import org.apache.log4j.Logger;
import org.json.JSONObject;

/**
 * Clase que permite la realización de forward de peticiones generadas desde
 * una ruta camel, busca realizar validaciones previas antes de ir por el 
 * negocio en búsqueda de resultados
 * @author Luis Oliveros
 */

public class bean {
	private static final Logger LOGGER = Logger.getLogger(DataAccessObject.class);
	/**
	 * Genera un reclamo de un empleado en el EspoCRM. mediante la busqueda con el parametro: datos,
	 * y devuelve una confirmación de haber creado el reclamo
	 * @param ex
	 * @return JSONObject
	 * @throws ServiceException
	 */
	
	@SuppressWarnings("unused")
	public JSONObject reclamo(Exchange ex)  throws ServiceException {
		
		
		JSONObject datos = null;
		Object reclamoTitulo=null;
		Object reclamoObservacion=null;
		Object beneficiarioId=null;
		Object motivoReclamoId=null;
		Object empresaId=null;
		
		try {
				
			datos = new JSONObject(ex.getIn().getBody(String.class));
			reclamoTitulo = datos.get("reclamoTitulo");
			reclamoObservacion = datos.get("reclamoObservacion");
			beneficiarioId = datos.get("beneficiarioId");
			motivoReclamoId = datos.get("motivoReclamoId");
			empresaId = datos.get("empresaId");
		
		}catch(Exception e){
			throw new ServiceException("400");
		}
		
		if(datos == null) {
			throw new ServiceException("400");
		}	
		return new DataAccessObject().generarReclamo(datos);
	}
	
}
