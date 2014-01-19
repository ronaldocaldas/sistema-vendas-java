package com.kurtphpr.sistema.cliente;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Cliente.class)
public class ClienteConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String codigoString) {
		if(codigoString != null && codigoString.trim().length() > 0){
			Integer codigo =  Integer.valueOf(codigoString);
			ClienteRN clienteRN = new ClienteRN();
			
		    return clienteRN.pesquisarPorCodigo(codigo);
			
			
		}
		
		
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object clienteObjeto) {
		if(clienteObjeto != null){
			 Cliente cliente = (Cliente) clienteObjeto;
			 return cliente.getId().toString();
		}
		return null;
	}

}
