


import java.util.Scanner.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import java.text.*;

class Gui extends JFrame implements ActionListener {



	public ImageIcon icon;
	public static JLabel videoField;
	public static JTextField parser;
	public static JTextArea output;
	public static JTextField prompt;

	//I tried creating an instance of Main here so that I could call the processword command from the actionlistener. This created a huge error when trying to run, it compiled fine however.
	
	
	
	public Gui() {
		
	

		JPanel controls = new JPanel();
		controls.setLayout(new BorderLayout());
		controls.setBackground(Color.BLACK);




		parser = new JTextField();
	  	parser.setColumns(10);
	  	parser.setText(">");
	  	parser.addActionListener(this);
	  	

	  	output = new JTextArea();
	  	output.setPreferredSize(new Dimension(100, 20));
	  	output.setEditable(false);

	  	
	  	videoField = new JLabel(icon);

	  	
	  	controls.add(videoField, BorderLayout.CENTER);
	  	controls.add(output, BorderLayout.SOUTH);
	  	controls.add(parser, BorderLayout.NORTH);


	  	JFrame frame = new JFrame("parserdemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().add(controls, BorderLayout.CENTER);
        frame.getContentPane().setPreferredSize(new Dimension(1000, 700));
	  	frame.pack();
        frame.setVisible(true);


	}





	 public void actionPerformed(ActionEvent evt) {
	 	
	 	Main.processInput(parser);
	 	
	 //	if (!parser.hasFocus()){
	 //		parser.requestFocus();
	 //	}
	 	


	}


	 private static void createAndShowGUI() {
        
       new Gui();

    }

        public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
            UIManager.put("swing.boldMetal", Boolean.FALSE);
                createAndShowGUI();
            }
        });
    }



    	class NavigationFilterPrefixWithBackspace extends NavigationFilter
{
    private int prefixLength;
    private Action deletePrevious;

    public NavigationFilterPrefixWithBackspace(int prefixLength, JTextComponent component)
    {
        this.prefixLength = prefixLength;
        deletePrevious = component.getActionMap().get("delete-previous");
        component.getActionMap().put("delete-previous", new BackspaceAction());
        component.setCaretPosition(prefixLength);
    }

 @Override
    public void setDot(NavigationFilter.FilterBypass fb, int dot, Position.Bias bias)
    {
        fb.setDot(Math.max(dot, prefixLength), bias);
    }

    @Override
    public void moveDot(NavigationFilter.FilterBypass fb, int dot, Position.Bias bias)
    {
        fb.moveDot(Math.max(dot, prefixLength), bias);
    }

    class BackspaceAction extends AbstractAction
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            JTextComponent component = (JTextComponent)e.getSource();

            if (component.getCaretPosition() > prefixLength)
            {
                deletePrevious.actionPerformed( null );
            }
        }
    }
    }
}




