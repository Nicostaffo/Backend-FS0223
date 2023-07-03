package esercizio_3;

public class BankExeption extends Exception {
    private String message;

    public BankExeption(String message) {
        super();
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}