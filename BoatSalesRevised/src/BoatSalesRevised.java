import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

/*
 * 
 * Najmeldin Khamis
 */


public class BoatSalesRevised {
	//declaring variables
	static Scanner MyScanner;    //input device
	static  String iData;        //Data
	static String  oBoatTypes;   // BoatType after formatting for currency display
	static String  iBoatType ;   // BoatType 
	static String  iLoops ="Y" ;
	static String  oQuantity;    //Quantity after formatting for  currency display
	static String  oPrepCost;    //PrepCost after formatting for  currency display
	static String  oTax;         //Tax after formatting for  currency display
	static String  oTotalSlae;   // TotalSale after formatting for  currency display
	static String  oSubtotal;    // SubTotal after formatting for  currency display
	static String  oMarkupAmount; //MarkupAmount after formatting for  currency display
	static String  oAccessoryType; //Accessory after formatting for currency display
	static double  cMarkupAmount;  // MarkupAmount after conversion
	static double  iBoatCost;      // boatCost
	static double  iPrepCost;      //prepCost
	static double  cAccessoryCost;  // AccessoryCost after conversion
	static double  cGrandTotalSales= 0;
	static double  cTax = 0.06;
    static double  cMarkupChoice;   //MarkupChice after conversion
	static double  cSubtotal;       // calculated SubTotal 
	static double  TAX_RATE;
	static double  cTotalSale;      // calculated TotalSale
	static int     iAccessoryType;
	static int     cGrandTotalNumOfSales = 0;
	static int     iQuantity;
	static NumberFormat nf; 	  //used to format currency
	
	public static void main(String[] args) {
		 //call init
	     init();
	     
	     while (iLoops.equalsIgnoreCase("Y")) {
	      //call input 
		   input();
		 
		   //validation
		    validation();
		 
		    //call calcs
		     calcs();
		 
		   //call output
		    output();
		 
		 System.out.println("buy mor boats?(Y/N)");
		 iLoops = MyScanner.next();
		 while (!iLoops.equalsIgnoreCase("Y") && ! iLoops.equalsIgnoreCase("N")) {
		 System.out.println(" please enter Y or N, buy mor boats?(Y/N)");
		 iLoops = MyScanner.next();
	    }
	  }
	   closing();
	
   }
    public static void init() {
	     MyScanner = new Scanner (System.in);    //instantiating the MyScanner object
	     MyScanner.useDelimiter("\r\n");         //override default of spaces to return 
	    
	    nf=new DecimalFormat("$#,###.00");
	}
    public static void input() {
	    
    	//prompt for BoatType
	    System.out.println("enter boat Type. (B, P, S, C)");
	    iBoatType = MyScanner.next();
	    System.out.println("enter Accessory Type. (1, 2, 3)");
	    iData = MyScanner.next();
	    
	    try {
		iAccessoryType = Integer.parseInt(iData);
		}
		catch(Exception e) {
		System.out.println(" Accessory Type must be a number. the default of 1 (Electroics)");
		iAccessoryType = 1;
		//prompt for AccessoryType
		}
	    System.out.println("enter Accessory Type. (1-25)");
	    iData = MyScanner.next();
	   
	    try {
		iQuantity = Integer.parseInt(iData);
		}
		catch(Exception e) {
		System.out.println(" Quantity must be a number. the default of 1 ");
		iQuantity = 1;
		//prompt for BoatType
		}
	    System.out.println("enter  boat price . ($2,500 - $150,000)");
	    iData = MyScanner.next().replaceAll(" ,", "");
	    
	    try {
		iBoatCost = Double.parseDouble(iData);
		}
		catch(Exception e) {
		System.out.println(" Boat price  must be a number. the default of $25,000");
		iBoatCost= 25000;
		}
	    System.out.println("enter prep Cost  ($100-9999.99$)");
	    iData = MyScanner.next().replaceAll(" ,", "");
	   
	    try {
		iPrepCost = Double.parseDouble(iData);
		}
		catch(Exception e) {
		System.out.println("  Prep Cost must be a number . the default of  $5,000");
		iPrepCost= 5000;
	     }
	   }
     public static void validation() {
    	//prompt and validate boatType
	    if(iBoatType.equalsIgnoreCase("B") || iBoatType.equalsIgnoreCase("P")||
		iBoatType.equalsIgnoreCase("S") || iBoatType.equalsIgnoreCase("C")) {
	    }
	    else {
		System.out.println(" Boat Type  must be  B, P, S or C. the default of S (Ski Package) will be used");
		iBoatType= "S";
		
	    }
        if( iAccessoryType == 1 || iAccessoryType == 2 ||iAccessoryType == 3 ) {
	 
        }
        else {
	    System.out.println(" Accessory must be  1, 2, Sor 3. the default of 1 (Electronics)");
		iAccessoryType= 1;
		//prompt and validate AccessoryType
	    } 
        if( iQuantity >25 || iQuantity <1 ) {
	    System.out.println(" Quantity  must be  between 1 & 25. the default of 1 ");
		iQuantity= 1; 
		//prompt and validate Quantity
        }
	    else {
        }
        if (iBoatCost >150000 || iBoatCost <2500) {
	    System.out.println("Boat Cost must be bteween $2,00 & $150,00. Default of $5,000 ");
	    iBoatCost = 2500;
	  //prompt and validate BoatCost
        }
        else {
	     }
        if (iPrepCost >9999.99 || iPrepCost <100) {
	    System.out.println("Prep Cost must be bteween $100 & $9999,99. Default of $5,000 ");
	    iPrepCost = 5000;
	  
	    }
        else {
	
        }
      }
      public static void calcs() {
    	  switch(iBoatType.toUpperCase()) { 			 
		  case "B":
		        oBoatTypes = "Bass";
			    cMarkupChoice = .33;
			    break;
		  case "P":
		        oBoatTypes = "Pontoon";
			    cMarkupChoice = .25;
			    break;	
		  case "S":
		        oBoatTypes = "Ski";
			    cMarkupChoice = .425;
			    break;
		  case "C":
		        oBoatTypes = "Canoe";	
			    cMarkupChoice = .20;
			    break;
        }switch(iAccessoryType) { 
		  case 1:
			    oAccessoryType = "Electronics";
				cAccessoryCost = 5415.3;
				break;
					
		  case 2:
				oAccessoryType = "Ski Package";
				cAccessoryCost = 3980;
				break;
		 default:		
		  case 3:
				oAccessoryType = "Fishing Package";
				cAccessoryCost = 345.45;
				break;
					
	    }
					
		 cMarkupAmount = Math.ceil(iBoatCost*cMarkupChoice*100)/100;
		 cSubtotal = Math.round(iBoatCost + cAccessoryCost + iPrepCost + cMarkupAmount)
	     * iQuantity * 100 /100.0;
	
	     cTax = Math.ceil(cSubtotal * TAX_RATE*100)/100;
	     cTotalSale = cTax + cSubtotal;
	     cGrandTotalNumOfSales += 1;
	     cGrandTotalSales += Math.ceil(cTotalSale*100)/100;
       }
	
