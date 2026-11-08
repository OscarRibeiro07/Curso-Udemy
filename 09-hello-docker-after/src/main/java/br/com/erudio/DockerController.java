package br.com.erudio;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class DockerController {

	Logger logger = Logger.getLogger(DockerController.class.getName());
	@RequestMapping("/hello-docker")
	public HelloDocker greeting() {
		logger.info("ENDPOINT /hello-docker is called");
		//var hostName = System.getenv("COMPUTERNAME");
		var hostName = System.getenv("HOSTNAME");
		
		return new HelloDocker(
					"Hello Docker",
					hostName
				);
	}
}
