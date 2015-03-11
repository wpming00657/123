package base;


import java.io.*;
import java.util.Date;



public class TestBlog {

	public String getInput(){
		String line = "";
		System.out.print("Enter the prompt:");
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			line=br.readLine();
		}catch(IOException e){
			e.printStackTrace();
		}
		return line;
	}
	
	public static void main(String[] args){
	
		TestBlog testb = new TestBlog();
		User user =new User(1,"COMP3021","COMP3021@cse.ust.hk");
		Blog myblog = new Blog(user);
		String prompt=null;
		
		while(!(prompt=testb.getInput()).equals("exit")){
			if(prompt.startsWith("list")){
				myblog.list();
			}
			else if(prompt.startsWith("post")){
				Date date =new Date();
				String input=testb.getInput();
				String content = input.substring(1, input.length());
				Post post = new Post(date,content);
				myblog.post(post);
				System.out.println("A new Post");
			}
			else if (prompt.startsWith("delete")){
				String input=testb.getInput();
				String content = input.substring(1, input.length());
				myblog.delete(Integer.parseInt(content));
			}
					
		}
	
	
	
	}
}