package user;

import java.util.*;
import objects.*;

public interface UserFunction {
	
	public boolean addUser(UserObject item);
	public boolean editUser(UserObject item);
	public boolean delUser(UserObject item);
	
	public UserObject getUserObject(int id);
	public UserObject getUserObject(String username, String password);
	public ArrayList<UserObject> getUserObjects(UserObject similar, int at, byte total);
}
