package br.com.vrrecife.dominio;

public class Recebimento {
	
	private String id;
	private String CNPJ;
	private String RAZAOSOCIAL;
	private String DATAVENDA;
	private String HORAVENDA;
	private String DATACREDITO;
	private String ADQUIRENTENOME;
	private String BANDEIRAID;
	private String BANDEIRA;
	private String PRODUTO;
	private String MODALIDADE;
	private String NUMEROPV;
	private String NUMEROTERMINAL;
	private String VALORBRUTO;
	private String VALORLIQUIDO;
	private String DESCONTO;
	private String TAXA;
	private String CARTAO;
	private String NSU;
	private String PARCELA;
	private String RO;
	private String DATAPAGAMENTO;
	private String ANTECIPADA;
	private String CUVDATAVENDA;
	
	
	public Recebimento(String id, String cNPJ, String rAZAOSOCIAL, String dATAVENDA, String hORAVENDA,
			String dATACREDITO, String aDQUIRENTENOME, String bANDEIRAID, String bANDEIRA, String pRODUTO,
			String mODALIDADE, String nUMEROPV, String nUMEROTERMINAL, String vALORBRUTO, String vALORLIQUIDO,
			String dESCONTO, String tAXA, String cARTAO, String nSU, String pARCELA, String rO, String dATAPAGAMENTO,
			String aNTECIPADA, String cUVDATAVENDA) {
		super();
		this.id = id;
		CNPJ = cNPJ;
		RAZAOSOCIAL = rAZAOSOCIAL;
		DATAVENDA = dATAVENDA;
		HORAVENDA = hORAVENDA;
		DATACREDITO = dATACREDITO;
		ADQUIRENTENOME = aDQUIRENTENOME;
		BANDEIRAID = bANDEIRAID;
		BANDEIRA = bANDEIRA;
		PRODUTO = pRODUTO;
		MODALIDADE = mODALIDADE;
		NUMEROPV = nUMEROPV;
		NUMEROTERMINAL = nUMEROTERMINAL;
		VALORBRUTO = vALORBRUTO;
		VALORLIQUIDO = vALORLIQUIDO;
		DESCONTO = dESCONTO;
		TAXA = tAXA;
		CARTAO = cARTAO;
		NSU = nSU;
		PARCELA = pARCELA;
		RO = rO;
		DATAPAGAMENTO = dATAPAGAMENTO;
		ANTECIPADA = aNTECIPADA;
		CUVDATAVENDA = cUVDATAVENDA;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}
	public String getRAZAOSOCIAL() {
		return RAZAOSOCIAL;
	}
	public void setRAZAOSOCIAL(String rAZAOSOCIAL) {
		RAZAOSOCIAL = rAZAOSOCIAL;
	}
	public String getDATAVENDA() {
		return DATAVENDA;
	}
	public void setDATAVENDA(String dATAVENDA) {
		DATAVENDA = dATAVENDA;
	}
	public String getHORAVENDA() {
		return HORAVENDA;
	}
	public void setHORAVENDA(String hORAVENDA) {
		HORAVENDA = hORAVENDA;
	}
	public String getDATACREDITO() {
		return DATACREDITO;
	}
	public void setDATACREDITO(String dATACREDITO) {
		DATACREDITO = dATACREDITO;
	}
	public String getADQUIRENTENOME() {
		return ADQUIRENTENOME;
	}
	public void setADQUIRENTENOME(String aDQUIRENTENOME) {
		ADQUIRENTENOME = aDQUIRENTENOME;
	}
	public String getBANDEIRAID() {
		return BANDEIRAID;
	}
	public void setBANDEIRAID(String bANDEIRAID) {
		BANDEIRAID = bANDEIRAID;
	}
	public String getBANDEIRA() {
		return BANDEIRA;
	}
	public void setBANDEIRA(String bANDEIRA) {
		BANDEIRA = bANDEIRA;
	}
	public String getPRODUTO() {
		return PRODUTO;
	}
	public void setPRODUTO(String pRODUTO) {
		PRODUTO = pRODUTO;
	}
	public String getMODALIDADE() {
		return MODALIDADE;
	}
	public void setMODALIDADE(String mODALIDADE) {
		MODALIDADE = mODALIDADE;
	}
	public String getNUMEROPV() {
		return NUMEROPV;
	}
	public void setNUMEROPV(String nUMEROPV) {
		NUMEROPV = nUMEROPV;
	}
	public String getNUMEROTERMINAL() {
		return NUMEROTERMINAL;
	}
	public void setNUMEROTERMINAL(String nUMEROTERMINAL) {
		NUMEROTERMINAL = nUMEROTERMINAL;
	}
	public String getVALORBRUTO() {
		return VALORBRUTO;
	}
	public void setVALORBRUTO(String vALORBRUTO) {
		VALORBRUTO = vALORBRUTO;
	}
	public String getVALORLIQUIDO() {
		return VALORLIQUIDO;
	}
	public void setVALORLIQUIDO(String vALORLIQUIDO) {
		VALORLIQUIDO = vALORLIQUIDO;
	}
	public String getDESCONTO() {
		return DESCONTO;
	}
	public void setDESCONTO(String dESCONTO) {
		DESCONTO = dESCONTO;
	}
	public String getTAXA() {
		return TAXA;
	}
	public void setTAXA(String tAXA) {
		TAXA = tAXA;
	}
	public String getCARTAO() {
		return CARTAO;
	}
	public void setCARTAO(String cARTAO) {
		CARTAO = cARTAO;
	}
	public String getNSU() {
		return NSU;
	}
	public void setNSU(String nSU) {
		NSU = nSU;
	}
	public String getPARCELA() {
		return PARCELA;
	}
	public void setPARCELA(String pARCELA) {
		PARCELA = pARCELA;
	}
	public String getRO() {
		return RO;
	}
	public void setRO(String rO) {
		RO = rO;
	}
	public String getDATAPAGAMENTO() {
		return DATAPAGAMENTO;
	}
	public void setDATAPAGAMENTO(String dATAPAGAMENTO) {
		DATAPAGAMENTO = dATAPAGAMENTO;
	}
	public String getANTECIPADA() {
		return ANTECIPADA;
	}
	public void setANTECIPADA(String aNTECIPADA) {
		ANTECIPADA = aNTECIPADA;
	}
	public String getCUVDATAVENDA() {
		return CUVDATAVENDA;
	}
	public void setCUVDATAVENDA(String cUVDATAVENDA) {
		CUVDATAVENDA = cUVDATAVENDA;
	}
	@Override
	public String toString() {
		return "Recebimento [id=" + id + ", CNPJ=" + CNPJ + ", RAZAOSOCIAL=" + RAZAOSOCIAL + ", DATAVENDA=" + DATAVENDA
				+ ", HORAVENDA=" + HORAVENDA + ", DATACREDITO=" + DATACREDITO + ", ADQUIRENTENOME=" + ADQUIRENTENOME
				+ ", BANDEIRAID=" + BANDEIRAID + ", BANDEIRA=" + BANDEIRA + ", PRODUTO=" + PRODUTO + ", MODALIDADE="
				+ MODALIDADE + ", NUMEROPV=" + NUMEROPV + ", NUMEROTERMINAL=" + NUMEROTERMINAL + ", VALORBRUTO="
				+ VALORBRUTO + ", VALORLIQUIDO=" + VALORLIQUIDO + ", DESCONTO=" + DESCONTO + ", TAXA=" + TAXA
				+ ", CARTAO=" + CARTAO + ", NSU=" + NSU + ", PARCELA=" + PARCELA + ", RO=" + RO + ", DATAPAGAMENTO="
				+ DATAPAGAMENTO + ", ANTECIPADA=" + ANTECIPADA + ", CUVDATAVENDA=" + CUVDATAVENDA + "]";
	}
	

}
