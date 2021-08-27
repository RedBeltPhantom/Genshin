package com.revature.genshin.database

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "Materials")
 class MaterialListing(
    @PrimaryKey var name:String = "",
    var number:Int
) {
    override fun equals(other: Any?): Boolean {
        return this.javaClass ==other?.javaClass && (other as MaterialListing).name == this.name
    }
}