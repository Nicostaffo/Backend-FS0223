package esercizio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import classi.Audio;
import classi.ElementoMultimediale;
import classi.Immagine;
import classi.Video;

public class Main {
	
static Scanner scan = new Scanner(System.in);
static List<ElementoMultimediale> elementiMultimediali = new ArrayList<>();

	public static void main(String[] args) {
		 generaElementoMultimediale();
		 mostraElementoMultimediale();	
		 }
       
	public static void generaElementoMultimediale() {
		
        
       int j = 0;
		do {
			System.out.println("Scegli il media che vuoi generare :");
		    System.out.println("1.Immagine  2.Video  3.Audio");
            int tipoMedia = scan.nextInt();
            
            
         switch(tipoMedia){
        
         case 1 :
        	 j ++;
         	System.out.println("Inserisci il titolo dell'immagine :");
         	String titoloImg = scan.next();
            
         	
         	 elementiMultimediali.add(new Immagine(titoloImg));
        	 break;
         case 2 :
        	
         	j ++;
        	System.out.println("Inserisci il titolo del video :");
        	String titoloVid = scan.next();
        	
        	System.out.println("Inserisci la durata del video :");
        	int durataVid = scan.nextInt();
        	
        	 elementiMultimediali.add(new Video(titoloVid, durataVid));
        	
        	 break; 
         case 3 :
        	 j ++;
          	System.out.println("Inserisci il titolo dell'audio :");
          	String titoloAud = scan.next();
          	
          	System.out.println("Inserisci la durata del video :");
        	int durataAud = scan.nextInt();
        	
        	 elementiMultimediali.add(new Audio(titoloAud, durataAud));
        	 break;
         default : 
        	 System.out.println("errore : media già esistente");
         }
        }while(j < 5);
	  }
	
	
	public static void mostraElementoMultimediale() {
		int k = 0;
		while(k == 0) {
		System.out.println("Inserisci un valore da 1 a 5");
		System.out.println("Scegli un media :");
		int med = scan.nextInt();
		switch(med) {
		case 0:
			 k = 1;
			break;
	    default : 
	    	if(elementiMultimediali.get(med - 1) instanceof Immagine) {
	    		Immagine i = (Immagine) elementiMultimediali.get(med - 1);
	    		int luminImg = scan.nextInt();
	    		for (int k1 = 0; k1< luminImg ;k1++) {
	  	    	  i.alzaLuminosita();
	  	    	}
	    		
	    	      i.show();
	    	}else if(elementiMultimediali.get(med - 1) instanceof Video){
	    		Video v = (Video) elementiMultimediali.get(med - 1);
	    		System.out.println("Imposta valore per il volume video, da 1 a 10:");
	    		int volumVid = scan.nextInt();
	    		for (int k1 = 0; k1< volumVid;k1++) {
	  	    	  v.alzaVolume();
	  	    	}
	    		System.out.println("Imposta valore per la luminosita, da 1 a 10 ");
	    		int luminVid = scan.nextInt();
	    		
	    		for (int k1 = 0; k1< luminVid ;k1++) {
		  	    	  v.alzaLuminosita();
		  	    	}
	    		v.play();
	    	}else if(elementiMultimediali.get(med - 1) instanceof Audio) {
	    	 Audio a = (Audio) elementiMultimediali.get(med - 1);
	    	 System.out.println("Imposta valore per il volume audio, da 1 a 10:");
	    	 int volumAud = scan.nextInt();
	    	
	    	for (int k1 = 0; k1< volumAud;k1++) {
	    	  a.alzaVolume();
	    	}
	    		
	    		a.play();
	    	    a.abbassaVolume();
	    	}
	    	
	    break;
		}
	}
  } 
}    
