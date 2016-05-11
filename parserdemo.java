


import java.util.Scanner.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import java.text.*;

class parserdemo extends JFrame implements ActionListener {



	public ImageIcon icon;
	public static JLabel videoField;
	public static JTextField parser;
	public static JTextArea output;
	public static JTextField prompt;

	//I tried creating an instance of Main here so that I could call the processword command from the actionlistener. This created a huge error when trying to run, it compiled fine however.
	
	
	
	public parserdemo() {
		
	

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
        
       new parserdemo();

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




