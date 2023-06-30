package classi;

import interfacce.IElementoRiproducibile;

public class Audio extends ElementoMultimediale implements IElementoRiproducibile{
    
	public int durata = 0;
	public int volume = 0;
	
	public Audio(String titolo, int durata) {
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
	}

	
	@Override
	public int alzaVolume() {
		// TODO Auto-generated method stub
		return this.volume++;
	}

	@Override
	public int abbassaVolume() {
		// TODO Auto-generated method stub
		return this.volume--;
	}

}
