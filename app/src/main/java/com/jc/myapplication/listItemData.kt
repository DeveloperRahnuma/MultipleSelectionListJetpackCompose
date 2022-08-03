package com.jc.myapplication

import androidx.compose.ui.graphics.Color

data class listItemData(
    var title : String = "",
    var isSelected : Boolean = false,
    var color: Color = Color.White
)
