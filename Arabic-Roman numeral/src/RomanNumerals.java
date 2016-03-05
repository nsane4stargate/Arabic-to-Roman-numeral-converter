import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;


public class RomanNumerals extends JFrame {
	private JTextArea type;
	private JTextArea display;
	private JTextField input_box;
	private JTextField output_box;
	private JLabel arabic;
	private JLabel roman;
	private String num;
	

	
	public RomanNumerals(){
		super("Arabic <--> Roman Numeral");
		input_box = new JTextField(10);
		output_box = new JTextField(10);
		setLayout(new FlowLayout());
		TextFieldHandler1 handler = new TextFieldHandler1();
		input_box.addKeyListener(handler);
		output_box.addKeyListener(handler);
		arabic = new JLabel("Arabic Numeral    ");
		roman = new JLabel("Roman Numeral   ");
		add(arabic);
		add(input_box);
		add(roman);
		add(output_box);
	}// end of Constructor
	
	/*
	private class TextFieldHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent convert){
			num = "";
			if(convert.getSource()== input_box){
				num = convert.getActionCommand();
				Conversion result = new Conversion(num);
				display.setText(result.converter());
			}
		}//end method actionPerformed
	}// end of class TextField Handler
	*/
	private class TextFieldHandler1 implements KeyListener{
		
		public void keyPressed(KeyEvent key){
			
		}
		public void keyReleased(KeyEvent key){
			boolean continueLoop = true;
			StringBuilder buffer = new StringBuilder();
			if(key.getSource()== input_box){
				if(num == null){
					if(Integer.parseInt(KeyEvent.getKeyText(key.getKeyCode()))>=0 && Integer.parseInt(KeyEvent.getKeyText(key.getKeyCode()))<=9){ 
						num = KeyEvent.getKeyText(key.getKeyCode());
					}
				}else{
						num = num + KeyEvent.getKeyText(key.getKeyCode());
				}
				Conversion result = new Conversion(num);
				output_box.setText(result.converter());
						
			}else if(key.getSource()== output_box){
					if(num == null){
						num = KeyEvent.getKeyText(key.getKeyCode()).toUpperCase();
					}else{
						num = num + KeyEvent.getKeyText(key.getKeyCode());
					}
					System.out.println(num);
					toArabic result = new toArabic(num);
					input_box.setText(result.romanInput());
			}
					//toArabic result = new toArabic(num);
					//input_box.setText(result.converter());
		}
		
					
		public void keyTyped(KeyEvent key){
			/*
			 * Was going to type in a condition statement if BackSpace was typed. I would have
			 * made the number or letter at the position of String num.lenght()-1 = "";
			 */
			
			}
	}
}//end of class Roman Numerals