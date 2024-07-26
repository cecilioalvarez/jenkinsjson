package com.arquitecturajava;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LeerJson {

	public static void main (String[] args) {
		
		  try {
			  
			  InputStream is = LeerJson.class.getClassLoader().getResourceAsStream("persona.json");
			  String text = new String(is.readAllBytes());
			  System.out.println(text);
			  ObjectMapper mapper = new ObjectMapper();

			

			
			  // read the json strings and convert it into JsonNode
			  JsonNode node = mapper.readTree(text);

			  // display the JsonNode
			  System.out.println("Nombre: " + node.get("nombre").asText());
			  System.out.println("edad: " + node.get("edad").asInt());
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
