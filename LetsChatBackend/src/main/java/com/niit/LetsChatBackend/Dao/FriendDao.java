package com.niit.LetsChatBackend.Dao;

import java.util.List;

import com.niit.LetsChatBackend.model.Friend;
import com.niit.LetsChatBackend.model.UserDetail;

public interface FriendDao {

	public boolean SendFriendRequest(Friend friend);
	public boolean DeleteFriendRequest(int friendId);
	public List<UserDetail> ShowSuggestedFriend(String loginname);
	public List<Friend> ShowAllFriends(String loginname);
	public List<Friend> ShowRequestPendingList(String loginname);
	public boolean acceptFriendRequest(int friendId);
}
