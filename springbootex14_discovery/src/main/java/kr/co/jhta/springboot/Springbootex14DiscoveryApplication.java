package kr.co.jhta.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //유레카 서버 활성화
public class Springbootex14DiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springbootex14DiscoveryApplication.class, args);
	}

}
