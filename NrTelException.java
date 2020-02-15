
public class NrTelException extends RuntimeException {

    public NrTelException() {
        super("Numarul de telefon trebuie sa contina 10 sau 13 cifre!!");
    }

    
    public NrTelException(String msg) {
        super(msg);
    }
}
