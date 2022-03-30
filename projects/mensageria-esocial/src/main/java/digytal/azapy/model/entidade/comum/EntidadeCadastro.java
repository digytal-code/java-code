package digytal.azapy.model.entidade.comum;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
@Table(name="tb_comum_cadastro")
public abstract class EntidadeCadastro extends Entidade {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_cadastro")
	private Long id;
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="cd_pessoa")
	private EntidadePessoa pessoa;
	@Column(name="dt_cadastro",nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataCadastro;
	public EntidadeCadastro() {
		this.pessoa=new EntidadePessoa();
		this.dataCadastro=new Date();
	}
	public Long getId() {
		return id;
	}
	public EntidadePessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(EntidadePessoa pessoa) {
		this.pessoa = pessoa;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	@PrePersist
	private void prePersist() {
		this.dataCadastro = new Date();
		this.pessoa.setEstabelecimento(estabelecimento);
	}
	
}