    public static void output() {

	     //display name boatType 
	     System.out.println(oBoatTypes+"....." +iBoatCost);
	     //format and output AccessoryType
	     oAccessoryType =nf.format(cAccessoryCost);
	     System.out.println("AccessoryType....."+cAccessoryCost);
	     //display AccessoryType
	     System.out.println("Quantity....." + iQuantity);	
	     //format and output Quantity
	     oQuantity =nf.format(iQuantity);
	     //display Quantity
	     //format and output PrepCost
	     oPrepCost =nf.format(iPrepCost);
	     System.out.println("Prep Cost..... " + iPrepCost);
	     //display PrepCost
	     //format and output tax
	     oTax =nf.format(cTax);
	     System.out.println("Tax....." +  cTax);	
	     //display Tax
		 //format and output TaleSale
		 oTotalSlae =nf.format(cTotalSale);
	     System.out.println("TotalSale..... " + Math.round(cTotalSale*100)/100.0);
	     //display TotalSale
		 //format and output SubtotalSale
		 oSubtotal=nf.format(cSubtotal);
	     System.out.println("Subtotal....." +  cSubtotal);
	     //format and output MarkupAmount
	     oMarkupAmount=nf.format(cMarkupAmount);
	    System.out.println("Markup Amount..... " + cMarkupAmount);
	
        }
				
			
			
					
					
	  public static void closing() {
		  // TODO Auto-generated method stub
		  System.out.println(" Number of sales....." +  cGrandTotalNumOfSales);	
		  System.out.println("Total Sales..... " + Math.round(cGrandTotalSales*100)/100.0);
          }
}
