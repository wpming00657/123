package base;

import java.io.*;
import java.util.ArrayList;

public class Blog implements Serializable{

	private User _user;
	private ArrayList<Post> allPosts;
	
	public Blog(User user){
		_user=user;
		allPosts = new ArrayList<Post>();
	}
	
	public void post(Post p){
		allPosts.add(p);
	}
	
	public void list(){
		int i=0;
		for(Post temp:allPosts){
			System.out.println("Post["+i++ +"]:"+temp.toString());
		}
	}
	public String list1(){
		String out="";
		int i=0;
		for(Post temp:allPosts){
			out+=("Post["+i++ +"]:"+temp.toString()+"\n");
		}
		return out;
		
	}
	
	public void delete(int index){
		try{
			allPosts.remove(index);
		}catch(Exception e){
			System.out.println("index not legal.");
		}
	}
	
	public String toString(){
		return _user.get_name() + "'s Blog";
	}
	public ArrayList<Post> getAllPosts() {
		return allPosts;
	}
	
	public void setAllPosts(ArrayList<Post> allPosts) {
		this.allPosts = allPosts;
	}
	
	public User get_user() {
		return _user;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_user == null) ? 0 : _user.hashCode());
		result = prime * result
				+ ((allPosts == null) ? 0 : allPosts.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Blog other = (Blog) obj;
		if (_user == null) {
			if (other._user != null)
				return false;
		} else if (!_user.equals(other._user))
			return false;
		if (allPosts == null) {
			if (other.allPosts != null)
				return false;
		} else if (!allPosts.equals(other.allPosts))
			return false;
		return true;
	}

	public void set_user(User _user) {
		this._user = _user;
	}

	public void search(int i, String string) {
		// TODO Auto-generated method stub
		
	}
	
	public void save (String filepath) {
		try {
			FileOutputStream output =new FileOutputStream(filepath);
			ObjectOutputStream out=new ObjectOutputStream(output);
			out.writeObject(this);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void load(String filepath) {
		try {
			FileInputStream input = new FileInputStream(filepath);
			ObjectInputStream in =new ObjectInputStream(input);
			Blog blogin=(Blog) in.readObject();
			this._user=blogin.get_user();
			this.allPosts=blogin.getAllPosts();
			in.close();
			
		} catch (FileNotFoundException  e) {
			// TODO Auto-generated catch block
			System.out.println("Wait! There is something wrong.I cannot find the file.");
		} catch (IOException |ClassNotFoundException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
}
