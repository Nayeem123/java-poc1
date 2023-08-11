package com.example.Module2;

import javax.net.ssl.HttpsURLConnection;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

//@Configuration
@SpringBootApplication
public class Module2Application {

	public static void main(String[] args) {
		
//		HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
//		    public boolean verify(String hostname, SSLSession session) {
//		        return true;
//		    }
//		});
		SpringApplication.run(Module2Application.class, args);

//		@Bean
//		public KafkaTemplate<String, String> kafkaTemplate(ProducerFactory<String, String> producerFactory) {
//			KafkaTemplate<String, String> kafkaTemplate = new KafkaTemplate<>(producerFactory);
//			// Customize KafkaTemplate properties if needed
//			return kafkaTemplate;
//		}
	}

}
