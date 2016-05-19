


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
	public static JTextField prompt; //THIS CAN BE NON STATIC
	
	// extrapolating hard coded integers into these variables (constants)
	public static final int FRAME_WIDTH = 1000;
	public static final int FRAME_HEIGHT = 700;
	
	public static final int TEXT_FIELD_WIDTH = 100;
	public static final int TEXT_FIELD_HEIGHT = 20;
	
	public static final int TEXT_COLUMNS = 10;

	//I tried creating an instance of Main here so that I could call the processword command from the actionlistener. This created a huge error when trying to run, it compiled fine however.
	
	
	
	public Gui() {
		
	

		JPanel controls = new JPanel();
		controls.setLayout(new BorderLayout());
		controls.setBackground(Color.BLACK);




		parser = new JTextField();
	  	parser.setColumns(TEXT_COLUMNS);
	  	parser.setText(">");
	  	parser.addActionListener(this);
	  	

	  	output = new JTextArea();
	  	output.setPreferredSize(new Dimension(TEXT_FIELD_WIDTH, TEXT_FIELD_HEIGHT));
	  	output.setEditable(false);

	  	
	  	videoField = new JLabel(icon);

	  	
	  	controls.add(videoField, BorderLayout.CENTER);
	  	controls.add(output, BorderLayout.SOUTH);
	  	controls.add(parser, BorderLayout.NORTH);


	  	JFrame frame = new JFrame("parserdemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().add(controls, BorderLayout.CENTER);
        frame.getContentPane().setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
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
}




