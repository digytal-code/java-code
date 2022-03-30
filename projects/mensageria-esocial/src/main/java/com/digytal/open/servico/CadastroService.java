package com.digytal.open.servico;

import java.util.List;

import digytal.azapy.model.entidade.comum.EntidadeCadastro;
import digytal.azapy.model.entidade.comum.EntidadeCertificado;
import digytal.azapy.model.entidade.comum.EntidadeEmpresa;

public interface CadastroService {
	void incluir(EntidadeCadastro entidade);
	void incluirCertificado(EntidadeCertificado entidade);
	void alterarCertificado(EntidadeCertificado entidade);
	void alterar(EntidadeCadastro usuario);
	EntidadeEmpresa buscarEmpresa(String  cnpj);
	List<EntidadeEmpresa> listarEmpresas();
	List<EntidadeCertificado> listarCertificados();
}
