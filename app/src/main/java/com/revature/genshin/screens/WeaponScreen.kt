package com.revature.genshin.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.revature.genshin.defaultMessage

@Composable
fun WeaponScreen(navController: NavHostController) {
    Column(modifier = Modifier
        .background(MaterialTheme.colors.background).fillMaxWidth()
//        .height(300.dp)
    ) {
        defaultMessage(msg = "Welcome to the Weapon Screen")
    }
}