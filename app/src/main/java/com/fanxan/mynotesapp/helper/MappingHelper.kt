package com.fanxan.mynotesapp.helper

import android.database.Cursor
import com.fanxan.mynotesapp.db.DatabaseContract
import com.fanxan.mynotesapp.entity.Note

//object MappingHelper{
//    fun mapCursorToArrayList(noteCursor: Cursor?):ArrayList<Note>{
//        val noteList = ArrayList<Note>()
//        noteCursor?.apply {
//            while(moveToNext()){
//                val id = getInt(getColumnIndexOrThrow(DatabaseContract.NoteColumns._ID))
//                val title = getString(getColumnIndexOrThrow(DatabaseContract.NoteColumns.TITLE))
//                val description = getString(getColumnIndexOrThrow(DatabaseContract.NoteColumns.DESCRIPTION))
//                val date = getString(getColumnIndexOrThrow(DatabaseContract.NoteColumns.DATE))
//                noteList.add(Note(id,title,description,date))
//            }
//        }
//        return noteList
//    }
//}

object MappingHelper {

    fun mapCursorToArrayList(notesCursor: Cursor?): ArrayList<Note> {
        val notesList = ArrayList<Note>()

        notesCursor?.apply {
            while (moveToNext()) {
                val id = getInt(getColumnIndexOrThrow(DatabaseContract.NoteColumns._ID))
                val title = getString(getColumnIndexOrThrow(DatabaseContract.NoteColumns.TITLE))
                val description = getString(getColumnIndexOrThrow(DatabaseContract.NoteColumns.DESCRIPTION))
                val date = getString(getColumnIndexOrThrow(DatabaseContract.NoteColumns.DATE))
                notesList.add(Note(id, title, description, date))
            }
        }
        return notesList
    }
}