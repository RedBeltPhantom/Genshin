package com.revature.genshin.screens

import android.graphics.Paint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.Navigator
import androidx.navigation.navOptions
import com.revature.genshin.R
import com.revature.genshin.defaultMessage

@Composable
fun MainScreen(navController: NavHostController) {
    defaultMessage("")
    Column(modifier = Modifier
        .background(MaterialTheme.colors.background)
//        .height(300.dp)
    ) {
        MyTopBar(navController)
        Spacer(modifier = Modifier.height(20.dp))
        WelcomeMessage()
        navigationButtons(navController = navController)
    }
}
@Composable
fun MyTopBar(navController: NavHostController)
{
    val context = LocalContext.current
    
    TopAppBar(
        title = { Text(text = "GenshinTracker", style= MaterialTheme.typography.h4)},
        navigationIcon= {
            IconButton(
                onClick = {
                    Toast.makeText(context, "Unlimited Power!!", Toast.LENGTH_LONG).show()
                }
            )
            {
                Icon(
                    painter = painterResource(id = R.drawable.img),
                    contentDescription = "BestGirl",
                    tint= Color.Unspecified
                
                )
            }
        },
//        modifier=Modifier.height(300.dp)
    )
}

@Composable
fun WelcomeMessage()
{
    Column(
        modifier = Modifier.background(MaterialTheme.colors.background)
//        .height(600.dp)
    ) {
        Surface(color = MaterialTheme.colors.primary) {

            Text(text = "Hello Whales")
        }
        Surface(color = MaterialTheme.colors.onPrimary) {
            Text(text = "Its Time To Spend $$$")
        }
        
    }
}

@Composable
fun navigationButtons(navController: NavHostController)
{
    Column() {
        Row() {
            Button(onClick = {
                navController.navigate("BuildScreen")
            }){
                Text(text = "BuildScreen")
            }
            Button(onClick = {
                navController.navigate("CharacterScreen/Ninguang")
            }){
                Text(text = "CharacterScreen")
            }
        }
        Row() {
            Button(onClick = {
                navController.navigate("InventoryScreen")
            }){
                Text(text = "InventoryScreen")
            }
            Button(onClick = {
                navController.navigate("WeaponScreen")
            }){
                Text(text = "WeaponScreen")
            }
        }
        
    }
}