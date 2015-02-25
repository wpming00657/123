package base;
import java.util.Date;


public class Post {
	
	private Date date;
	private String content;
	
	public Post(Date d ,String c){
		date=d;
		content=c;
	}
	
	public String getContent(){
		return content;
	}
	
	public void setContent(String c){
		content=c;
	}
	public Date getDate(){
		return date;
	}
	
	public void setDate(Date d){
		date=d;
	}
	
	public String toString(){
		return content;
	}
	
	public boolean equals(Object o){
		boolean ans =true;
		if(o.getClass()!=this.getClass())ans= false;
		else{
			Post post =(Post)o;
			if(this.getContent()==post.getContent() && this.getDate()==post.getDate())ans=false;
		}
		
		return ans;
	}
	
	public int hashCode(){
		
	}
	
	public boolean contains(String keyword){
		
	}

}
