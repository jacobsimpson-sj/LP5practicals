package com.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;
@WebService
public interface CalculatorService {
@WebMethod
double add(double x, double y);
@WebMethod
double subtract(double x, double y);
@WebMethod
double multiply(double x, double y);
@WebMethod
double divide(double x, double y);
}