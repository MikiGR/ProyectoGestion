package com.example.work;

import com.example.work.repository.MuestraRepository;
import com.example.work.repository.UsuarioRepository;
import com.example.work.service.MuestraService;
import com.example.work.service.SwingUIService;
import com.example.work.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

//import static javafx.scene.paint.Color.web;


@SpringBootApplication
public class WorkApplication implements CommandLineRunner {

	@Autowired
	private SwingUIService swingUIService = new SwingUIService(new UsuarioService(),new MuestraService());

	public static void main(String[] args) {

		//SpringApplication.run(WorkApplication.class, args);


		new SpringApplicationBuilder(WorkApplication.class)
				.web(WebApplicationType.NONE)
				.headless(false)
				.bannerMode(Banner.Mode.OFF)
				.run(args);
	}



	@Override
	public void run(String... args) {
		swingUIService.startSwingUI();
	}

}
