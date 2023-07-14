package classi;


public class Books extends CatalogoBiblio {
String author;
String genres;
public Books(String iSBM, String titolo, int releaseDate, int nPages, String author, String genres) {
	super(iSBM, titolo, releaseDate, nPages);
	this.author = author;
	this.genres = genres;
}
@Override
public String toString() {
	return "Books [author=" + author + ", genres=" + genres + "]";
}
public String getAuthor() {
	// TODO Auto-generated method stub
	return author;
}


}