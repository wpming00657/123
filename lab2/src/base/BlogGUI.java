package base;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class BlogGUI implements ActionListener{

	private JFrame mainFrame;
	private JTextArea postText;
	private JTextField postContent;
	private JButton refresh;
	private JButton post;
	
	public BlogGUI(){
		
	}
	
	public void setWindow(){
		mainFrame = new JFrame("GUI");
		mainFrame.setLayout(new GridLayout(2,1));
		
		postText = new JTextArea(10,300);
		postText.setBackground(Color.cyan);
		postContent=new JTextField("Here is the Post!");
		refresh = new JButton("Refresh");
		post = new JButton("Post");
		
		JPanel top = new JPanel(new BorderLayout());
		top.add(postText,BorderLayout.NORTH);
		
		JPanel button = new JPanel();
		button.add(refresh);
		button.add(post);
		top.add(button,BorderLayout.SOUTH);
		
		
		mainFrame.add(top);
		mainFrame.add(postContent);
		mainFrame.setSize(350, 430);
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		post.addActionListener(this);
		refresh.addActionListener(this);
	}
	
	public static void main(String[] args){
		BlogGUI blogGUI = new BlogGUI();
		blogGUI.setWindow();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==post){
			postContent.setText("u click POST.");
		}else if (e.getSource()==refresh){
			postContent.setText("u click REFRESH.");
		}
		
	}
}
