package esercizi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main1 {

	private static Logger log = LoggerFactory.getLogger(Main1.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread thread1 = new Thread(new SymbolPrinter("*"));
        Thread thread2 = new Thread(new SymbolPrinter("#"));

        thread1.start();
        thread2.start();
	}
	static class SymbolPrinter implements Runnable {
	    private String symbol;

	    public SymbolPrinter(String symbol) {
	        this.symbol = symbol;
	    }
	    public void run() {
	        for (int i = 0; i < 10; i++) {
	            log.info(symbol);
	            try {
	                Thread.sleep(1000);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	                log.info("");
	            }
	        }
	    }
    }
}