package data;

import entities.User;

public interface WonderquestDAO {

	public User getUserByUsername(String username, String password);
}
