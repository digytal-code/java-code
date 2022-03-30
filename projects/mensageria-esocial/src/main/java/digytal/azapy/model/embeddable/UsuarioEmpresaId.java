package digytal.azapy.model.embeddable;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UsuarioEmpresaId implements Serializable {
	@Column(name="cd_usuario", length=20,nullable=false,insertable=false,updatable=false)
	private Long cdUsuario;
	@Column(name="cd_empresa", nullable=false)
	private Long cdEmpresa;
	public Long getCdUsuario() {
		return cdUsuario;
	}
	public void setCdUsuario(Long cdUsuario) {
		this.cdUsuario = cdUsuario;
	}
	public Long getCdEmpresa() {
		return cdEmpresa;
	}
	public void setCdEmpresa(Long cdEmpresa) {
		this.cdEmpresa = cdEmpresa;
	}
	
}
