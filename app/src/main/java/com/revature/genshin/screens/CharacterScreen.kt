package com.revature.genshin.screens

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.revature.genshin.R
import com.revature.genshin.database.LocalDB
import com.revature.genshin.viewmodels.GlobalViewModel
import kotlinx.coroutines.launch

private fun loadChar(context:Context){

       val db = LocalDB.getDatabase(context)
}

@Composable
fun CharacterScreen(navController: NavHostController, characterName:String) {

    Column(modifier = Modifier
        .background(MaterialTheme.colors.background)
        .fillMaxWidth()
//        .height(300.dp)
    ) {

        CharacterSelect()
    }
}

var id = R.drawable.ic_launcher_foreground
var name = "Select Character"

@Composable
fun CharacterSelect() {

    val expanded = remember { mutableStateOf(false) }

    Box(
        Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.TopStart)
    ) {
        Row {

            IconButton(onClick = { expanded.value = true }) {
                Icon(
                    Icons.Filled.MoreVert,
                    contentDescription = "Character"
                )
            }

            Text(
                text = name,
                modifier = Modifier.padding(12.dp)
            )
        }

        DropdownMenu(expanded = expanded.value, onDismissRequest = { expanded.value = false }) {

            DropdownMenuItem(onClick = {
                expanded.value = false
            }) {
                Text("Albedo")
            }

            DropdownMenuItem(onClick = {
                expanded.value = false
            }) {
                Text("Amber")
            }

            DropdownMenuItem(onClick = {
                expanded.value = false
            }) {
                Text("Barbra")
            }

            DropdownMenuItem(onClick = {
                expanded.value = false
                id = R.drawable.img
                name = "Ningguang"
            }) {
                Text("Ningguang")
            }
        }
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally,
           modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(id),
            contentDescription = "Character Image",
            modifier = Modifier
                .size(300.dp)
                .clip(CircleShape)
        )

        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Text(name, fontSize = 40.sp)

            Spacer(modifier = Modifier.height(5.dp))

            Row(horizontalArrangement = Arrangement.Center) {

                Image(
                    painter = painterResource(R.drawable.ic_launcher_background),
                    contentDescription = "Weapon Image",
                    modifier = Modifier
                        .size(100.dp)
                        .padding(end = 40.dp)
                )

                Image(
                    painter = painterResource(R.drawable.ic_launcher_background),
                    contentDescription = "Vision Image",
                    modifier = Modifier
                        .size(100.dp)
                        .padding(start = 40.dp)
                )
            }
        }
    }

    Column(modifier = Modifier.padding(start = 10.dp)) {
        Text(text = "gem")
        Text(text = "environment")
        Text(text = "common")
        Text(text = "boss")
    }

}