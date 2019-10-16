package com.sams.fileio;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class GUI{
	private Map<String, String> choiceMap = new HashMap<>();
	public static String username;
	public static String password;
	public static String environment;
	
    public void createGUI(){
        JFrame frame = new JFrame("CVS Account Creation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel username = new JLabel("Username:");
        JLabel password = new JLabel("Password:");
        JTextField usernameBox = new JTextField();
        JTextField passwordBox = new JTextField();
        JButton login = new JButton("Login");
        panel.add(username);
        panel.add(usernameBox);
        panel.add(password);
        panel.add(passwordBox);
        panel.add(login);

        frame.getContentPane().add(BorderLayout.NORTH, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, login);
        frame.setVisible(true);
        
        login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String username = usernameBox.getText();
				String password = passwordBox.getText();

				if(username.isEmpty())
					JOptionPane.showMessageDialog(frame, "Username cannot be blank!");
				else if(password.isEmpty())
					JOptionPane.showMessageDialog(frame, "Password cannot be blank!");
				else {
					GUI.username = username;
					GUI.password = password;
					chooseEnvironment();
				}
			}
        	
        });
    }
    
    private void chooseEnvironment() {
    	JFrame frame = new JFrame("Select an Environment");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);

        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        List<String> environmentList = Arrays.asList("PROD", "DEV", "STAGE");
        
        for(String environment : environmentList) {
        	JButton button = new JButton(environment);
        	panel.add(button);
        	
        	button.addActionListener(new ActionListener() {

    			@Override
    			public void actionPerformed(ActionEvent e) {
    				choiceMap.put("Choice",environment);
    				GUI.environment = environment;
    				frame.setTitle("Selected environment: " + environment);
    			}
            	
            });
        }
        
        JButton create = new JButton("Create");
        
        create.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(choiceMap.get("Choice") == null)
					JOptionPane.showMessageDialog(frame,"Select an environment!");
				else {
					//Call creation logic
				}
			}
        	
        });
        
        frame.getContentPane().add(BorderLayout.NORTH, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, create);
        frame.setVisible(true);
    }
}
