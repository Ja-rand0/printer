package office;

public class PrinterNew {
	public int trayCapacity;
	public int sheetsAvailable;
	public int sheetsInTray;
	public int sheets;
	public int totalPages;
	public int documentPages;
	public int nextPage;
	
	/**
	 * @author Christian Salazar.
	 * 
	 * A new constructor Printer is created with the parameter trayCapacity that sets the max limit for how much paper the tray can hold.
	 * This constructor will set the stage for all the variables that will be returned.
	 *@param trayCapacity
	 */
	public PrinterNew(int trayCapacity) {
		this.trayCapacity = trayCapacity;
		sheetsAvailable = 0;
		sheetsInTray = 0;
		totalPages = 0;
		documentPages = 0;
		nextPage = 0;
		
	}
	
	/**
	 * This method will start a new print job that will print sheets of papers from start to finish determined by the value 
	 * input in the parameter documentPages. If I type 5 in the parameter, 5 documents will begin to print start to finish until 
	 * 5 document sheets have been printed. next page updates to 0 (first page) every time the method is called.
	 * @param documentPages
	 */
	public void startPrintJob(int documentPages) {
		this.documentPages = documentPages;
		nextPage = 0;

	}
	
	/**
	 * Returns the number of sheets available for printing.
	 * @return
	 */
	public int getSheetsAvailable() {
		return sheetsAvailable;
		
	}
	
	/**
	 * Returns the next page number of the document that will be printed.
	 * @return
	 */
	public int getNextPage() {
		return nextPage;
		
	}
	
	/**
	 * Returns the count of all pages printed by the printer since its construction.
	 * @return
	 */
	public int getTotalPages() {
		return totalPages;
		
	}
	
	/**
	 * Simulates the printer printing a page. Will only print until there is at least one sheet of paper in the printer left.
	 * totalPages will be incremented to count for the number of pages printed, but will not equal 0 unless printer had no paper to start, 
	 * or if printPage() has not been called.
	 * nextPage will be updated to account for the page number of every document printed, but will wrap around back to 0.
	 * sheetsAvailable is decremented for every printPage() instance, like a real printer, paper is used when you print a sheet.
	 */
	public void printPage() { 
		totalPages += Math.min(sheetsAvailable, 1);
		nextPage = totalPages % documentPages ;
		sheetsAvailable -= 1;
		sheetsAvailable = Math.max(sheetsAvailable, 0);
		
	}
	
	/**
	 * Removes the paper tray from the printer keeping the number of sheets in the tray the same but sheets in the printer 0.
	 */
	public void removeTray() {
		sheetsInTray = sheetsAvailable;
		sheetsAvailable = 0; //Think of sheetsAvailable TO the printer; sheetsAvailables value is retained in the tray.
	}
	
	/**
	 * Paper tray is replaced and the sheets available to the printer are now the same as the paper available in the tray.
	 */
	public void replaceTray() {
		sheetsAvailable = sheetsInTray; //Math.min(sheetsAvailable, trayCapacity);
	}
	
	/**
	 * simulates removing the tray to add paper.
	 * Sheets are added to the tray, adding to sheets value, but to make sure sheetsAvailable doesn't go above trayCapacity,
	 * in Math.min, when trayCapacity becomes the minimum value (100 dummy value)  that means the tray is now full.
	 * @param sheets
	 */
	
	//FIXME: removeTray() sets trayCapacity to 0. in this method trayCapacity() = 0. sheets
	//will always be 0 until fixed.
	public void addPaper(int sheets) { //FIXME: Include methods to simulate adding paper
		this.sheets = sheets;
		
		removeTray(); //NEW FIXME
		sheets = Math.min(sheets,  trayCapacity);
		sheetsAvailable += Math.min(sheets, trayCapacity); 
		sheetsInTray = sheetsAvailable;
		replaceTray(); //NEW FIXME
		
	}
	
	/**
	 * Simulates removing the tray, removing the given number of sheets (but not
		allowing the sheets to go below zero), and replacing the tray in the printer.
	 * @param sheets
	 */
	public void removePaper(int sheets) { //FIXME: add methods to simulate removing paper
		sheetsAvailable -= sheets;
		sheetsAvailable = Math.max(sheetsAvailable, 0);
		
	}

}
