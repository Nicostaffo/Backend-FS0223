package classi;

import interfacce.IElementoRiproducibile;
import interfacce.IModificaLuminosita;

public class Video extends ElementoMultimediale implements IElementoRiproducibile,IModificaLuminosita{
    
	public int durata;
	public int volume = 0;
	int luminosita = 0;
	
	public Video(String titolo,int durata) {
		super();
		this.durata = durata;
		this.titolo = titolo;
	}


	@Override
	public void play() {
		// TODO Auto-generated method stub
		for(int k = 0;k<this.durata;k++) {	
		System.out.println(this.titolo);
		}
		for(int k = 0;k<this.volume;k++) {
		System.out.print("!");
		}
		for(int k = 0;k<this.luminosita;k++) {
			System.out.print("*");
		}
	}

	@Override
	public int alzaVolume() {
		// TODO Auto-generated method stub
		return this.volume++;
	}

	@Override
	public int abbassaVolume() {
		return this.volume--;
		// TODO Auto-generated method stub
		
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

}
