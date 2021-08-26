package com.revature.genshin.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.revature.genshin.R

@Composable
fun CharacterScreen(navController: NavHostController) {
    Column(modifier = Modifier
        .background(MaterialTheme.colors.background)
        .fillMaxWidth()
//        .height(300.dp)
    ) {

        CharacterSelect(Materials("Basalt Pillar", "Scrolls","Cecilia", "Prithiva Topaz"))
    }
}

var id = R.drawable.ic_launcher_foreground

data class Materials(val boss:String, val common:String, val environment:String, val gem:String)

@Composable
fun CharacterSelect(mat:Materials) {

    val expanded = remember { mutableStateOf(false) }

    Box(
        Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.TopStart)
    ) {
        IconButton(onClick = { expanded.value = true }) {
            Icon(
                Icons.Filled.MoreVert,
                contentDescription = "Character"
            )
        }
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
        }) {
            Text("Ningguang")
        }
    }

    Row (verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(all = 8.dp)){

        Image(
            painter = painterResource(id),
            contentDescription = "Character Image",
            modifier = Modifier
                .size(160.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column(verticalArrangement = Arrangement.Center) {
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "name")
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "weapon")
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "vision")
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = mat.gem)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = mat.environment)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = mat.common)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = mat.boss)
        }
    }
}