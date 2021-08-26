package com.revature.genshin.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.revature.genshin.defaultMessage

@Composable
fun BuildScreen(navController: NavHostController){
    Column(modifier = Modifier
        .background(MaterialTheme.colors.background).fillMaxWidth()
//        .height(300.dp)
    ) {
        defaultMessage(msg = "Welcome to The Build Screen!")
    }
}