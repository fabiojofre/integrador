package br.com.vrrecife.repositorio;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import br.com.vrrecife.dominio.Recebimento;
import br.com.vrrecife.servico.Servico;
import br.com.vrrecife.util.LogERecebimento;
import vrcore.classe.ConexaoServidor;
import vrrecifeframework.classes.VrProperties;

public class RecebimentoDAO {
	
	public void executaRecebimento() throws IOException {
		List<Recebimento> rec;// = new ArrayList<>();
		List<String>log= new ArrayList();
		VrProperties vr = new VrProperties();
		
	
		ConexaoServidor con = new ConexaoServidor();
		Servico s =new Servico();
	
		String db_ip =  VrProperties.getString("database.ip");
		int db_porta = VrProperties.getInt("database.porta");
		String db_nome = VrProperties.getString("database.nome");
		String db_usuario = VrProperties.getString("database.usuario");
		String db_senha = VrProperties.getString("database.senha");
		
		String i_usuario = VrProperties.getString("redecen.usuario");
		String i_senha = VrProperties.getString("redecen.senha");
		String i_cnpj = VrProperties.getString("redecen.cnpj");
		String i_ultimaConsulta = VrProperties.getString("redecen.ultima_consulta");
		int i_minutos_consulta = VrProperties.getInt("redecen.minutos_consulta");
		int i_idbanco = VrProperties.getInt("redecen.id_banco");
		String i_conta = VrProperties.getString("redecen.conta");
		String i_agencia = VrProperties.getString("redecen.agencia");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String hoje;
       		
		
		try {
			rec = s.buscaEnderecoPelo(i_usuario,i_senha,i_cnpj, i_ultimaConsulta, dtf.format(LocalDateTime.now()));
			con.abrirConexao(db_ip, db_porta, db_nome, db_usuario, db_senha);
			for(int i = 0; i <rec.size(); i++) {
				try {
				String sql = "INSERT INTO redecen.recebimento ("
						+ "CNPJ, RAZAOSOCIAL, DATAVENDA, HORAVENDA, DATACREDITO,"
						+ "ADQUIRENTENOME, BANDEIRAID,BANDEIRA, PRODUTO, "
						+ "MODALIDADE, NUMEROPV, NUMEROTERMINAL, VALORBRUTO, "
						+ "VALORLIQUIDO, DESCONTO, TAXA, CARTAO, NSU, PARCELA, RO, "
						+ "DATAPAGAMENTO, ANTECIPADA, CUVDATAVENDA, ID_BANCO, AGENCIA, CONTA) "
						+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				 PreparedStatement statement = con.prepareStatement(sql);
				 statement.setString(1, rec.get(i).getCNPJ());
				 statement.setString(2, rec.get(i).getRAZAOSOCIAL());
				 statement.setString(3, rec.get(i).getDATAVENDA());
				 statement.setString(4, rec.get(i).getHORAVENDA());
				 statement.setString(5, rec.get(i).getDATACREDITO());
				 statement.setString(6, rec.get(i).getADQUIRENTENOME());
				 statement.setString(7, rec.get(i).getBANDEIRAID());
				 statement.setString(8, rec.get(i).getBANDEIRA());
				 statement.setString(9, rec.get(i).getPRODUTO());
				 statement.setString(10, rec.get(i).getMODALIDADE());
				 statement.setString(11, rec.get(i).getNUMEROPV());
				 statement.setString(12, rec.get(i).getNUMEROTERMINAL());
				 statement.setString(13, rec.get(i).getVALORBRUTO());
				 statement.setString(14, rec.get(i).getVALORLIQUIDO());
				 statement.setString(15, rec.get(i).getDESCONTO());
				 statement.setString(16, rec.get(i).getTAXA());
				 statement.setString(17, rec.get(i).getCARTAO());
				 statement.setString(18, rec.get(i).getNSU());
				 statement.setString(19, rec.get(i).getPARCELA());
				 statement.setString(20, rec.get(i).getRO());
				 statement.setString(21, rec.get(i).getDATAPAGAMENTO());
				 statement.setString(22, rec.get(i).getANTECIPADA());
				 statement.setString(23, rec.get(i).getCUVDATAVENDA());
				 statement.setInt(24, i_idbanco);
				 statement.setString(25, i_agencia);
				 statement.setString(26, i_conta);
						 
								  
				 int rowsInserted = statement.executeUpdate();
				 
				 if (rowsInserted > 0) {
				     System.out.println("A new user was inserted successfully!");
				 }
				}catch (SQLException e) {
					log.add("Erro na inserção do dado, "+e);
				}
				 
			}
			
		} catch (IOException | JAXBException | ParserConfigurationException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		VrProperties.setProperty("redecen.ultima_consulta", dtf.format(LocalDateTime.now()));
		 LogERecebimento lr = new LogERecebimento();
		 lr.gravaArquivo(log);
}
	

}
