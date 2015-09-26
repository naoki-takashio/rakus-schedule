package com.example.rakus_schedule.util;

import org.springframework.stereotype.Component;

/**
 * commentsテーブルに関するsql文を保管するクラス
 * @author miyaharashuusaku
 *
 */
@Component
public class CommentSqlUtil {
	
	/**
	 * commentsテーブルに登録するsql文を返すメソッド
	 * @return Commentsテーブルに登録するINSERT文
	 */
	public String getInsertCommentsSql(){
		StringBuilder InsertCommentsSql = new StringBuilder();
		InsertCommentsSql.append("INSERT INTO");
		InsertCommentsSql.append("	comments");
		InsertCommentsSql.append("	(");
		InsertCommentsSql.append("	comment_content");
		InsertCommentsSql.append("	,creator_id");
		InsertCommentsSql.append("	,created_at");
		InsertCommentsSql.append("	,task_id");
		InsertCommentsSql.append("	,updated_at");
		InsertCommentsSql.append("	,deleted_flg");
		InsertCommentsSql.append("	)");
		InsertCommentsSql.append("	values");
		InsertCommentsSql.append("	(");
		InsertCommentsSql.append("	:commentContent");
		InsertCommentsSql.append("	,1");//ログイン機能追加後、実装する
		InsertCommentsSql.append("	,CURRENT_TIMESTAMP");
		InsertCommentsSql.append("	,:taskId");
		InsertCommentsSql.append("	,CURRENT_TIMESTAMP");
		InsertCommentsSql.append("	,false");
		InsertCommentsSql.append("	)");
		InsertCommentsSql.append(";");
		return InsertCommentsSql.toString();
	}

	/**
	 * アクティブなコメントで尚且つ、task_idを条件に抽出するsql文
	 * @return アクティブなコメントで尚且つ、task_idを条件に抽出するsql文
	 */
	public String getActiveCommentssAndFindByIDSql(){
		StringBuilder activeCommentssAndFindByIDSql = new StringBuilder();
		activeCommentssAndFindByIDSql.append("SELECT");
		activeCommentssAndFindByIDSql.append("	comment_content");
		activeCommentssAndFindByIDSql.append("FROM");
		activeCommentssAndFindByIDSql.append("	comments");
		activeCommentssAndFindByIDSql.append("WHERE");
		activeCommentssAndFindByIDSql.append("	task_id = 1");
		activeCommentssAndFindByIDSql.append("	AND");
		activeCommentssAndFindByIDSql.append("	deleted_flg = false	");
		activeCommentssAndFindByIDSql.append(";");
		return activeCommentssAndFindByIDSql.toString();
	}
	
	
}
