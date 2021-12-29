package br.com.vrrecife.servico;


import br.com.vrrecife.repositorio.RecebimentoDAO;

public class TestaClasse {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		VRProperties vr = new VRProperties();
//		ConexaoServidor con = new ConexaoServidor();
//
		RecebimentoDAO dao = new RecebimentoDAO();
		dao.executaRecebimento();
		
	
		
	}

}
