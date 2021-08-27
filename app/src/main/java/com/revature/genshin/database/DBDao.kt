package com.revature.genshin.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface  DBDao {

    @Insert
    private suspend fun insert(cha:Character){}

    @Update
    private suspend fun update(cha:Character){}

    @Insert
    suspend fun safeInsert(champion:Character)
    {
        val cha:Character? =getChar(champion.Character_Name?:"")
        if(cha == null)
        {
            insert(champion)
        }
        else
        {
            //do nothing, if character is already there
        }
    }

    @Query("SELECT * FROM Character WHERE Character_Name= :name")
    suspend fun getChar(name:String):Character?

    @Query("SELECT * FROM CHARACTER")
    suspend fun getChars():List<Character>

}