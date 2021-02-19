import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUI {
	
//	private String userinput = "";
	JTextField output = new JTextField(16);
	
	String i0 = "";
	String i1 = "";
	String i2 = "";
	
	private JFrame frame = new JFrame();
	private JPanel panel = new JPanel();
	
	private JButton close = new JButton("Close");
	private JButton C = new JButton("C");
	private JButton AC = new JButton("AC");
	private JButton seven = new JButton("7");
	private JButton eight = new JButton("8");
	private JButton nine = new JButton("9");
	private JButton divide = new JButton("/");
	private JButton four = new JButton("4");
	private JButton five = new JButton("5");
	private JButton six = new JButton("6");
	private JButton multiply = new JButton("*");
	private JButton one = new JButton("1");
	private JButton two = new JButton("2");
	private JButton three = new JButton("3");
	private JButton subs = new JButton("-");
	private JButton zero = new JButton("0");
	private JButton dot = new JButton(".");
	private JButton perc = new JButton("%");
	private JButton plus = new JButton("+");
	private JButton equal = new JButton("=");
	
	private GUI() {
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Calculator");
		frame.pack();
		frame.setResizable(false);
		frame.setSize(300, 300);
		frame.setVisible(true);
		output.setEditable(false);
		panel.add(output);
		this.addButton();
		this.addAction();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GUI();
	}
	private void addButton() {
		panel.add(close);
		panel.add(C);
		panel.add(AC);
		panel.add(dot);
		panel.add(seven);
		panel.add(eight);
		panel.add(nine);
		panel.add(four);
		panel.add(five);
		panel.add(six);
		panel.add(one);
		panel.add(two);
		panel.add(three);
		panel.add(subs);
		panel.add(zero);
		panel.add(plus);
		panel.add(divide);
		panel.add(multiply);
		panel.add(perc);
		panel.add(equal);
	}
	private void addAction() {
		close.addActionListener(new closeAction());
		C.addActionListener(new numbAction());
		AC.addActionListener(new numbAction());
		plus.addActionListener(new numbAction());
		seven.addActionListener(new numbAction());
		eight.addActionListener(new numbAction());
		nine.addActionListener(new numbAction());
		divide.addActionListener(new numbAction());
		four.addActionListener(new numbAction());
		five.addActionListener(new numbAction());
		six.addActionListener(new numbAction());
		multiply.addActionListener(new numbAction());
		one.addActionListener(new numbAction());
		two.addActionListener(new numbAction());
		three.addActionListener(new numbAction());
		subs.addActionListener(new numbAction());
		zero.addActionListener(new numbAction());
		dot.addActionListener(new numbAction());
		perc.addActionListener(new numbAction());
		equal.addActionListener(new numbAction());
	}
	
	private class numbAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String s = e.getActionCommand();
			
			if ((Character.getNumericValue(s.charAt(0)) >= 0 && (Character.getNumericValue(s.charAt(0)) <= 9)) || s.charAt(0) == '.') {
				if (!i1.equals("")) {
					i2 = i2 + s;
				} else {
					i0 = i0 +s;
				}
				output.setText(i0+i1+i2);
			} else if (s.charAt(0) == 'C') {
				if (!i2.equals("")) {
					i2 = "";
				} else if (!i1.equals("")) {
					i1 = "";
				} else if (!i0.equals("")) {
					i0 = "";
				}
				output.setText(i0+i1+i2);
			} else if (s.equals("AC")) {
				i0 = i1 = i2 = "";
				output.setText(i0+i1+i2);
			} else if (s.charAt(0) == '=') {
				double result = 0.0;
				if (i1.equals("+")) {
					result = Double.parseDouble(i0) + Double.parseDouble(i2);
				} else if (i1.equals("-")) {
					result = Double.parseDouble(i0) - Double.parseDouble(i2);
				} else if (i1.equals("*")) {
					result = Double.parseDouble(i0) * Double.parseDouble(i2);
				} else if (i1.equals("/")) {
					result = Double.parseDouble(i0) / Double.parseDouble(i2);
				}
				output.setText(i0+i1+i2+"="+result);
				i0 = Double.toString(result);
				i1=i2="";
			} else {
				if (i1.equals("") || i2.equals("")) {
					i1 = s;
				} else {
					double result = 0.0;
					if (i1.equals("+")) {
						result = Double.parseDouble(i0) + Double.parseDouble(i2);
					} else if (i1.equals("-")) {
						result = Double.parseDouble(i0) - Double.parseDouble(i2);
					} else if (i1.equals("*")) {
						result = Double.parseDouble(i0) * Double.parseDouble(i2);
					} else if (i1.equals("/")) {
						result = Double.parseDouble(i0) / Double.parseDouble(i2);
					}
					i0 = Double.toString(result);
					i1=s;
					i2="";
					output.setText(i0+i1+i2);
				}
			}
		}
	}
	private class closeAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	
}
