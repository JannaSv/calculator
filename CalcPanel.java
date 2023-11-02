import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalcPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTextField txtFld;
	private BtnAction btnPressed;

	public CalcPanel(int W, int H) {
		int w = W/5;
		int h = H/8;
		int sx = w/5;
		int sy = h/3;
		setLayout(null);
		setBorder(BorderFactory.createEtchedBorder());
		JTextField txtFld = new JTextField();
		txtFld.setHorizontalAlignment(JTextField.RIGHT);
		txtFld.setBounds(sx, sy, 2*sx+3*w, h);
		txtFld.setEditable(false);
		add(txtFld);
		btnPressed = new BtnAction(txtFld);
		String [] btnTxt = {
			"1", "2", "3", "+", "4", "5", "6", "-", "7", "8", "9", "/", "0", ".", "=", "*" 
		};
		
		for (int i=0; i<btnTxt.length; i++) {
			
			addBtn(sx+(w+sx)*(i%4),(2*sy+h)+(sy+h)*(i/4),w,h,btnTxt[i], btnPressed);
			
		}
	
		JButton btnC = new JButton("C");
		btnC.setBounds(4*sx+3*w, sy, w, h);
		btnC.addActionListener(btnPressed);
		btnC.setFocusPainted(false);
		btnC.setForeground(Color.RED);
		add(btnC);
}
	
	void addBtn(int i, int j, int w, int h, String txt, ActionListener acList) {
		
		JButton b = new JButton(txt);
		b.setBounds(i, j, w, h);
		b.setFocusPainted(false);
		b.addActionListener(acList);
		add(b);
		
	}
	
	

	

}
