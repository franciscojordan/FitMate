package com.example.fitmate.database

import android.annotation.SuppressLint
import android.content.Context
import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.fitmate.R
import org.mindrot.jbcrypt.BCrypt

class DatabaseAPP(
    context: Context?
) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "UserDatabase"
        private const val TABLE_USERS = "Users"
        private const val KEY_ID = "ID"
        private const val KEY_USERNAME = "USERNAME"
        private const val KEY_PASSWORD = "PASSWORD"
        private const val KEY_EMAIL = "EMAIL" // Agregar esto si necesita una columna de email

        private var instance: DatabaseAPP? = null

        @Synchronized
        fun getInstance(context: Context): DatabaseAPP {
            if (instance == null) {
                instance = DatabaseAPP(context.applicationContext)
            }
            return instance!!
        }

        // Asegúrese de incluir la columna de EMAIL si es necesaria para su aplicación
        private val CREATE_USERS_TABLE = "CREATE TABLE $TABLE_USERS (" +
                "$KEY_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$KEY_USERNAME TEXT," +
                "$KEY_PASSWORD TEXT," +
                "$KEY_EMAIL TEXT)" // Asegúrese de remover esta línea si no necesita almacenar email

        private val CREATE_EXERCISES_TABLE = "CREATE TABLE Exercises (" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "TITLE TEXT," +
                "IMAGE_RES_ID INTEGER," +
                "DESCRIPTION TEXT)"
    }


    override fun onCreate(database: SQLiteDatabase?) {
        database?.execSQL(CREATE_USERS_TABLE)
        database?.execSQL(CREATE_EXERCISES_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_USERS")
        onCreate(db)
    }

    fun addUser(username: String, password: String, email: String) { // Asegúrese de modificar los parámetros según sus necesidades
        val db = this.writableDatabase

        val encriptedPassword = BCrypt.hashpw(password, BCrypt.gensalt())

        val values = ContentValues()
        values.put(KEY_USERNAME, username)
        values.put(KEY_PASSWORD, encriptedPassword)
        values.put(KEY_EMAIL, email) // Remueva esta línea si no tiene una columna de email

        db.insert(TABLE_USERS, null, values)
        db.close()
    }

    fun userExists(username: String, password: String): Boolean {
        val db = this.readableDatabase
        val selectQuery = "SELECT * FROM $TABLE_USERS WHERE $KEY_USERNAME = ? AND $KEY_PASSWORD = ?"
        db.rawQuery(selectQuery, arrayOf(username, password)).use { // use {} para cerrar el cursor automáticamente
            if (it.moveToFirst()) {
                return true // El usuario existe
            }
        }
        return false // El usuario no existe
    }

    @SuppressLint("Range")
    fun getUser(username: String): User? {
        val db = this.readableDatabase

        val selectQuery = "SELECT * FROM $TABLE_USERS WHERE $KEY_USERNAME = ?"
        db.rawQuery(selectQuery, arrayOf(username)).use { // Usamos use para cerrar el cursor automáticamente
            if (it.moveToFirst()) {
                val user = User(
                    it.getInt(it.getColumnIndex(KEY_ID)),
                    it.getString(it.getColumnIndex(KEY_USERNAME)),
                    it.getString(it.getColumnIndex(KEY_PASSWORD)),
                    it.getString(it.getColumnIndex(KEY_EMAIL))
                )
                return user
            }
        }
        return null
    }

    @SuppressLint("Range")
    fun verifyUser(username: String, password: String): Boolean {
        val db = this.readableDatabase

        // Consulta para buscar el usuario por nombre de usuario
        val selectQuery = "SELECT * FROM $TABLE_USERS WHERE $KEY_USERNAME = ?"
        val cursor = db.rawQuery(selectQuery, arrayOf(username))

        if (cursor.moveToFirst()) {
            val storedPassword = cursor.getString(cursor.getColumnIndex(KEY_PASSWORD))

            // Verifica la contraseña usando BCrypt
            if (BCrypt.checkpw(password, storedPassword)) {
                cursor.close()
                return true
            }
        }

        cursor.close()
        return false
    }
    @SuppressLint("Range")
    fun getUserEmailByUsername(username: String): String? {
        val db = this.readableDatabase
        val cursor = db.query(
            TABLE_USERS, // Nombre de la tabla
            arrayOf(KEY_EMAIL), // String array de las columnas que quiere obtener, en este caso solo el email
            "$KEY_USERNAME=?", // La selección
            arrayOf(username), // Los argumentos de selección
            null,
            null,
            null
        )
        var email: String? = null
        if (cursor.moveToFirst()) {
            email = cursor.getString(cursor.getColumnIndex(KEY_EMAIL))
        }
        cursor.close()
        db.close()
        return email
    }

    fun generateSampleData(): List<Exercise> {
        val exercises = listOf(
            Exercise("Ejercicio 1", R.drawable.exercise_image, "Descripción del ejercicio 1."),
            Exercise("Ejercicio 2", R.drawable.exercise_image, "Descripción del ejercicio 2."),
            Exercise("Ejercicio 3", R.drawable.exercise_image, "Descripción del ejercicio 3.")
        )

        // Opcional: Insertar en la base de datos si se requiere
        val db = this.writableDatabase
        for (exercise in exercises) {
            val values = ContentValues()
            values.put("TITLE", exercise.title)
            values.put("IMAGE_RES_ID", exercise.imageResId)
            values.put("DESCRIPTION", exercise.description)
            db.insert("Exercises", null, values)
        }
        db.close()

        return exercises
    }

}
