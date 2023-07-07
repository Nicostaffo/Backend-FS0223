package classi;

public abstract class CatalogoBiblio {
	
 private String ISBM;
 public String titolo;
 public int releaseDate;
 public int nPages;
 
public CatalogoBiblio(String iSBM, String titolo, int releaseDate, int nPages) {
	super();
	setISBM(iSBM);
	this.titolo = titolo;
	this.releaseDate = releaseDate;
	this.nPages = nPages;
 }

public String getISBM() {
	return ISBM;
}

@Override
public String toString() {
	return "CatalogoBiblio [ISBM=" + ISBM + ", titolo=" + titolo + ", releaseDate=" + releaseDate + ", nPages=" + nPages
			+ "]";
}

public void setISBM(String iSBM) {
	ISBM = iSBM;
}
public String getTitolo() {
	// TODO Auto-generated method stub
	return titolo;
}

public int getReleaseDate() {
	// TODO Auto-generated method stub
	return releaseDate;
}

}
