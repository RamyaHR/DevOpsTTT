package com.niit.LetsChatBackend.Dao;

import java.util.List;

import com.niit.LetsChatBackend.model.Forum;
import com.niit.LetsChatBackend.model.ForumComment;

public interface ForumDao {

	public boolean addForum(Forum forum);
	public boolean deleteForum(Forum forum);
	public boolean updateForum(Forum forum);
	public Forum getForum(int forumId);
	public boolean approveForum(Forum forum);
	public boolean rejectForum(Forum forum);
	public List<Forum> listForum(String userName);
	
	public boolean addForumComment(ForumComment forumComment);
	public boolean deleteForumComment(ForumComment forumComment);
	public ForumComment getForumComment(int commentId);
	public List<ForumComment> listForumComments(int forumId);
}
