/**
 * 
 */
package org.cjl.marvel;

import java.io.InputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.Set;

import javax.json.*;

/**
 * @author Conor
 *
 */
public class Test 
{
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		System.out.println("Making JSON call to Marvel...");
		
		try
		{
			URL url = new URL("http://gateway.marvel.com:80/v1/public/characters?name=Hawkeye&apikey=802e2de29e6813d6ffd4258e9a09210d&ts=1&hash=a57e51c7d7a8810f3da8d1c58d6c9cc4");
			//URL url = new URL("http://date.jsontest.com/?service=ip");
			//URL url = new URL("http://gateway.marvel.com/v1/comics/?ts=1&apikey=802e2de29e6813d6ffd4258e9a09210d&hash=a57e51c7d7a8810f3da8d1c58d6c9cc4");
			InputStream is = url.openStream();
			JsonReader rdr = Json.createReader(is);			
			JsonObject obj = rdr.readObject();
			
			System.out.println("obj is " + obj);
			
			Set<String> objKeys = obj.keySet();
			Iterator it = objKeys.iterator();
			Object o = null;
			while(it.hasNext())
			{
				o = it.next();
				System.out.println("Key: " + o);
				System.out.println("Value: " + obj.get(o));
			}
			JsonObject dataObject = obj.getJsonObject("data");
			System.out.println("dataObject: " + dataObject);
			Set<String> dataKeys = dataObject.keySet();
			it = dataKeys.iterator();
			while(it.hasNext())
			{
				o = it.next();
				System.out.println("Key: " + o);
				System.out.println("Value: " + dataObject.get(o));
			}
			//JsonObject resultsObject = dataObject.getJsonObject("results");
			JsonArray resultsArray = dataObject.getJsonArray("results");
			System.out.println("resultsObject: " + resultsArray);
			
			it = resultsArray.iterator();
			while(it.hasNext())
			{
				o = it.next();
				System.out.println("Element: " + o);
			}
			/*Set<String> resultKeys = resultsObject.keySet();
			it = resultKeys.iterator();
			while(it.hasNext()){
				o = it.next();
				System.out.println("Key: " + o);
				System.out.println("Value: " + resultsObject.get(o));
			}*/
		}
		catch(Exception e)
		{
			System.out.println("We done fucked up");
			e.printStackTrace();
		}
	}

}
