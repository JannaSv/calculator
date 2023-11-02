import java.awt.*;




import javax.swing.JFrame;

public class CalculatorFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CalculatorFrame() throws HeadlessException {
		int w = 270;
		int h = 240;
		setTitle("Calculator");
		setBounds(150,150,w+15,h+15);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		CalcPanel panel = new CalcPanel(w,h);
		add(panel);
		setResizable(false);
		setVisible(true);
		
	}

	

}
