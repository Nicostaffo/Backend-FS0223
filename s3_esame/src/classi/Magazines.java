package classi;


import javax.persistence.*;

@Entity
@Table(name = "riviste")
public class Magazines extends CatalogoBiblio {
    @Enumerated(EnumType.STRING)
    private periodicity periodicita;

    public Magazines() {
    }

    public Magazines(String codiceISBN, String titolo, int annoPubblicazione, int numeroPagine, periodicity periodicita) {
        super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }

    public periodicity getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(periodicity periodicita) {
        this.periodicita = periodicita;
    }
}