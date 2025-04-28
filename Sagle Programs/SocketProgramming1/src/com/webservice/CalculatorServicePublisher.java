package com.webservice;

import javax.xml.ws.Endpoint;

public class CalculatorServicePublisher {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8080/ws/calculator", new CalculatorServiceImpl());
		System.out.println("Service is published at http://localhost:8080/ws/calculator");
	}
}