package com.softestrategico.service;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import interfaces.DomiciliosCasaBeanRemote;

@WebService
public class ServiceDomicilioCasa {
	
	@EJB(mappedName="guardaDomicilio")
	private DomiciliosCasaBeanRemote DomiCasaBeanRemote;
	
	@WebMethod(operationName="guardaDomicilio")
	public @WebResult(name="responseWS") String guardaDomicilioCasa(@WebParam(name="requestWS")String request){
		DomiCasaBeanRemote.probar(request);
		return "OK";
	}

}
