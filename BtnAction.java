import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class BtnAction implements ActionListener {
	
	public JTextField txtFld;
	private boolean start;
	private boolean point;
	private String cmd;
	private double result;
	
	private void onStart() {
		
		start=true;
		point=true;
		cmd="C";
		result=0;
		txtFld.setText("0.0");
		
	}
	
	private void calc() {
		
		double x;
		x=Double.parseDouble(txtFld.getText());
		if(cmd.equals("*")) result*=x;
		else if(cmd.equals("/")) result/=x;
		else if(cmd.equals("-")) result-=x;
		else if(cmd.equals("+")) result+=x;
		else result=x;
		txtFld.setText(Double.toString(result));
	}

	public BtnAction(JTextField txtFld) {
		this.txtFld=txtFld;
		onStart();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String str=ae.getActionCommand();
		if(str.equals("C")) {
			onStart();
			return;
		}
		
		if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/") || str.equals("=")) {
			calc();
			cmd=str;
			start=true;
			point=true;
			return;
		}
		
		if(start) {
			if(str.equals(".")) {
				txtFld.setText("0.");
				point=false;
				start=false;
				return;
			}
			else {
				txtFld.setText(str);
				start=false;
				return;
			}
		}
		else {
			if(str.equals(".")) {
				str=point?str:"";
				point=false;
			}
			if(txtFld.getText().equals("0")&!str.equals(".")) {
				txtFld.setText(str);
			}
			else {
				txtFld.setText(txtFld.getText()+str);
			}
		}

	}

}
