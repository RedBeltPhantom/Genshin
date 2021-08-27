package com.revature.genshin.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.revature.genshin.database.*
import com.revature.genshin.defaultMessage

@Preview
@Composable
fun preview()
{
    InventoryScreen(navController = rememberNavController())
}

@Composable
fun InventoryScreen(navController: NavHostController) {

    var itemsCommonMaterialLow:ArrayList<Common_Material_Low> = ArrayList()
    for(x in Common_Material_Low.values())
        itemsCommonMaterialLow.add(x)

    var itemsCommonMaterialMid:ArrayList<Common_Material_Mid> = ArrayList()
    for(x in Common_Material_Mid.values())
        itemsCommonMaterialMid.add(x)

    var itemsCommonMaterialHigh:ArrayList<Common_Material_High> = ArrayList()
    for(x in Common_Material_High.values())
        itemsCommonMaterialHigh.add(x)

    var itemsBossMaterial:ArrayList<Boss_Material> = ArrayList()
    for(x in Boss_Material.values())
        itemsBossMaterial.add(x)

    var itemsLocal_Specialty:ArrayList<Local_Specialty> = ArrayList()
    for(x in Local_Specialty.values())
        itemsLocal_Specialty.add(x)

    var itemsElemental_Stone_Material:ArrayList<String> = ArrayList()
    for(x in Elemental_Stone_Material.values())
    {
        for(y in Elemental_Stone_Size.values())
            itemsElemental_Stone_Material.add(""+x+" "+y)
    }

    Column(modifier = Modifier
        .background(MaterialTheme.colors.background)
        .fillMaxWidth()
//        .height(300.dp)
    ) {
        defaultMessage(msg = "Welcome to The Inventory Screen!")
        for(arrRef in arrayOf(itemsCommonMaterialLow, itemsCommonMaterialMid,
            itemsCommonMaterialHigh, itemsBossMaterial, itemsLocal_Specialty))
        {
            Column(modifier = Modifier.padding(4.dp)) {
                Text("Choose a material")

                var selected by remember { mutableStateOf(0) }
                var expandedVar by remember { mutableStateOf(false) }
                Row() {
                    Box(modifier = Modifier) {
                        Text(arrRef[selected].name,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable(onClick = { expandedVar = true })
                        )
                        DropdownMenu(
                            expanded = expandedVar,
                            onDismissRequest = { expandedVar = false }) {
                            arrRef.forEachIndexed { index, material ->
                                DropdownMenuItem(onClick = {
                                    selected = index
                                    expandedVar = false
                                }) {
                                    Text(text = material.name)
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.padding(horizontal = 6.dp))
                }
                Row()
                {
                    var value by remember{ mutableStateOf(0)}
                    Box(Modifier.border(2.dp, Color.Black, shape = MaterialTheme.shapes.medium )){
                        ClickableText(text = AnnotatedString("minus"),
                            onClick = {if(value>0)value--},
                            modifier = Modifier.padding(3.dp))
                    }

                    Spacer(modifier = Modifier.padding(horizontal = 6.dp))
                    Box(Modifier.border(2.dp, Color.Black , shape = MaterialTheme.shapes.medium)) {
                        Text(
                            text = value.toString(),
                            modifier = Modifier.padding(3.dp)
                        )
                    }
                    Spacer(modifier = Modifier.padding(horizontal = 6.dp))
                    Box(Modifier.border(2.dp, Color.Black , shape = MaterialTheme.shapes.medium)) {
                        ClickableText(
                            text = AnnotatedString("plus"), onClick = { value++ },
                            modifier = Modifier.padding(3.dp)
                        )
                    }
                }
            }
        }
        Column(modifier = Modifier.padding(4.dp)) {
            Text("Choose a material")
            Spacer(modifier = Modifier.padding(horizontal = 6.dp))
            var selected by remember { mutableStateOf(0) }
            var expandedVar by remember { mutableStateOf(false) }
            Row(){
                Box(modifier = Modifier) {
                    Text(itemsElemental_Stone_Material[selected],
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable(onClick = { expandedVar = true })
                    )
                    DropdownMenu(
                        expanded = expandedVar,
                        onDismissRequest = { expandedVar = false }) {
                        itemsElemental_Stone_Material.forEachIndexed { index, material ->
                            DropdownMenuItem(onClick = {
                                selected = index
                                expandedVar = false
                            }) {
                                Text(text = material)
                            }
                        }
                    }
                }
              // Spacer(modifier = Modifier.padding(horizontal = 6.dp))
            }
            Row()
            {
                var value by remember{ mutableStateOf(0)}
                Box(Modifier.border(2.dp, Color.Black, shape = MaterialTheme.shapes.medium )){
                    ClickableText(text = AnnotatedString("minus"),
                        onClick = {if(value>0)value--},
                        modifier = Modifier.padding(3.dp))
                }

                Spacer(modifier = Modifier.padding(horizontal = 6.dp))
                Box(Modifier.border(2.dp, Color.Black , shape = MaterialTheme.shapes.medium)) {
                    Text(
                        text = value.toString(),
                        modifier = Modifier.padding(3.dp)
                    )
                }
                Spacer(modifier = Modifier.padding(horizontal = 6.dp))
                Box(Modifier.border(2.dp, Color.Black , shape = MaterialTheme.shapes.medium)) {
                    ClickableText(
                        text = AnnotatedString("plus"), onClick = { value++ },
                        modifier = Modifier.padding(3.dp)
                    )
                }
            }

        }
    }
}