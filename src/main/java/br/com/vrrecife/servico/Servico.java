package br.com.vrrecife.servico;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.google.api.client.json.JsonObjectParser;

import br.com.vrrecife.dominio.Recebimento;
import br.com.vrrecife.util.Util;



public class Servico {

	 static String webService = "https://app.salvalucro.com.br/salvalucroWS/Wsstratusx.asmx/";
	    static int codigoSucesso = 200;

	    public static List<Recebimento> buscaEnderecoPelo(String usuario,String senha, String cnpj, 
	    												String DataInicialRecebimento, String DataFinalRecebimento) throws IOException, 
	    												JAXBException, ParserConfigurationException, SAXException {
	    	String modalidade = "ConsultaRecebimentos";
	    	String user = "?Usuario="+usuario;
	    	String pass = "&Senha="+senha;
	    	String dCnpj = "&CNPJ="+cnpj;
	    	String dateIni = "&DataInicialRecebimento="+DataInicialRecebimento;
	    	String dateFin = "&DataFinalRecebimento="+DataFinalRecebimento;
	    	
	    	List<Recebimento> recebimentos = new ArrayList<>();
	    	String urlParaChamada = webService + modalidade + user + pass + dCnpj + dateIni + dateFin;
	        //String parametro="https://app.salvalucro.com.br/salvalucroWS/Wsstratusx.asmx/ConsultaRecebimentos?Usuario=Modelo&Senha=1&CNPJ=15587828000165&DataInicialRecebimento=2021-01-01&DataFinalRecebimento=2021-01-31"; 
	        
	            URL url = new URL(urlParaChamada);
	            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
	            
	            if (conexao.getResponseCode() != codigoSucesso) {
	            	JOptionPane.showMessageDialog(null, conexao.getResponseMessage());
	                throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());	
	            }	
	            
	            BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
	            String xmlEmString = Util.converteXmlEmString(resposta);
	            xmlEmString = xmlEmString.replaceAll("é", "e"); 
	            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
	         
	          //an instance of builder to parse the specified xml file  
	          DocumentBuilder db = dbf.newDocumentBuilder();  
	        
	          Document doc = db.parse(new InputSource(new  ByteArrayInputStream(xmlEmString.getBytes("utf-8"))));
	          
	          doc.getDocumentElement().normalize();  
	          
	          
	          System.out.println("Root element: " + doc.getDocumentElement().getNodeName());  
	          NodeList nodeList = doc.getElementsByTagName("Recebimento");  
	          
	          for (int i = 0; i < nodeList.getLength(); i++){ 
	        	  
	          Node node = nodeList.item(i);
	         
//	          System.out.println("\nNode Name :" + node.getNodeName());  
//	          System.out.println("teste 3");
	          if (node.getNodeType() == Node.ELEMENT_NODE){  
	          Element eElement = (Element) node; 
	        String ID = ""+i;
	    	String CNPJ = eElement.getElementsByTagName("CNPJ").item(0).getTextContent();
	    	String RAZAOSOCIAL = eElement.getElementsByTagName("RAZAOSOCIAL").item(0).getTextContent();
	    	String DATAVENDA = eElement.getElementsByTagName("DATAVENDA").item(0).getTextContent();
	    	String HORAVENDA = eElement.getElementsByTagName("HORAVENDA").item(0).getTextContent();
	    	String DATACREDITO = eElement.getElementsByTagName("DATACREDITO").item(0).getTextContent();
	    	String ADQUIRENTENOME = eElement.getElementsByTagName("ADQUIRENTENOME").item(0).getTextContent();
	    	String BANDEIRAID = eElement.getElementsByTagName("BANDEIRAID").item(0).getTextContent();
	    	String BANDEIRA = eElement.getElementsByTagName("BANDEIRA").item(0).getTextContent();
	    	String PRODUTO =  eElement.getElementsByTagName("PRODUTO").item(0).getTextContent();
	    	String MODALIDADE = eElement.getElementsByTagName("MODALIDADE").item(0).getTextContent();
	    	String NUMEROPV = eElement.getElementsByTagName("NUMEROPV").item(0).getTextContent();
	    	String NUMEROTERMINAL = eElement.getElementsByTagName("NUMEROTERMINAL").item(0).getTextContent();
	    	String VALORBRUTO = eElement.getElementsByTagName("VALORBRUTO").item(0).getTextContent();
	    	String VALORLIQUIDO = eElement.getElementsByTagName("VALORLIQUIDO").item(0).getTextContent();
	    	String DESCONTO = eElement.getElementsByTagName("DESCONTO").item(0).getTextContent();
	    	String TAXA = eElement.getElementsByTagName("TAXA").item(0).getTextContent();
	    	String CARTAO = eElement.getElementsByTagName("CARTAO").item(0).getTextContent();
	    	String NSU = eElement.getElementsByTagName("NSU").item(0).getTextContent();
	    	String PARCELA = eElement.getElementsByTagName("PARCELA").item(0).getTextContent();
	    	String RO = eElement.getElementsByTagName("RO").item(0).getTextContent();
	    	String DATAPAGAMENTO = eElement.getElementsByTagName("DATAPAGAMENTO").item(0).getTextContent();
	    	String ANTECIPADA = eElement.getElementsByTagName("ANTECIPADA").item(0).getTextContent();
	    	String CUVDATAVENDA = eElement.getElementsByTagName("CUVDATAVENDA").item(0).getTextContent();
	    	
	    	Recebimento r = new Recebimento(ID, CNPJ, RAZAOSOCIAL, DATAVENDA, 
	    									HORAVENDA, DATACREDITO, ADQUIRENTENOME, BANDEIRAID, 
	    									BANDEIRA, PRODUTO, MODALIDADE, NUMEROPV, NUMEROTERMINAL, 
	    									VALORBRUTO, VALORLIQUIDO, DESCONTO, TAXA, CARTAO, NSU, 
	    									PARCELA, RO, DATAPAGAMENTO, ANTECIPADA, CUVDATAVENDA);
	        System.out.println(r.toString());
      
	          recebimentos.add(r);
	          }  
	          }    
				   return recebimentos;
	        
	    }
}
