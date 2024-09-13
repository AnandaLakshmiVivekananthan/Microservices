package com.example.hola.springboot.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Ananda Lakshmi Vivekananthan
 */
@RestController
@RequestMapping("/api")
@ConfigurationProperties(prefix = "helloapp")
public class HolaRestController {

	private String saying;

	@GetMapping("/hola")
	public String hola() {

		String hostname = null;
		try {
			hostname = InetAddress.getLocalHost()
					.getHostAddress();
		} catch (UnknownHostException e) {
			hostname = "unknown";
		}
		return saying + " " + hostname;
	}

	public String getSaying() {
		return saying;
	}

	public void setSaying(String saying) {
		this.saying = saying;
	}
}
