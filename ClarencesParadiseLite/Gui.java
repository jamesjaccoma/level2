import java.util.Scanner.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import java.text.*;

class Gui extends JFrame implements ActionListener, KeyListener {


	public ImageIcon icon;
	public static JLabel videoField;
	public static JTextField parser;
	public static JTextArea output;
    public static JTextArea help;
	//public static JTextField prompt;

	public static final int FRAME_WIDTH = 1280;
    public static final int FRAME_HEIGHT = 800;
   
    public static final int TEXT_FIELD_WIDTH = 100;
    public static final int TEXT_FIELD_HEIGHT = 25;
    
    public static final int TEXT_COLUMNS = 15;
    
    public Gui() {
		
	    Font font1 = new Font("Consolas", Font.BOLD, 16);


        JPanel display = new JPanel();
        display.setLayout(new BorderLayout());
        display.setBackground(Color.BLACK);
        display.setPreferredSize(new Dimension(800, 600)); //dimensions of GIFs plus 20 on each side for the borders
        //display.setMaximumSize(new Dimension(980, 660)); //Setting a maximum is maybe not necessary.
        display.setMinimumSize(new Dimension(800, 600)); //Setting a minimum keeps it from disappearing when resized, also keeps the dims of gifs from affecting the JPanel.
            videoField = new JLabel(icon);
            display.add(videoField, BorderLayout.CENTER);
		
        JPanel controls = new JPanel();
		controls.setLayout(new GridBagLayout());
		controls.setBackground(Color.BLACK);
        GridBagConstraints c1 = new GridBagConstraints();


    		parser = new JTextField();
    	  	parser.setColumns(TEXT_COLUMNS);
            parser.setPreferredSize(new Dimension(400, 25));
            //parser.setMinimumSize()
            parser.setFont(font1);
            parser.setBackground(Color.DARK_GRAY);
            parser.setForeground(Color.WHITE);
    	  	parser.setText("");
    	  	parser.addActionListener(this);
                parser.addKeyListener(this);//keylistener has to be added to every focusable element
            c1.gridx = 0;
            c1.gridy = 1;
            c1.weightx = 0.5;
            c1.weighty = 0.5;
            c1.fill = GridBagConstraints.HORIZONTAL;
            controls.add(parser, c1);
    	  	

    	  	output = new JTextArea();
    	  	output.setPreferredSize(new Dimension(TEXT_FIELD_WIDTH, TEXT_FIELD_HEIGHT));
            output.setBackground(Color.BLACK);
            output.setForeground(Color.WHITE);
            output.setFont(font1);
    	  	output.setEditable(false);
                output.addKeyListener(this);//keylistener has to be added to every focusable element
            c1.fill = GridBagConstraints.HORIZONTAL;
            c1.anchor = GridBagConstraints.LINE_START;
            c1.gridx = 0;
            c1.gridy = 0;
            c1.weightx = 1;
            c1.weighty = 0.5;
            controls.add(output, c1);

            help = new JTextArea();
            help.setText("?");
            help.setPreferredSize(new Dimension(20, 25));
            help.setFont(font1);
            help.setBackground(Color.BLACK);
            help.setForeground(Color.WHITE);
            help.setEditable(false);
                help.addKeyListener(this);//keylistener has to be added to every focusable element
            c1.gridx = 1;
            c1.gridy = 0;
            c1.anchor = GridBagConstraints.LINE_END;
            c1.weightx = 0.05;
            c1.weighty = 0.5;
            controls.add(help, c1);

	  	JPanel mainPanel = new JPanel();
      

      /*  
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        display.setAlignmentX(Component.CENTER_ALIGNMENT);
        controls.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(display);
        mainPanel.add(controls);
      */  


    /*    
        mainPanel.add(controls, BorderLayout.SOUTH);
        mainPanel.add(display, BorderLayout.NORTH);
    */
     
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBackground(Color.BLACK);
        GridBagConstraints c2 = new GridBagConstraints();


        c2.gridx = 0;
        c2.gridy = 0;
        
       
        
       
        //c2.insets = new Insets(20, 20, 0, 20);
        mainPanel.add(display, c2);

        c2.gridx = 0;
        c2.gridy = 1;
        
      
        c2.fill = GridBagConstraints.HORIZONTAL;
        c2.insets = new Insets(0, 55, 100, 20);
        mainPanel.add(controls, c2);
	  	

	  	
	  	
	  	
	  	


	  	JFrame frame = new JFrame("Clarence's Paradise");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setLayout(new BorderLayout());
        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
        frame.getContentPane().setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        //frame.setResizable(false);
	  	frame.pack();
        frame.setVisible(true);

       

	}





	 public void actionPerformed(ActionEvent evt) {
	 	
	 	Main.processInput(parser);

	}

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_F1) //Why was VK_ESCAPE working a second ago and not now? I changed it to VK_SPACE to test, and that works. It's suggested to use KeyBindings instead.
      {
         
         Main.processEscKey();
         
      }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}


	
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