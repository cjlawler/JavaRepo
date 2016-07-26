/**
 * 
 */
package com.cjl.hfta;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

/**
 * @author Conor
 *
 */
public class MassEffectStocksHFTA 
{
	public static void main(String[] args) 
	{
		// Set up client
		ClientConfig config = new ClientConfig();
	    Client client = ClientBuilder.newClient(config);
	    //URI baseURI = UriBuilder.fromUri("http://127.0.0.1:8081").build();
	    URI baseURI = UriBuilder.fromUri("http://raspberrypi:8081").build();
	    WebTarget target = client.target(baseURI);
	    
	    // Call web services to get stock prices
	    System.out.println("Armax stock price is " + getArmaxStockPrice(target));
	    System.out.println("Rosenkov stock price is " + getRosenkovStockPrice(target));
	    System.out.println("Binary Helix stock price is " + getBinaryHelixStockPrice(target));
	    
	    // TODO: HFTA stuff...  
	}
	
	public static int getArmaxStockPrice(WebTarget target)
	{
		Response response = target.path("getArmaxStockPrice").
	              request().accept(MediaType.TEXT_PLAIN).
	              get(Response.class);	    
	    return Integer.parseInt(response.readEntity(String.class));
	}
	
	public static int getRosenkovStockPrice(WebTarget target)
	{
		Response response = target.path("getRosenkovStockPrice").
	              request().accept(MediaType.TEXT_PLAIN).
	              get(Response.class);	    
	    return Integer.parseInt(response.readEntity(String.class));
	}
	
	public static int getBinaryHelixStockPrice(WebTarget target)
	{
		Response response = target.path("getBinaryHelixStockPrice").
	              request().accept(MediaType.TEXT_PLAIN).
	              get(Response.class);	    
	    return Integer.parseInt(response.readEntity(String.class));
	}
}
