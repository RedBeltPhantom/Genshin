package com.revature.genshin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.revature.genshin.screens.*
import com.revature.genshin.ui.theme.GenshinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GenshinTheme {
                val navController = rememberNavController()
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
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
}
@Composable
fun defaultMessage(msg:String)
{
    Text(text = msg)
}
