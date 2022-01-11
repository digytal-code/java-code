package code.desktop.ss.util;

public class SSValidacaoException extends Exception {
    public SSValidacaoException(Throwable throwable) {
        super(throwable);
    }

    public SSValidacaoException(String string, Throwable throwable) {
        super(string, throwable);
    }

    public SSValidacaoException(String string) {
        super(string);
    }

    public SSValidacaoException() {
        super();
    }
}
