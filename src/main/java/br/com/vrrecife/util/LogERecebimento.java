package br.com.vrrecife.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JOptionPane;

public class LogERecebimento {

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
	String hoje = dtf.format(LocalDateTime.now());
	String caminho = "C:\\integrador\\logRecebimento\\Arquivo_" + hoje + "_log.txt";
	public void gravaArquivo(List<String> mensagem) {
			
		try {

			FileWriter arq = new FileWriter(caminho);
			PrintWriter gravarArq = new PrintWriter(arq);
			for(String s : mensagem) {
			gravarArq.printf(s+"\n");
			}
			arq.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Arquivo não encontrado!");
		}

	}
}
