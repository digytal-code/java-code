package digytal.azapy.model.esocial.processamento;

public class DadosProcessamentoLote {
	private String versaoAplicativoProcessamentoLote;

    public String getVersaoAplicativoProcessamentoLote() {
        return versaoAplicativoProcessamentoLote;
    }

    public void setVersaoAplicativoProcessamentoLote(String value) {
        this.versaoAplicativoProcessamentoLote = value;
    }

	@Override
	public String toString() {
		return "DadosProcessamentoLote [versaoAplicativoProcessamentoLote=" + versaoAplicativoProcessamentoLote + "]";
	}
    
}
