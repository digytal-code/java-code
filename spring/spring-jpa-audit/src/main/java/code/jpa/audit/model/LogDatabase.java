package code.jpa.audit.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_log_database")
public class LogDatabase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "data_hora")
	private LocalDateTime dataHora = LocalDateTime.now();

	private String campo;

	@Column(name = "valor_anterior")
	private String valorAnterior;

	@Column(name = "valor_atual")
	private String valorAtual;

	@Column(name = "tabela_id")
	private String tabelaId;

	@Column(name = "registro_id")
	private String registroId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public LocalDateTime getDataHora() {
		return dataHora;
	}
	
	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}
	
	public String getCampo() {
		return campo;
	}
	
	public void setCampo(String campo) {
		this.campo = campo;
	}
	
	public String getValorAnterior() {
		return valorAnterior;
	}
	
	public void setValorAnterior(String valorAnterior) {
		this.valorAnterior = valorAnterior;
	}
	
	public String getValorAtual() {
		return valorAtual;
	}
	
	public void setValorAtual(String valorAtual) {
		this.valorAtual = valorAtual;
	}
	
	public String getTabelaId() {
		return tabelaId;
	}
	
	public void setTabelaId(String tabelaId) {
		this.tabelaId = tabelaId;
	}
	
	public String getRegistroId() {
		return registroId;
	}
	
	public void setRegistroId(String registroId) {
		this.registroId = registroId;
	}
	
}
