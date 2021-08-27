package com.revature.genshin.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface MaterialsDao {

    @Insert
    private suspend fun insert(mat:MaterialListing){}

    @Query("SELECT * FROM MATERIALS WHERE name=:mat")
    private suspend fun getMaterialNumber(mat:String):MaterialListing?{
        return null
    }

    @Query("SELECT * FROM MATERIALS WHERE name = :mat")
    suspend fun getMaterial(mat:String):MaterialListing

    @Insert
    suspend fun safeInsert(mat:MaterialListing)
    {
        val material:String? =getMaterial(mat.name).name?:null
        if(material == null)
        {
            insert(mat)
        }
        else
        {
            //do nothing, if material is already present
        }
    }
    @Query("SELECT * FROM MATERIALS")
    suspend fun getAllMaterials():List<MaterialListing>

    @Update
    suspend fun updateMaterial(mat:MaterialListing)
}