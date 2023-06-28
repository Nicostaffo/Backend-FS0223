package esercizio_1;

public class Main1 {

	public static void main(String[] args) {
    System.out.println(stringaPariDispari("ciao"));
    System.out.println(stringaPariDispari("bue"));
    System.out.println("***********************");
    System.out.println(annoBisestile(28));
    System.out.println(annoBisestile(31));
    System.out.println("***********************");
	}
   public static boolean  stringaPariDispari(String str) {
	   if(str.length()%2 == 0) {
		   return true ; 
	   } else {
		   return false;
	   }
	    
   }
   public static boolean annoBisestile(int year) {
	   if(year%4 == 0) {
		  return true;
	   }else if (year%100 == 0 && year%400 == 0) {
		  return true; 
	   }else {
		  return false;
	   }
   }
}
