package classi;

public abstract class CatalogoBiblio {
	
 private String ISBM;
 private String titolo;
 private int releaseDate;
 private int nPages;
 
public CatalogoBiblio(String ISBM, String titolo, int releaseDate, int nPages) {
	super();
	this.ISBM = ISBM;
	this.titolo = titolo;
	this.releaseDate = releaseDate;
	this.nPages = nPages;
 }

public String getISBM() {
	return ISBM;
}

public void setISBM(String iSBM) {
	ISBM = iSBM;
}

public String getTitolo() {
	return titolo;
}

public void setTitolo(String titolo) {
	this.titolo = titolo;
}

public int getReleaseDate() {
	return releaseDate;
}

public void setReleaseDate(int releaseDate) {
	this.releaseDate = releaseDate;
}

public int getnPages() {
	return nPages;
}

public void setnPages(int nPages) {
	this.nPages = nPages;
}

}
