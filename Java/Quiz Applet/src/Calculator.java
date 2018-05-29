package project04;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Calculator extends JFrame implements ActionListener
{
	JButton button1 = new JButton("1");
	JButton button2 = new JButton("2");
	JButton button3 = new JButton("3");
	JButton button4 = new JButton("4");
	JButton button5 = new JButton("5");
	JButton button6 = new JButton("6");
	JButton button7 = new JButton("7");
	JButton button8 = new JButton("8");
	JButton button9 = new JButton("9");
	JButton button0 = new JButton("0");
	JButton buttonPlus = new JButton("+");
	JButton buttonMinus = new JButton("-");
	JButton buttonDivide = new JButton("/");
	JButton buttonMultiply = new JButton("*");
	JButton buttonLeftP = new JButton("(");
	JButton buttonRightP = new JButton(")");
	JButton buttonUpCarrot = new JButton("^");
	JButton buttonMod = new JButton("%");
	JButton buttonSqrt = new JButton("Sqrt");
	JButton buttonEnter = new JButton("Enter");
	JButton buttonClear = new JButton("Clear");
	JButton buttonPeriod = new JButton(".");
	JPanel buttons = new JPanel();
	JTextArea textArea = new JTextArea();
	Queue<Character> qChar = new LinkedList<>();
	
	String foo = "";
	
	Eval eval = new Eval();
	
	Calculator()
	{
		textArea.setFont(textArea.getFont().deriveFont(25f));
        setFocusable(true);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);
		button7.addActionListener(this);
		button8.addActionListener(this);
		button9.addActionListener(this);
		button0.addActionListener(this);
		buttonPlus.addActionListener(this);
		buttonMinus.addActionListener(this);
		buttonDivide.addActionListener(this);
		buttonLeftP.addActionListener(this);
		buttonRightP.addActionListener(this);
		buttonMultiply.addActionListener(this);
		buttonUpCarrot.addActionListener(this);
		buttonMod.addActionListener(this);
		buttonEnter.addActionListener(this);
		buttonSqrt.addActionListener(this);
		buttonClear.addActionListener(this);
		buttonPeriod.addActionListener(this);
		
		
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		
		buttons.setLayout(new GridLayout(5,4));
		buttons.add(button1);
		buttons.add(button2);
		buttons.add(button3);
		buttons.add(button4);
		buttons.add(button5);
		buttons.add(button6);
		buttons.add(button7);
		buttons.add(button8);
		buttons.add(button9);
		buttons.add(button0);
		buttons.add(buttonPlus);
		buttons.add(buttonMinus);
		buttons.add(buttonDivide);
		buttons.add(buttonMultiply);
		buttons.add(buttonLeftP);
		buttons.add(buttonRightP);
		buttons.add(buttonUpCarrot);
		buttons.add(buttonMod);
		buttons.add(buttonPeriod);
		buttons.add(buttonSqrt);
		buttons.add(buttonEnter);
		buttons.add(buttonClear);
		setLayout(new GridLayout(2,1));
		add(textArea);
		add(buttons);
		pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	public void configure()
	{
    	while(!qChar.isEmpty())
    	{
    		foo = foo + qChar.remove();
    	}

	}
	public void actionPerformed(ActionEvent e) 
	{
        if(e.getSource() == button1)
        	qChar.add('1');
        else if(e.getSource() == button2)
        	qChar.add('2');
        else if(e.getSource() == button3)
        	qChar.add('3');
        else if(e.getSource() == button4)
        	qChar.add('4');
        else if(e.getSource() == button5)
        	qChar.add('5');
        else if(e.getSource() == button6)
        	qChar.add('6');
        else if(e.getSource() == button7)
        	qChar.add('7');
        else if(e.getSource() == button8)
        	qChar.add('8');
        else if(e.getSource() == button9)
        	qChar.add('9');
        else if(e.getSource() == button0)
        	qChar.add('0');
        else if(e.getSource() == buttonLeftP)
        	qChar.add('(');
        else if(e.getSource() == buttonRightP)
        	qChar.add(')');
        else if(e.getSource() == buttonPlus)
        	qChar.add('+');
        else if(e.getSource() == buttonMinus)
        	qChar.add('-');
        else if(e.getSource() == buttonDivide)
        	qChar.add('/');
        else if(e.getSource() == buttonMultiply)
        	qChar.add('*');
        else if(e.getSource() == buttonUpCarrot)
        	qChar.add('^');
        else if(e.getSource() == buttonMod)
        	qChar.add('%');
        else if(e.getSource() == buttonSqrt)
        	qChar.add('s');
        else if(e.getSource() == buttonPeriod)
        	qChar.add('.');
        else if(e.getSource() == buttonClear)
        	foo="";
        configure();
        if(e.getSource() == buttonEnter)
        {
            textArea.setText(foo + "\n = " + eval.Eval(foo));
        	foo="";
        }
        else
        	textArea.setText(foo);
	}
}
