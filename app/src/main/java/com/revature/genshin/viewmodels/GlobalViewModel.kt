package com.revature.genshin.viewmodels

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.room.Room
import androidx.room.RoomDatabase
import com.revature.genshin.database.Character
import com.revature.genshin.database.LocalDB
import com.revature.genshin.database.MaterialListing
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.lang.Exception
import java.lang.NullPointerException

object GlobalViewModel:ViewModel(){

    private  var db: LocalDB? = null
    fun getDataBase():LocalDB
    {
        if(db==null)
            throw(Exception("The database is gone, captain!"))
        return db!!
    }


    fun setDataBase(database:LocalDB)
    {
        db = database
    }
    private var character:Character?=null
    private fun loadCharacter(name:String)= runBlocking {
        val job = viewModelScope.launch {

                  character = db!!.characters().getChar(name)?: throw(Exception("Failed to retrieve character from database"))
        }
        job.join()
    }
    fun getCharacter(name:String):Character
    {
        character = null
        loadCharacter(name)

        return character!!
    }
    private var materials:List<MaterialListing>?=null
    private fun retrieveMaterials()= runBlocking {
        val job =viewModelScope.launch(Dispatchers.IO) {
            materials = db!!.materials().getAllMaterials()
        }
        job.join()
    }
    fun getMaterials():List<MaterialListing>
    {
        materials=null
        retrieveMaterials()
        return materials!!
    }

    fun updateMaterial(mat:MaterialListing)
    {
        viewModelScope.launch(Dispatchers.IO) {
            db?.materials()?.updateMaterial(mat)
        }
    }

}