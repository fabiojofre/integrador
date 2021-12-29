package br.com.vrrecife.util;

import java.io.BufferedReader;
import java.io.IOException;

public class Util {
	 public static String converteXmlEmString(BufferedReader buffereReader) throws IOException {
	        String resposta, xmlEmString = "";
	        while ((resposta = buffereReader.readLine()) != null) {
	        	xmlEmString += resposta;
	        }
	        return xmlEmString;
	    }
}
