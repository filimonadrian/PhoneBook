
public class CnpException extends RuntimeException {

    public CnpException() {
        super("CNP-ul trebuie sa contina 13 cifre!!");
    }

    public CnpException(String msg) {
        super(msg);
    }
}
