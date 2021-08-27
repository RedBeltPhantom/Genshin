package com.revature.genshin.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.security.AccessControlContext

@Database(entities = [Character::class, MaterialListing::class], version = 59, exportSchema = false)
abstract class LocalDB : RoomDatabase() {

    abstract fun characters():DBDao
    abstract fun materials():MaterialsDao

    companion object{
        private var INSTANCE:LocalDB? = null
        fun getDatabase(context: Context):LocalDB?{
            if(INSTANCE==null)
            {
                INSTANCE = Room.databaseBuilder(context.applicationContext,
                LocalDB::class.java, "testing").fallbackToDestructiveMigration().build()
            }
            return INSTANCE
        }
    }
    fun destroyDB()
    {
        INSTANCE = null
    }
}