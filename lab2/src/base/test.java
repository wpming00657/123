package base;

import java.util.Date;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user =new User(1,"COMP3021","COMP3021@cse.ust.hk");
		Date date =new Date();
		String content = "This is my first post";
		FriendsPost postFromFriend = new FriendsPost(date,content,user);
		System.out.println(postFromFriend);
		System.out.println(postFromFriend.contains("firsT"));
		System.out.println(postFromFriend.contains("HKUST"));
				

	}

}
