package digytal.azapy.model.entidade.param;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_comum_param")
public class EntidadeParametro {
	@Id
	@Column(name="id_param")
	private String id;
	@Column(name="valor")
	private String valor;
	@Column(name="descricao")
	private String descricao;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
