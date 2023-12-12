package com.example.work;

import com.example.work.service.SwingUIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;


@SpringBootApplication
public class WorkApplication// implements CommandLineRunner {
{
	@Autowired
	private SwingUIService swingUIService;

	public static void main(String[] args) {

		SpringApplication.run(WorkApplication.class, args);

		/*
		new SpringApplicationBuilder(WorkApplication.class);
				.web(WebApplicationType.NONE)
				.headless(false)
				.bannerMode(Banner.Mode.OFF)
				.run(args);

		 */
	}


	/*
	@Override
	public void run(String... args) {
		swingUIService.startSwingUI();
	}
*/
}
