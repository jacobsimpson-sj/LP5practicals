package com.webservice;

import javax.jws.WebService;

@WebService(endpointInterface = "com.webservice.CalculatorService")
public class CalculatorServiceImpl implements CalculatorService {
public double add(double x, double y) {
	return x+y;
}

public double subtract(double x, double y) {
return x - y;
}

public double multiply(double x, double y) {
return x * y;
}

public double divide(double x, double y) {
if (y == 0) throw new ArithmeticException("Division by zero");
return x / y;
}
}