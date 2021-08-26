package com.revature.genshin.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
abstract class DBDao {

    @Insert
    abstract suspend fun insert(character:Character)

//    @Query("SELECT * FROM Character WHERE charID=:character")
//    fun getMaterials(character:UInt):Map<Int, List<Pair<String, Int>>>
//
//    @Query("SELECT * FROM Character WHERE charId=:character")
//    fun getWeaponType(character:UInt):Weapon
//
//    @Query("SELECT * FROM Character WHERE charId=:character")
//    fun getElementType(character:UInt):Element

    @Query("SELECT * FROM Character WHERE charId= :character")
    abstract suspend fun get(character:UInt):Character

//    @Query("SELECT * FROM Character WHERE charId=:character")
//    fun getLevel(character:UInt):UInt
}