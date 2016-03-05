import java.util.ArrayList;

import javax.swing.JOptionPane;


public class toArabic {
	private int i;
	private int toArabic;
	private char romanNumeral;
	private int numConverted;
	private final String nums;
	private String sendBackNum;
	
	public toArabic(String ofRomanLetters){
		nums = ofRomanLetters;
		i = 0;
		toArabic = 0;
	}
	public String romanInput(){
		while(i < nums.length()){
			romanNumeral=nums.charAt(i);
			numConverted = toArabicConversion(romanNumeral);
			i++;
			if(i == nums.length()){
				toArabic = toArabic + numConverted;
			}else{
				int nextNumConverted = toArabicConversion(nums.charAt(i));
				if(nextNumConverted > numConverted){
					toArabic = toArabic + (nextNumConverted-numConverted);
					i++;
				}else{
					toArabic = toArabic + numConverted;
				}
			}
		}//end of While-Loop
		if(toArabic >3999){
			JOptionPane.showMessageDialog(null, "Roman numeral must be in the range of [1 - 3999]");
		}
		sendBackNum = String.valueOf(toArabic);
		return sendBackNum;
	}//end of method;
	
	
	public int toArabicConversion(char alphaBet ){
			int num = 0;
			switch(alphaBet){
			case 'M':
				num = 1000;
				break;
			case 'D':
				num = 500;
				break;
			case 'C':
				num = 100;
				break;
			case 'L':
				num = 50;
				break;
			case 'X':
				num = 10;
				break;
			case 'V':
				num = 5;
				break;
			case 'I':
				num = 1;
				break;
			default:
				if(nums != "M"|| nums !="D"|| nums != "C" ||nums != "L"|| nums != "X" || nums != "V" || nums != "I"){
					JOptionPane.showMessageDialog(null,"Invalid input! Click OK to exit.");
				System.exit(-1);
				break;
			}
	}
			return num;
	}
}