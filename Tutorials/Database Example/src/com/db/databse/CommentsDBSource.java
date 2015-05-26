package com.db.databse;

import java.util.ArrayList;
import java.util.List;

import com.db.models.Comment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class CommentsDBSource {

	// Database fields
	private SQLiteDatabase database;
	private MySQLiteHelper dbHelper;
	private String[] allColumns = { MySQLiteHelper.COLUMN_ID,
			MySQLiteHelper.COLUMN_COMMENT };

	public CommentsDBSource(Context context) {
		dbHelper = new MySQLiteHelper(context);
	}

	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}

	public Comment createComment(String comment) {
		ContentValues values = new ContentValues();
		values.put(MySQLiteHelper.COLUMN_COMMENT, comment);
		//SQLiteDatabase.insert(String table, String nullColumnHack, ContentValues values)

		long insertId = database.insert(MySQLiteHelper.TABLE_COMMENTS, null,values);

		//SQLiteDatabase.query(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy)
		Cursor cursor = database.query(MySQLiteHelper.TABLE_COMMENTS,	allColumns, MySQLiteHelper.COLUMN_ID + " = " + insertId, null,null, null, null);

		cursor.moveToFirst();
		Comment newComment = cursorToComment(cursor);
		cursor.close();
		return newComment;
	}

	public void deleteComment(Comment comment) {
		long id = comment.getId();
		System.out.println("Comment deleted with id: " + id);
		//SQLiteDatabase.delete(String table, String whereClause, String[] whereArgs)
		//whereArgs	You may include ?s in the where clause, which will be replaced by the values from whereArgs. The values will be bound as Strings.
		database.delete(MySQLiteHelper.TABLE_COMMENTS, MySQLiteHelper.COLUMN_ID+ " = " + id, null);
	}

	public List<Comment> getAllComments() {
		List<Comment> comments = new ArrayList<Comment>();
		//SQLiteDatabase.query(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy)
		Cursor cursor = database.query(MySQLiteHelper.TABLE_COMMENTS,	allColumns, null, null, null, null, null);

		//you can execute it like this too
		//		Cursor cursor = database.rawQuery("select * from "+MySQLiteHelper.TABLE_COMMENTS, null);

		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Comment comment = cursorToComment(cursor);
			comments.add(comment);
			cursor.moveToNext();
		}
		// make sure to close the cursor
		cursor.close();
		return comments;
	}

	private Comment cursorToComment(Cursor cursor) {
		Comment comment = new Comment();
		comment.setId(cursor.getLong(0));
		comment.setComment(cursor.getString(1));
		return comment;
	}
}