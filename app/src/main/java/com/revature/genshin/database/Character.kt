package com.revature.genshin.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.*
@Entity(tableName = "Character", indices = [Index(value = ["Character_Name"], unique = true)])
data class Character(

    @ColumnInfo(name = "Character_Name") public var Character_Name:String?=null,
    @ColumnInfo(name="Level") public var Level:Int=1,
    @ColumnInfo(name = "Ascension_Material_Elemental_Stone") public var Ascension_Material_Elemental_Stone:Elemental_Stone_Material,
    @ColumnInfo(name = "Ascension_Material_Boss_Drop") public var Ascension_Material_Boss_Drop:Boss_Material,
    @ColumnInfo(name = "Ascension_Material_Local_Specialty") public var Ascension_Material_Local_Specialty:Local_Specialty,
    @ColumnInfo(name = "Ascension_Material_Common_Material_Low") public var Ascension_Material_Common_Material_Low:Common_Material_Low,
    @ColumnInfo(name = "Ascension_Material_Common_Material_Mid") public var Ascension_Material_Common_Material_Mid:Common_Material_Mid,
    @ColumnInfo(name = "Ascension_Material_Common_Material_High") public var Ascension_Material_Common_Material_High:Common_Material_High,
    @ColumnInfo(name="WeaponType")public var WeaponType: Weapon=Weapon.SWORD,
    @ColumnInfo(name = "ElementType")public var ElementType:Element=Element.ELECTRO
){
    @PrimaryKey(autoGenerate = true) public var charId:Int=0

}



