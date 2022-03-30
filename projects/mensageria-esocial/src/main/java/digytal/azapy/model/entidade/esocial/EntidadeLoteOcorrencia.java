package digytal.azapy.model.entidade.esocial;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_esocial_lote_ocorrencia")
public class EntidadeLoteOcorrencia {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_ocorrencia")
	private Long id;
	@Column(length=30)
	private Long idEvento;
	@Column(length=10)
	private String erro;
	@Column(length=500)
	private String descricao;
	
}
