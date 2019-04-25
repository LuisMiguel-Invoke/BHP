package cl.bhp.middleware.dao;

import cl.bhp.middleware.exception.ServiceException;
import cl.bhp.middleware.util.PropertiesUtil;

import java.util.Properties;

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
	static PropertiesUtil prop = new PropertiesUtil();
	
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
		JSONObject Json = new JSONObject();
		String URI = prop.getLocalProperties().getProperty("api.espocrm.uri");
		String auth = prop.getLocalProperties().getProperty("api.espocrm.auth");
		try {

					
			HttpResponse<String> responseUser = Unirest.get(URI)
					  .header("Authorization", "Basic "+auth)
					  .header("cache-control", "no-cache")
					  .asString();
					 
			System.out.println(responseUser.getStatus());
			System.out.println(responseUser.getStatusText());
			
			Json = new JSONObject(responseUser.getBody());
			System.out.println(Json.toString());
			

			} catch (UnirestException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new ServiceException("400");
			}
		
	
		LOGGER.info("Tiempo en consulta EspoCRM "+(System.currentTimeMillis() - init)+" ms.");

		return Json;
		
	}
}
