package com.digytal.open.servico.esocial;

import java.util.Date;
import java.util.List;

import com.digytal.open.modelo.Credencial;
import com.digytal.open.modelo.entidade.esocial.EntidadeEvento;
import com.digytal.open.modelo.entidade.esocial.EntidadeLote;
import com.digytal.open.modelo.entidade.esocial.EntidadeRemessa;
import com.digytal.open.modelo.enums.esocial.TipoEvento;
import com.digytal.open.util.model.embedded.Estabelecimento;

public interface RemessaService {
	void gerarRemessa(Estabelecimento estabelecimento, String nome,TipoEvento tipo, String xml) throws Exception;
	void gerarRemessa(Estabelecimento estabelecimento, TipoEvento tipo, String xml) throws Exception;
	//void montarEnvelope(Credencial credencial,String tipo, Long remessa) throws Exception;
	//void transmitir(Credencial certificado,Long idRemessa) throws Exception;
	//void consultarRemessaLotes(Credencial certificado,Long remessa) throws Exception;
	//void incluir(EntidadeRemessa entidade);
	
	EntidadeLote consultarLote(Long filial,Long lote) throws Exception;
	
	List<EntidadeRemessa> listarFilialRemessas(Long filial,Date inicio, Date fim);
	List<EntidadeLote> listarLotes(Long remessa);
	List<EntidadeEvento> listarEventos(Long lote);
	//Credencial atualizarCredencial(Long filial);
}
