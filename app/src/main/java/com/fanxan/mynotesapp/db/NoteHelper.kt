package com.fanxan.mynotesapp.db

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import com.fanxan.mynotesapp.db.DatabaseContract.NoteColumns.Companion.DATE
import com.fanxan.mynotesapp.db.DatabaseContract.NoteColumns.Companion.DESCRIPTION
import com.fanxan.mynotesapp.db.DatabaseContract.NoteColumns.Companion.TABLE_NAME
import com.fanxan.mynotesapp.db.DatabaseContract.NoteColumns.Companion.TITLE
import com.fanxan.mynotesapp.db.DatabaseContract.NoteColumns.Companion._ID
import com.fanxan.mynotesapp.entity.Note

//
//class NoteHelper(context: Context) {
//    private lateinit var database: SQLiteDatabase
////    private var databaseHelper = DatabaseHelper(context)
//
//        init {
//        databaseHelper = DatabaseHelper(context)
//    }
//
//    companion object {
//        private const val DATABASE_TABLE = TABLE_NAME
//        private lateinit var databaseHelper: DatabaseHelper
//        private var INSTANCE: NoteHelper? = null
//        fun getInstance(context: Context): NoteHelper =
//            INSTANCE ?: synchronized(this) {
//                INSTANCE ?: NoteHelper(context)
//            }
//    }
//
//    @Throws(SQLException::class)
//    fun open() {
//        database = databaseHelper.writableDatabase
//    }
//
//    fun close() {
//        databaseHelper.close()
//
//        if (database.isOpen)
//            database.close()
//
//    }
//
//    fun queryAll(): Cursor {
//        return database.query(
//            DATABASE_TABLE,
//            null,
//            null,
//            null,
//            null,
//            null,
//            "$_ID ASC"
//        )
//    }
//
//    fun queryById(id: String): Cursor {
//        return database.query(
//            DATABASE_TABLE,
//            null,
//            "$_ID = ?",
//            arrayOf(id),
//            null,
//            null,
//            null,
//            null
//        )
//    }
//
//    fun insert(values: ContentValues?): Long {
//        return database.insert(DATABASE_TABLE, null, values)
//    }
//
//    fun update(id: String, values: ContentValues?): Int {
//        return database.update(DATABASE_TABLE, values, "$_ID = ?", arrayOf(id))
//    }
//
//    fun deletedById(id: String): Int {
//        return database.delete(DATABASE_TABLE, "$_ID = '$id'", null)
//    }
//
//    fun getAllNotes(): ArrayList<Note> {
//        val arrayList = ArrayList<Note>()
//        val cursor = database.query(DATABASE_TABLE, null, null, null, null, null, "$_ID ASC", null)
//        cursor.moveToFirst()
//        var note: Note
//        if (cursor.count > 0) {
//            do {
//                note = Note()
//                note.id = cursor.getInt(cursor.getColumnIndexOrThrow(_ID))
//                note.title = cursor.getString(cursor.getColumnIndexOrThrow(TITLE))
//                note.description = cursor.getString(cursor.getColumnIndexOrThrow(DESCRIPTION))
//                note.date = cursor.getString(cursor.getColumnIndexOrThrow(DATE))
//                arrayList.add(note)
//                cursor.moveToNext()
//            } while (!cursor.isAfterLast)
//        }
//        cursor.close()
//        return arrayList
//    }
//
//    fun insertNote(note: Note): Long {
//        val args = ContentValues()
//        args.put(TITLE, note.title)
//        args.put(DESCRIPTION, note.description)
//        args.put(DATE, note.date)
//        return database.insert(DATABASE_TABLE, null, args)
//    }
//
//    fun updateNote(note: Note): Int {
//        val args = ContentValues()
//        args.put(TITLE, note.title)
//        args.put(DESCRIPTION, note.description)
//        args.put(DATE, note.date)
//        return database.update(DATABASE_TABLE, args, _ID + "= '" + note.id + "'", null)
//    }
//
//    fun deleteeNote(id: Int): Int {
//        return database.delete(TABLE_NAME, "$_ID = '$id'", null)
//    }
//}

class NoteHelper(context: Context) {

    private var dataBaseHelper: DatabaseHelper = DatabaseHelper(context)
    private lateinit var database: SQLiteDatabase

    companion object {
        private const val DATABASE_TABLE = TABLE_NAME
        private var INSTANCE: NoteHelper? = null

        fun getInstance(context: Context): NoteHelper =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: NoteHelper(context)
            }
    }

    @Throws(SQLException::class)
    fun open() {
        database = dataBaseHelper.writableDatabase
    }

    fun close() {
        dataBaseHelper.close()

        if (database.isOpen)
            database.close()
    }

    fun queryAll(): Cursor {
        return database.query(
            DATABASE_TABLE,
            null,
            null,
            null,
            null,
            null,
            "$_ID ASC",
            null)
    }

    fun queryById(id: String): Cursor {
        return database.query(DATABASE_TABLE, null, "$_ID = ?", arrayOf(id), null, null, null, null)
    }

    fun insert(values: ContentValues?): Long {
        return database.insert(DATABASE_TABLE, null, values)
    }

    fun update(id: String, values: ContentValues?): Int {
        return database.update(DATABASE_TABLE, values, "$_ID = ?", arrayOf(id))
    }

    fun deleteById(id: String): Int {
        return database.delete(DATABASE_TABLE, "$_ID = '$id'", null)
    }
}