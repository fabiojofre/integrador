
create schema redecen;


CREATE TABLE IF NOT EXISTS redecen.recebimento
(
    CNPJ character varying COLLATE pg_catalog."default" NOT NULL,
    RAZAOSOCIAL character varying COLLATE pg_catalog."default" NOT NULL,
    DATAVENDA character varying COLLATE pg_catalog."default" NOT NULL,
    HORAVENDA character varying COLLATE pg_catalog."default",
    DATACREDITO character varying COLLATE pg_catalog."default",
    ADQUIRENTENOME character varying COLLATE pg_catalog."default",
    BANDEIRAID character varying COLLATE pg_catalog."default"NOT NULL,
    BANDEIRA character varying COLLATE pg_catalog."default",
    PRODUTO character varying COLLATE pg_catalog."default",
    MODALIDADE character varying COLLATE pg_catalog."default",
    NUMEROPV character varying COLLATE pg_catalog."default",
    NUMEROTERMINAL character varying COLLATE pg_catalog."default",
    VALORBRUTO character varying COLLATE pg_catalog."default",
    VALORLIQUIDO character varying COLLATE pg_catalog."default",
    DESCONTO character varying COLLATE pg_catalog."default",
    TAXA character varying COLLATE pg_catalog."default",
    CARTAO character varying COLLATE pg_catalog."default",
    NSU character varying COLLATE pg_catalog."default"NOT NULL,
    PARCELA character varying COLLATE pg_catalog."default",
    RO character varying COLLATE pg_catalog."default",
    DATAPAGAMENTO character varying COLLATE pg_catalog."default",
    ANTECIPADA character varying COLLATE pg_catalog."default",
    CUVDATAVENDA character varying COLLATE pg_catalog."default",
    ID_BANCO integer,
    AGENCIA character varying COLLATE pg_catalog."default",
    CONTA character varying COLLATE pg_catalog."default",
    CONSTRAINT recebimento_pkey PRIMARY KEY (BANDEIRAID, NSU,PARCELA)
);

   
 
   
CREATE OR REPLACE FUNCTION redecen_gatilho() RETURNS trigger AS $redecen_gatilho$
	declare 
		id_concilia 		integer;
		id_concilia_atual  	integer;
		id_concilialanc 	integer;
	BEGIN
	   select distinct id into id_concilia from conciliacaobancaria where new.id_banco = id_banco and new.conta = conta and new.agencia = agencia and cast(new.datapagamento as date)= "data" order by 1 desc limit 1;
	   select max(id) into id_concilia_atual from conciliacaobancaria;
	   select max(id) into id_concilialanc from conciliacaobancarialancamento;
	
	  if id_concilia is null then
	  	INSERT INTO public.conciliacaobancaria(id,"data", id_banco, agencia, conta, id_situacaoconciliacaobancaria,saldo)
		 VALUES(id_concilia_atual+1, cast(new.datapagamento as date), new.id_banco, new.agencia, new.conta, 0, 0); 
           
        INSERT INTO public.conciliacaobancarialancamento(id, id_conciliacaobancaria, id_contacontabilfinanceiro,id_tipoinscricao, cnpj, valorcredito, valordebito, observacao, 
					id_contacontabilfiscaldebito, id_contacontabilfiscalcredito, id_conciliacaobancarialancamentotransferencia)
		VALUES (id_concilialanc+1, id_concilia_atual+1, 1, 0, 0, cast(new.valorliquido as numeric(11,2)), 0, new.bandeiraid||'-'||new.bandeira, null, 5, null);
	
	else 
		 INSERT INTO public.conciliacaobancarialancamento(id, id_conciliacaobancaria, id_contacontabilfinanceiro,id_tipoinscricao, cnpj, valorcredito, valordebito, observacao, 
					id_contacontabilfiscaldebito, id_contacontabilfiscalcredito, id_conciliacaobancarialancamentotransferencia)
		VALUES (id_concilialanc+1, id_concilia, 1, 0, 0, cast(new.valorliquido as numeric(11,2)), 0, new.bandeiraid||'-'||new.bandeira, null, 5, null);
     end if; 
    return new;
       	select setval ('conciliacaobancarialancamento_id_seq', id_concilialanc);
		select setval ('conciliacaobancaria_id_seq', id_concilia_atual);
    END;
$redecen_gatilho$ LANGUAGE plpgsql;



CREATE TRIGGER redecen_gatilho BEFORE INSERT ON redecen.recebimento 
    FOR EACH ROW EXECUTE PROCEDURE redecen_gatilho();

    

