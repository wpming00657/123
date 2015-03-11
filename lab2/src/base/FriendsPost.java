package base;

import java.util.Date;

public class FriendsPost extends Post{

	private User friend;
	
	public FriendsPost(Date d, String c,User friend) {
		super(d, c);
		this.friend=friend;
		// TODO Auto-generated constructor stub
	}
	
	public String toString(){
		return "User [userId="+friend.get_id() +", userName=" +friend.get_name()
				+", userEmail=" +friend.get_email() + "]\n"
				+super.toString();
	}

	
}
