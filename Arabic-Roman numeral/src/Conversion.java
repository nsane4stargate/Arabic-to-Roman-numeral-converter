import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Conversion{
	
	private int thousands;
	private int hundreds;
	private int tenths;
	private int ones;
	private String nums;
	
	public Conversion(String numsber){
		 nums = numsber;
		 thousands = 0;
		 hundreds = 0;
		 tenths = 0;
		 ones = 0;
		
	}
	
	public String converter(){
		String thousandths_place[]= new String[0]; 
		String hundredths_place[] = new String[1];
		String tenths_place[] = new String[1];
		String ones_place[] = new String[1];
		/*
		 * Making conditions on how long each array will be given the length of the 
		 * number which the user typed in after pressing enter
		 */
		if(nums.length()== 4){
			thousandths_place= new String[nums.charAt(0)-(int)'0'];
			thousands = nums.charAt(0)-(int)'0';
			hundreds = nums.charAt(1)-(int)'0';
			tenths = nums.charAt(2)-(int)'0';
			ones = nums.charAt(3)-(int)'0';
		}else if(nums.length() == 3){
			hundreds = nums.charAt(0)-(int)'0';
			tenths = nums.charAt(1)-(int)'0';
			ones = nums.charAt(2)-(int)'0';
		}else if(nums.length() == 2){
			tenths = nums.charAt(0)-(int)'0';
			ones = nums.charAt(1)-(int)'0';
		}else if(nums.length() == 1){
			ones = nums.charAt(0)-(int)'0';
		}
		
		//Placing values in arrays named thousand, hundreds, tens, and ones
		if(thousands > 0 && thousands <=3){
			for(int i = 0; i < thousands; i++){
			thousandths_place[i] = "M";
			}
		}else if(thousands == 4){
				JOptionPane.showMessageDialog(null, "Roman numeral must be in the range of [1 - 3999]");
			
		}//Thousandths_place
			
		if(hundreds == 0){
				hundredths_place[0]= "";
		}else if(hundreds >=1 && hundreds <=5){
				if(hundreds == 1){
					hundredths_place[0]= "C";
				}else if(hundreds == 2){
					hundredths_place[0]= "CC";
				}else if(hundreds == 3){
					hundredths_place[0]= "CCC";	
				}else if(hundreds == 4){
					hundredths_place[0]= "CD";
				}else if(hundreds == 5){
					hundredths_place[0]= "D";
				}
		}else if(hundreds >=6 && hundreds <=9){
				if(hundreds == 6){
					hundredths_place[0]= "DI";
				}else if(hundreds == 7){
					hundredths_place[0]= "DII";
				}else if(hundreds == 8){
					hundredths_place[0]= "CCM";	
				}else if(hundreds == 9){
					hundredths_place[0]= "CM";
				}
		}//Hundredths_place
			
		if(tenths == 0){
				tenths_place[0]= "";
		}else if(tenths >=1 && tenths<=5){
				if(tenths == 1){
					tenths_place[0]= "X";
				}else if(tenths == 2){
					tenths_place[0]= "XX";
				}else if(tenths == 3){
					tenths_place[0]= "XXX";	
				}else if(tenths == 4){
					tenths_place[0]= "XL";
				}else if(tenths == 5){
					tenths_place[0]= "L";
				}
		}else if(tenths >=6 && tenths<=9){
				if(tenths == 6){
					tenths_place[0]= "LI";
				}else if(tenths == 7){
					tenths_place[0]= "LII";
				}else if(tenths == 8){
					tenths_place[0]= "XXC";	
				}else if(tenths == 9){
					tenths_place[0]= "XC";
				}
		}//Tenths_place
			
		if(ones == 0){
				ones_place[0]= "";
		}else if(ones >=1 && ones <=5){
				if(ones == 1){
					ones_place[0]= "I";
				}else if(ones == 2){
					ones_place[0]= "II";
				}else if(ones == 3){
					ones_place[0]= "III";	
				}else if(ones == 4){
					ones_place[0] = "IV";
				}else if(ones == 5){
					ones_place[0]= "V";
				}
		}else if(ones >=6 && ones <=9){
				if(ones == 6){
					ones_place[0]= "VI";
				}else if(ones  == 7){
					ones_place[0]= "VII";
				}else if(ones  == 8){
					ones_place[0]= "IIX";	
				}else if(ones  == 9){
					ones_place[0]= "IX";
				}
		}//Ones_place 
		
		/*
		 * Initializing a String variable to the output from the method that will concatanate
		 * all of the arrays
		 */
		String result = combine(thousandths_place,hundredths_place,tenths_place,ones_place);
		return result;
		
	}//end of method Converter
	
	public String combine(String[] a,String [] b, String []c, String[] d){

		int length = a.length + b.length + c.length + d.length;
		ArrayList<String[]>numsbers = new ArrayList<String[]>();
		numsbers.add(a);
		numsbers.add(b);
		numsbers.add(c);
		numsbers.add(d);
		/*
		 * Initializing String variable
		 */
		String together = "";
		for(int i = 0; i < numsbers.size(); i++){
			 String value1[] = new String[length];
			 value1 = numsbers.get(i);
			 for(int j = 0; j < value1.length; j ++){
				 value1[j]= numsbers.get(i)[j];
				 together = together + value1[j];
			 	}
			}
		return together;
		
	}// end of method combine
	
}//end of class Conversion