package cl.bhp.middleware.dao;

import cl.bhp.middleware.exception.ServiceException;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * Clase que permite recuperar información de negocio sobre una estructura mongoDB
 * @author cquezada Red Hat
 *
 */
public class DataAccessObject {

	private static final Logger LOGGER = Logger.getLogger(DataAccessObject.class);
	
	/**
	 * Recupera información de negocio mongo para una lista de informacion de la SIM
	 * que son buscados por el iccid
	 * @param iccid
	 * @return
	 * @throws ServiceErrorException
	 */
	
	@SuppressWarnings("null")
	public JSONObject generarReclamo (String rut) throws ServiceException {
		long init = System.currentTimeMillis();
		JSONObject result = null;
		
//		try {
//
//					
//			HttpResponse<String> responseUser = Unirest.get(" URL ")
//					  .header("Authorization", "Bearer "+" ")
//					  .header("cache-control", "no-cache")
//					  .asString();
//					 
//			System.out.println(responseUser.getStatus());
//			System.out.println(responseUser.getStatusText());
//			System.out.println(responseUser.getBody());
			result = new JSONObject();
			result.put("responseMessage", "Reclamo Ingresado Exitosamente");
			result.put("responseCode", "200");

//			} catch (UnirestException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				throw new ServiceException("400");
//			}
		
	
//		LOGGER.info("Tiempo en consulta EspoCRM "+(System.currentTimeMillis() - init)+" ms.");

		return result;
		
	}
}
