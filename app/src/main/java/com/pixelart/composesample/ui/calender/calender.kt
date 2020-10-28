package com.pixelart.composesample.ui.calender

import androidx.compose.foundation.Text
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.ui.tooling.preview.Preview
import com.pixelart.composesample.ui.theme.ComposeSampleTheme

@Composable
fun Calender(navController: NavHostController) {
    Surface(color = MaterialTheme.colors.surface) {
        Text(text = "Welcome to Calender Screen", fontSize = 24.sp)
    }
}

@Preview(showBackground = true)
@Composable
private fun preview(){
    val navController = rememberNavController()
    ComposeSampleTheme {
        Scaffold() {
            Calender(navController)
        }
    }
}