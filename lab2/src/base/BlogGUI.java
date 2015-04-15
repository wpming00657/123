package base;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;

import javax.swing.*;

public class BlogGUI implements ActionListener{


	User a=new User(1,"a","bc");
	private JFrame mainFrame;
	private JTextArea postText;
	private JTextArea postContent;
	private JButton refresh;
	private JButton post;
	private JLabel display;
	private Blog myBlog=new Blog(a);
	public BlogGUI(){
		myBlog.load("E:/a.blog");
		
	}
	
	public void setWindow(){
		mainFrame = new JFrame("GUI");
		mainFrame.setLayout(new GridLayout(2,1));
		
		postText = new JTextArea(10,300);
		postText.setBackground(Color.lightGray);
		display = new JLabel("You can still input 140 characters");
		postContent=new JTextArea("Here is the Post!");
		JScrollPane ps=new JScrollPane(postContent);
		refresh = new JButton("Refresh");
		post = new JButton("Post");
		
		JPanel top = new JPanel(new BorderLayout());
		top.add(display,BorderLayout.NORTH);
		top.add(postText,BorderLayout.CENTER);
		
		JPanel button = new JPanel();
		button.add(refresh);
		button.add(post);
		top.add(button,BorderLayout.SOUTH);
		
		
		mainFrame.add(top);
		mainFrame.add(ps);
		mainFrame.setSize(350, 430);
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		post.addActionListener(new postListener());
		refresh.addActionListener(new refreshListener());
		postText.addKeyListener(new lengthListener());
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
	class postListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String content = postText.getText();
			Date date = new Date();
			Post post =new Post(date,content);
			myBlog.post(post);
			myBlog.save("E:/a.blog");
			
		}
		
	}
	
	class refreshListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			myBlog.load("E:/a.blog");
			postContent.setText(myBlog.list1());
			
		}
		
	}
	
	class lengthListener implements KeyListener{

		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			int length = postText.getText().length();
			if(length >140){
				display.setText("Your post length has exceeded 140!");
			}else {
				display.setText("You can still input"+ (140-length)+"characters");
			}
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
