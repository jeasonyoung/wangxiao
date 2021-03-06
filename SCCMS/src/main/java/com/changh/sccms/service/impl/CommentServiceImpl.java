package com.changh.sccms.service.impl;

import java.util.List;

import com.changh.sccms.dao.CommentDAO;
import com.changh.sccms.entity.Comment;
import com.changh.sccms.service.CommentService;

public class CommentServiceImpl implements CommentService {
	private CommentDAO commentDao;

	public List<Comment> findByTchId(int tchId, int page, int pagesize,
			String sortname, String sortorder) {
		
		return commentDao.findByTchId(tchId, page, pagesize, sortname, sortorder);
		
	}

	public int findTotal(int tchId) {
		return commentDao.findTotal(tchId);
	}

	public void setCommentDao(CommentDAO commentDao) {
		this.commentDao = commentDao;
	}

	public int findSorce(int tchId) {
		return commentDao.findSorce(tchId);
	}

	public void save(Comment comment) {
		commentDao.save(comment);
	}

	public int getCommentId() {
		return commentDao.getCommentId();
	
	}

}
