package base;

import java.io.Serializable;

public class User implements Comparable<User>,Serializable{

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_email == null) ? 0 : _email.hashCode());
		result = prime * result + _id;
		result = prime * result + ((_name == null) ? 0 : _name.hashCode());
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
		User other = (User) obj;
		if (_email == null) {
			if (other._email != null)
				return false;
		} else if (!_email.equals(other._email))
			return false;
		if (_id != other._id)
			return false;
		if (_name == null) {
			if (other._name != null)
				return false;
		} else if (!_name.equals(other._name))
			return false;
		return true;
	}

	private int _id;
	private String _name;
	private String _email;
	
	public User(int id,String name,String mail){
		set_id(id);
		_name=name;
		_email=mail;
	}
	
	
	
	public String get_name() {
		return _name;
	}
	
	public void set_name(String _name) {
		this._name = _name;
	}
	
	public String get_email() {
		return _email;
	}
	
	public void set_email(String _email) {
		this._email = _email;
	}

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}



	@Override
	public int compareTo(User u) {
		if(_id<u._id) return -1;
		else if(_id>u._id) return 1;
		else return 0;
	}
	
	
}
