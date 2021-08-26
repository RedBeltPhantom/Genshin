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
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.CoroutinesRoom
import androidx.room.Room
import com.revature.genshin.database.*
import com.revature.genshin.screens.*
import com.revature.genshin.ui.theme.GenshinTheme
import com.revature.genshin.viewmodels.GlobalViewModel
import java.lang.annotation.ElementType

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db =LocalDB.getDatabase(this)!!

        Log.i("DB", "Database successfully built")
        val viewModel=GlobalViewModel(db)
        var testCharacter = Character(1u,
                    "Ka-Ching!",
                    1u,
                    "", Weapon.SWORD,Element.ELECTRO
        )

        launch{
            db.characters().insert(testCharacter)
            Log.i("DB", "Test Character Inserted")
            Log.i("DB", db.characters().get(1u).toString())
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
                    composable("CharacterScreen")
                    {
                        CharacterScreen(navController = navController)
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

    private fun launch(block: suspend CoroutineScope.() -> Unit) {

    }
}
@Composable
fun defaultMessage(msg:String)
{
    Text(text = msg)
}
