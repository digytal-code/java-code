package com.digytal.open.modelo.entidade.comum;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("E")
public class EntidadeEmpresa extends EntidadeCadastro {
	@OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "cd_certificado", referencedColumnName = "id_certificado",nullable=true)
	private EntidadeCertificado certificado;
	public EntidadeCertificado getCertificado() {
		return certificado;
	}
	public void setCertificado(EntidadeCertificado certificado) {
		this.certificado = certificado;
	}
}
