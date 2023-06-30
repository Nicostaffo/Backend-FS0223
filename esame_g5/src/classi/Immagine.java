package classi;

import interfacce.IModificaLuminosita;

public class Immagine extends ElementoMultimediale implements IModificaLuminosita{

	int luminosita = 0;
	
public Immagine(String titoloImg) {
		this.titolo = titoloImg;
	}

@Override
public int alzaLuminosita() {
	// TODO Auto-generated method stub
	return this.luminosita++;
}

@Override
public int abbassaLuminosita() {
	// TODO Auto-generated method stub
	return this.luminosita--;
}

public void show() {
	System.out.println(this.titolo);
	for(int k = 0;k<this.luminosita;k++) {
		System.out.print("*");
	}
}
}
