package com.revature.genshin.database

import android.provider.Contacts
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*
@Entity(tableName = "Character")
public data class Character(
    @PrimaryKey public var charId:UInt = 0u,
    @ColumnInfo(name = "Character_Name") public var Character_Name:String?=null,
    @ColumnInfo(name="Level") public var Level:UInt=0u,
    @ColumnInfo(name = "Ascension_Materials") public var Ascension_Materials:String="",
    @ColumnInfo(name="WeaponType")public var WeaponType: Weapon=Weapon.SWORD,
    @ColumnInfo(name = "ElementType")public var ElementType:Element=Element.ELECTRO
){
    constructor():this(1u)


    @JvmName("getCharId")
    fun getCharId():UInt=getCharId()

    @JvmName("setCharId")
    fun setCharId(u:UInt){charId=u}

    @JvmName("getLevel")
    fun getLevel():UInt=Level

    @JvmName("setLevel")
    fun setLevel(s:UInt){Level=s}
}


enum class Element()
{
    HYDRO,
    PYRO,
    GEO,
    ANEMO,
    CRYO,
    DENDRO,
    ELECTRO;

    override fun toString(): String {
        return this.toString()
            .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
    }

}

enum class Weapon()
{
    SWORD,
    CLAYMORE,
    CATYLYST,
    BOW;
    override fun toString(): String {
        return this.toString()
            .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
    }
}
