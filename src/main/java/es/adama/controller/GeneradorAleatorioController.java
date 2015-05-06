package es.adama.controller;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
//spring imports
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// denOfProgramming imports



import es.adama.aleatorios.GeneradorAleatorio;

/**
 * Ejemplo de controlador mvn que genera un n�mero aleatorio y lo devuelve a la vista asociada
 * 
 * Tambi�n muestra varios usos de log con diversos API
 *  i.e. "Apache Commons Logging (JCL)", Log4j and  "Simple Logging Facade" * 
 * 
 * 
 * See reference documents: 
 * http://www.slf4j.org/index.html
 * https://commons.apache.org/proper/commons-logging/guide.html
 * https://logging.apache.org/log4j/1.2/
 * 
 * @author David www.adamaconsulting.es
 * 
 */
@Controller
public class GeneradorAleatorioController {
	// Usando slf4j api directamente - elimina los comentarios de este c�digo despu�s de que las dependencias de SLFJ han sido a�adidas
	// private static final Logger logger = LoggerFactory.getLogger(GeneradorAleatorioController.class);

	// Usando el api log4j proporcionado por la dependencia espec�fica
	private static final Logger logger = Logger
			.getLogger("es.adama.controller.GeneradorAleatorioController");

	// usando el api JCL proporcionado por la dependencia transitiva de spring-core
	private Log log = LogFactory.getLog(GeneradorAleatorioController.class);

	@Inject
	private GeneradorAleatorio idGenerator;

	@RequestMapping("/numero")
	public String muestraNuevoId(Model model) {		
		//  S�lo como ejemplo para mostrar las diferentes dependencias de logging
		
		// Lo mejo es usar s�lo una y es buena pr�ctica usar slf4j.
//TODO: revisar esta parte del código
		// debug de JCL
		log.debug("El log est� usando: "
				+ log.getClass().getCanonicalName());

		// debug de log4j
		logger.debug("El log est� usando: "
				+ logger.getClass().getCanonicalName()+" Mensaje de prueba");
		
		
//FIXME: esto hay que corregirlo
		
		model.addAttribute("creator", idGenerator.name());
		model.addAttribute("id", idGenerator.generaNumero());

		return "nuevoNumero";		

	}

}
