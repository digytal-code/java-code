package com.digytal.open.servico;

import java.util.List;

import com.digytal.open.modelo.entidade.comum.EntidadeCadastro;
import com.digytal.open.modelo.entidade.comum.EntidadeCertificado;
import com.digytal.open.modelo.entidade.comum.EntidadeEmpresa;

public interface CadastroService {
	void incluir(EntidadeCadastro entidade);
	void incluirCertificado(EntidadeCertificado entidade);
	void alterarCertificado(EntidadeCertificado entidade);
	void alterar(EntidadeCadastro usuario);
	EntidadeEmpresa buscarEmpresa(String  cnpj);
	List<EntidadeEmpresa> listarEmpresas();
	List<EntidadeCertificado> listarCertificados();
}
