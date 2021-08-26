package com.revature.genshin.screens

import android.graphics.Paint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.revature.genshin.Greeting
import com.revature.genshin.R

@Composable
fun MainScreen(navController: NavHostController) {
    Column(modifier = Modifier
        .background(MaterialTheme.colors.background)
//        .height(300.dp)
    ) {
        MyTopBar(navController)
        Spacer(modifier = Modifier.height(20.dp))
        WelcomeMessage()
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
            Greeting(name = "Its Time To Spend $$$")
        }
        
    }
}