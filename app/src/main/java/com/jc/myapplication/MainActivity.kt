package com.jc.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            multipleSelection() 
        }
    }
}

@Composable
fun  multipleSelection(){
    var listData by remember {
        mutableStateOf(
            (1..20).map { it ->
                listItemData(
                    title = "item ${it.toString()}",
                    isSelected = false,
                    color = Color.White
                )
            }
        )
    }
    
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.DarkGray)){
       items(listData.size){ i ->
           Row(modifier = Modifier
               .fillMaxWidth()
               .background(color = listData[i].color)
               .clickable {
                   listData = listData.mapIndexed { index, listItemData ->
                       if(i == index){
                           var newColor = if(listItemData.color == Color.White){
                               Color.Yellow
                           }else{
                               Color.White
                           }

                           listItemData.copy(
                               isSelected = !listItemData.isSelected,
                               color = newColor
                           )
                       }else{
                           listItemData
                       }
                   }
               },
               verticalAlignment = Alignment.CenterVertically,
               horizontalArrangement = Arrangement.SpaceBetween
               ) {
               Text(text = listData[i].title,
                   Modifier.padding(16.dp),
                   style = TextStyle(
                       fontWeight = FontWeight.Bold,
                       fontSize = 20.sp
                   ))

               if(listData[i].isSelected){
                   Icon(imageVector = Icons.Default.Check, contentDescription = "")
               }
           }
           
           Spacer(modifier = Modifier.height(10.dp))
       }
    }
}
