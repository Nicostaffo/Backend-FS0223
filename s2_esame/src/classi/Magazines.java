package classi;


public class Magazines extends CatalogoBiblio {
private periodicity periodicity;



public Magazines(String iSBM, String titolo, int releaseDate, int nPages, classi.periodicity periodicity) {
	super(iSBM, titolo, releaseDate, nPages);
	this.periodicity = periodicity;
}

public periodicity getPeriodicity() {
	return periodicity;
}

public void setPeriodicity(periodicity periodicity) {
	this.periodicity = periodicity;
}

}
