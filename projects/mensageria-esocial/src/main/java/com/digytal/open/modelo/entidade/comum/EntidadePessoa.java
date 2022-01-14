package com.digytal.open.modelo.entidade.comum;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.digytal.open.modelo.embeddable.Endereco;
import com.digytal.open.modelo.enums.TipoDocumento;
@Entity
@Table(name = "tb_comum_pessoa")
public class EntidadePessoa extends Entidade {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_pessoa")
	private Integer id;
	@Column(name="tp_docto", length=6)
	@Enumerated(EnumType.STRING)
	private TipoDocumento tipoDocumento;
	@Column(name="documento", length=30)
	private String documento;
	@Column(name="cpf_cnpj", length=20,nullable = false)
	private String cpfCnpj;
	@Column(length=70)
	private String email;
	@Column(name="nome", length=70,nullable = false)
	private String nome;
	@Column(name="cognome", length=70)
	private String cognome;
	@Column(length=140 ,nullable=false,name="nome_composto")
	private String nomeComposto;
	@Column(name="aniversario")
	@Temporal(TemporalType.DATE)
	private Date aniversario;
	@Column(name="celular1", length=15)
	private String celular;
	@Column(name="celular2", length=15)
	private String celular2;
	@Lob
    @Column(name="foto")
    private byte[] foto;
	@Embedded
	private Endereco endereco;

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public EntidadePessoa() {
		endereco = new Endereco();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getCpfCnpj() {
		return cpfCnpj;
	}
	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getNomeComposto() {
		return nomeComposto;
	}
	public void setNomeComposto(String nomeComposto) {
		this.nomeComposto = nomeComposto;
	}
	public Date getAniversario() {
		return aniversario;
	}
	public void setAniversario(Date aniversario) {
		this.aniversario = aniversario;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getCelular2() {
		return celular2;
	}
	public void setCelular2(String celular2) {
		this.celular2 = celular2;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	@PrePersist
	@PreUpdate
	private void nomeCompleto() {
		nomeComposto = nome + (cognome==null?"" : " "+cognome);
		cpfCnpj=cpfCnpj.replaceAll("\\D", "");
	}
}
