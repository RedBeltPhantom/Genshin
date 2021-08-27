package com.revature.genshin.database

import androidx.compose.ui.text.capitalize
import com.google.android.material.shape.MaterialShapeDrawable
import java.util.*

interface Mats
{

}


enum class Elemental_Stone_Material(name:String):Mats{
    AGNIDUS_AGATE("Agnidus Agate"),
    BRILLIANT_DIAMOND("Brilliant Diamond"),
    VAYUDA_TURQOISE("Vayuda Turqoise"),
    SHIVADA_JADE("Shivada Jade"),
    VAJRADA_AMETHYST("Vajrada Amethyst"),
    PRITHIVA_TOPAZ("Prithiva Topaz"),
    VARUNADA_LAZURITE("Varunada Lazurite")
}
enum class Elemental_Stone_Size(size:String):Mats
{
    SLIVER("sliver"),
    FRAGMENT("fragment"),
    CHUNK("chunk"),
    GEMSTONE("gemstone")
}
enum class Boss_Material(material:String):Mats
{
    BASALT_PILLAR("BASALT_PILLAR".toString().replace('_', ' ').capitalize(Locale.getDefault())),
    CLEANSING_HEART("CLEANSING_HEART".toString().replace('_', ' ').capitalize(Locale.getDefault())),
    CRYSTALLINE_BLOOM("CRYSTALLINE_BLOOM".toString().replace('_', ' ').capitalize(Locale.getDefault())),
    EVERFLAME_SEED(this.toString().replace('_', ' ').capitalize(Locale.getDefault())),
    HOARFROST_CORE(this.toString().replace('_', ' ').capitalize(Locale.getDefault())),
    HURRICANE_SEED(this.toString().replace('_', ' ').capitalize(Locale.getDefault())),
    JUVENILE_JADE(this.toString().replace('_', ' ').capitalize(Locale.getDefault())),
    LIGHTNING_PRISM(this.toString().replace('_', ' ').capitalize(Locale.getDefault())),
    MARIONETTE_CORE(this.toString().replace('_', ' ').capitalize(Locale.getDefault())),
    PERPETUAL_HEART(this.toString().replace('_', ' ').capitalize(Locale.getDefault())),
    SMOLDERING_PEARL(this.toString().replace('_', ' ').capitalize(Locale.getDefault())),
}

enum class Local_Specialty(specialty:String):Mats {
    CALLA_LILY(this.toString().replace('_', ' ').capitalize(Locale.getDefault())),
    CECILIA(this.toString().replace('_', ' ').capitalize(Locale.getDefault())),
    COR_LAPIS(this.toString().replace('_', ' ').capitalize(Locale.getDefault())),
    CRYSTAL_MARROW(this.toString().replace('_', ' ').capitalize(Locale.getDefault())),
    DANDELION_SEED(this.toString().replace('_', ' ').capitalize(Locale.getDefault())),
    DENDROBIUM(this.toString().replace('_', ' ').capitalize(Locale.getDefault())),
    GLAZE_LILY(this.toString().replace('_', ' ').capitalize(Locale.getDefault())),
    JUEYUN_CHILI(this.toString().replace('_', ' ').capitalize(Locale.getDefault())),
    NAKU_WEED(this.toString().replace('_', ' ').capitalize(Locale.getDefault())),
    NOCTILIOUS_JADE(this.toString().replace('_', ' ').capitalize(Locale.getDefault())),
    ONIKABUTO(this.toString().replace('_', ' ').capitalize(Locale.getDefault())),
    PHILANEMO_MUSHROOM(this.toString().replace('_', ' ').capitalize(Locale.getDefault())),
    QUINGXIN(this.toString().replace('_', ' ').capitalize(Locale.getDefault())),
    SAKURA_BLOOM(this.toString().replace('_', ' ').capitalize(Locale.getDefault())),
    SEA_GANODERMA(this.toString().replace('_', ' ').capitalize(Locale.getDefault())),
    SILK_FLOWER(this.toString().replace('_', ' ').capitalize(Locale.getDefault())),
    SMALL_LAMP_GRASS(this.toString().replace('_', ' ').capitalize(Locale.getDefault())),
    STARCONCH(this.toString().replace('_', ' ').capitalize(Locale.getDefault())),
    VALBERRY(this.toString().replace('_', ' ').capitalize(Locale.getDefault())),
    VIOLETGRASS(this.toString().replace('_', ' ').capitalize(Locale.getDefault())),
    WINDWHEEL_ASTER(this.toString().replace('_', ' ').capitalize(Locale.getDefault())),
    WOLFHOOK(this.toString().replace('_', ' ').capitalize(Locale.getDefault())),

}

enum class Common_Material_Low(material: String):Mats
{
    SLIME_CONDENSATION(this.toString().replace('_', ' ').capitalize(Locale.getDefault())),
    DAMAGED_MASK(this.toString().replace('_', ' ').capitalize(Locale.getDefault())),
    FIRM_ARROWHEAD(this.toString().replace('_', ' ').capitalize(Locale.getDefault())),
    DIVINING_SCROLL(this.toString().replace('_', ' ').capitalize(Locale.getDefault())),
    TREASURE_HORDER_INSIGNIA(this.toString().replace('_', ' ').capitalize(Locale.getDefault())),
    RECRUIT_INSIGNIA("Recruit's Insignia"),
    WOPPERFLOWER_NECTAR(this.toString().replace('_', ' ').capitalize(Locale.getDefault())),
    OLD_HANDGUARD(this.toString().replace('_', ' ').capitalize(Locale.getDefault())),
}
enum class Common_Material_Mid(material: String):Mats
{
    SLIME_SECRETIONS(this.toString().replace('_', ' ').capitalize(Locale.getDefault())),
    STAINED_MASK(this.toString().replace('_', ' ').capitalize(Locale.getDefault())),
    SHARP_ARROWHEAD(this.toString().replace('_', ' ').capitalize(Locale.getDefault())),
    SEALED_SCROLL(this.toString().replace('_', ' ').capitalize(Locale.getDefault())),
    SILVER_RAVEN_INSIGNIA(this.toString().replace('_', ' ').capitalize(Locale.getDefault())),
    SERGEANT_INSIGNIA("Sergeatn's Insignia"),
    SHIMMERING_NECTAR(this.toString().replace('_', ' ').capitalize(Locale.getDefault())),
    KAGEUCHI_HANDGUARD(this.toString().replace('_', ' ').capitalize(Locale.getDefault())),
}
enum class Common_Material_High(material: String):Mats
{
    SLIME_CONCENTRATE(this.toString().replace('_', ' ').capitalize(Locale.getDefault())),
    OMINOUS_MASK(this.toString().replace('_', ' ').capitalize(Locale.getDefault())),
    WEATHERED_ARROWHEAD(this.toString().replace('_', ' ').capitalize(Locale.getDefault())),
    FORBIDDEN_CURSE_SCROLL(this.toString().replace('_', ' ').capitalize(Locale.getDefault())),
    GOLDEN_RAVEN_INSIGNIA(this.toString().replace('_', ' ').capitalize(Locale.getDefault())),
    LIEUTENANT_INSIGNIA("Lieutenant's Insignia"),
    ENERGY_NECTAR(this.toString().replace('_', ' ').capitalize(Locale.getDefault())),
    FAMED_HANDGUARD(this.toString().replace('_', ' ').capitalize(Locale.getDefault())),
}
enum class Weapon_Material
{
    NOT_IMPLEMENTED_YET;
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


}

enum class Weapon()
{
    SWORD,
    CLAYMORE,
    CATYLYST,
    BOW;
}