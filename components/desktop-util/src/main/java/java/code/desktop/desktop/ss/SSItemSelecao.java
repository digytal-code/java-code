package java.code.desktop.desktop.ss;

public class SSItemSelecao {
    private String rotulo;
    private Object valor;
    
    public SSItemSelecao() {
    }
    
    public SSItemSelecao(String rotulo, Object valor) {
        setRotulo(rotulo);
        setValor(valor);
    }

    public void setRotulo(String rotulo) {
        this.rotulo = rotulo;
    }

    public String getRotulo() {
        return rotulo;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public Object getValor() {
        return valor;
    }
    
    public String toString() {
        if (getRotulo() != null)
            return getRotulo();
        else
            return getValor().toString();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof SSItemSelecao)) {
            return false;
        }
        final SSItemSelecao other = (SSItemSelecao)object;
        if (!(valor == null ? other.valor == null : valor.equals(other.valor))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 37;
        int result = 1;
        result = PRIME * result + ((valor == null) ? 0 : valor.hashCode());
        return result;
    }
}
