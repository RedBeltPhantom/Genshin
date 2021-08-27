package com.revature.genshin

import kotlinx.coroutines.*
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.toLowerCase
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.revature.genshin.database.*
import com.revature.genshin.screens.*
import com.revature.genshin.ui.theme.GenshinTheme
import com.revature.genshin.viewmodels.GlobalViewModel
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db =LocalDB.getDatabase(this)!!

        Log.i("DB", "Database successfully built")
        val viewModel=GlobalViewModel(db)


        //Insert characters into the database if not already present
        lifecycleScope.launch(Dispatchers.IO) {
            Log.i("DB", "Loading Database:")
            populateDatabase(db)
        }
        setContent {
            GenshinTheme {

                val navController = rememberNavController()


                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background, modifier = Modifier.fillMaxWidth()) {
                   Text(text = "How did you get here? This shouldn't be possible!")
                }
                NavHost(navController = navController, startDestination = "MainScreen")
                {
                    composable("MainScreen")
                    {
                        MainScreen(navController = navController)
                    }
                    composable(
                        route="CharacterScreen/{Character_Name}",
                        arguments = listOf(navArgument("Character_Name")
                        {type=NavType.StringType}
                        )
                    ){backStackEntry->
                        CharacterScreen(navController = navController,
                        backStackEntry.arguments?.getString("Character_Name")?:"Invalid")
                    }
                    composable("InventoryScreen")
                    {
                        InventoryScreen(navController = navController)
                    }
                    composable("WeaponScreen")
                    {
                        WeaponScreen(navController = navController)
                    }
                    composable("BuildScreen")
                    {
                        BuildScreen(navController = navController)
                    }
                }
            }
        }
    }


}
@Composable
fun defaultMessage(msg:String)
{
    Text(text = msg)
}


private suspend fun populateDatabase(db: LocalDB)
{
    var champion = Character(
        "Keqing",
        1,
        Elemental_Stone_Material.VAJRADA_AMETHYST, Boss_Material.LIGHTNING_PRISM,
        Local_Specialty.COR_LAPIS, Common_Material_Low.WOPPERFLOWER_NECTAR,
        Common_Material_Mid.SHIMMERING_NECTAR,
        Common_Material_High.ENERGY_NECTAR,
        Weapon.SWORD,Element.ELECTRO
    )
    db.characters().safeInsert(champion)
    Log.i("DB", "Keqing Inserted")

    champion = Character(
        "Amber",
        1,
        Elemental_Stone_Material.AGNIDUS_AGATE, Boss_Material.EVERFLAME_SEED,
        Local_Specialty.SMALL_LAMP_GRASS, Common_Material_Low.FIRM_ARROWHEAD,
        Common_Material_Mid.SHARP_ARROWHEAD,
        Common_Material_High.WEATHERED_ARROWHEAD,
        Weapon.BOW,Element.PYRO
    )
    db.characters().safeInsert(champion)
    Log.i("DB", "Amber Inserted")

    champion = Character(
        "Barbara",
        1,
        Elemental_Stone_Material.VARUNADA_LAZURITE, Boss_Material.CLEANSING_HEART,
        Local_Specialty.PHILANEMO_MUSHROOM, Common_Material_Low.DIVINING_SCROLL,
        Common_Material_Mid.SEALED_SCROLL,
        Common_Material_High.FORBIDDEN_CURSE_SCROLL,
        Weapon.CATYLYST,Element.HYDRO
    )
    db.characters().safeInsert(champion)
    Log.i("DB", "Barbara Inserted")

    champion = Character(
        "Beidou",
        1,
        Elemental_Stone_Material.VAJRADA_AMETHYST, Boss_Material.LIGHTNING_PRISM,
        Local_Specialty.NOCTILIOUS_JADE, Common_Material_Low.TREASURE_HORDER_INSIGNIA,
        Common_Material_Mid.SILVER_RAVEN_INSIGNIA,
        Common_Material_High.GOLDEN_RAVEN_INSIGNIA,
        Weapon.CLAYMORE,Element.ELECTRO
    )
    db.characters().safeInsert(champion)
    Log.i("DB", "Beidou Inserted")

    champion = Character(
        "Chongyun",
        1,
        Elemental_Stone_Material.SHIVADA_JADE, Boss_Material.HOARFROST_CORE,
        Local_Specialty.COR_LAPIS, Common_Material_Low.DAMAGED_MASK,
        Common_Material_Mid.STAINED_MASK,
        Common_Material_High.OMINOUS_MASK,
        Weapon.CLAYMORE,Element.CRYO
    )
    db.characters().safeInsert(champion)
    Log.i("DB", "Chongyun Inserted")

    champion = Character(
        "Fischl",
        1,
        Elemental_Stone_Material.VAJRADA_AMETHYST, Boss_Material.LIGHTNING_PRISM,
        Local_Specialty.SMALL_LAMP_GRASS, Common_Material_Low.FIRM_ARROWHEAD,
        Common_Material_Mid.SHARP_ARROWHEAD,
        Common_Material_High.WEATHERED_ARROWHEAD,
        Weapon.BOW,Element.ELECTRO
    )
    db.characters().safeInsert(champion)
    Log.i("DB", "Fischl Inserted")
        var j:String = db.characters().getChars().fold(""){a, it->a+ it.toString()
    .replace('_', ' ').lowercase(Locale.getDefault()).capitalize(Locale.getDefault()) +"\n" }

        Log.i("DB", j.split(" ",).fold(""){b, it-> b+it.capitalize(Locale.getDefault())+" "})

}