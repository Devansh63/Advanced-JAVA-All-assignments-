package project3_DevanshAgrawal_CS161;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class OrderRecord {
	
	private String currentReport;
	private double currentTotal;
	/**
	 * Constructor that i use to initialize the variables.
	 * @author devansh
	 *
	 */
	public OrderRecord() {
		this.currentReport = "";
		this.currentTotal = 0.0;
	}
	/**
	 * This method is use to creat the report with a date stamp on the name then write the days orders in the report.
	 * @author devansh
	 *
	 */
	public void produceReport() {
		 String strDateFormat = "MM,dd";
		    DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
		    String fileName = "Report_" + dateFormat.format(Calendar.getInstance().getTime()) + ".txt";
		    try
		    {
		      PrintWriter printwriter = new PrintWriter(new FileWriter(fileName));
		      DecimalFormat decimalFormat = new DecimalFormat("$##.00");
		      printwriter.write(this.currentReport);
		      printwriter.write(System.getProperty("line.separator"));
		      printwriter.write("Total from the day: " + decimalFormat.format(this.currentTotal));
		      printwriter.close();
		    }
		    catch (IOException e)
		    {
		      e.printStackTrace();
		    }
	}
	/**
	 * Used to ass order.
	 * @author devansh
	 *
	 */
	public void addOrder(String order, double cost) {
        this.currentTotal += cost;
        this.currentReport = String.valueOf(this.currentReport) + order;
    }
	
}
