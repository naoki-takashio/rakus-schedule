package com.example.rakus_schedule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rakus_schedule.domain.Comment;
import com.example.rakus_schedule.repository.CommentRepository;

/**
 * commentsテーブルに関するサービスクラス
 * @author miyaharashuusaku
 *
 */
@Service
public class CommentService {

	@Autowired
	CommentRepository commentRepository;
	
	/**
	 * commentsテーブルに登録するメソッド
	 * @param comment
	 */
	public void commentsInsert(Comment comment){
		commentRepository.commentsInsert(comment);
	}
}
