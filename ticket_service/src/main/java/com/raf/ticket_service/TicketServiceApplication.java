package com.raf.ticket_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import testApp.view.MainFrame;

import javax.swing.*;

@SpringBootApplication
@EnableEurekaServer
public class TicketServiceApplication extends JFrame {

	public static void main(String[] args) {
		SpringApplication.run(TicketServiceApplication.class, args);
		MainFrame instance = MainFrame.getInstance();
	}

}
