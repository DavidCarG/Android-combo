package com.example.android_combo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.android_combo.ui.theme.AndroidcomboTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.android_combo.components.homeComponents.MiddleButtons
import com.example.navegacion.views.AnosPerrunosView
import com.example.navegacion.views.EntradaTextoView
import com.example.navegacion.views.LoteriaView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidcomboTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun TopBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Cyan)
            .height(56.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Android combo!",
            color = Color.Black,
            style = MaterialTheme.typography.titleLarge
        )
    }
}

@Composable
fun BottomRightButton(navController: NavController) {
    FloatingActionButton(
        onClick = { navController.navigate("home") },
        modifier = Modifier.padding(16.dp)
    ) {
        Icon(Icons.Filled.Home, contentDescription = "Home")
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        topBar = { TopBar() },
        floatingActionButton = { BottomRightButton(navController) },
        floatingActionButtonPosition = FabPosition.End
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            NavHost(navController, startDestination = "home") {
                composable("home") { MiddleButtons(navController) }
                composable("dogs") { AnosPerrunosView() }
                composable("discount") { EntradaTextoView() }
                composable("lottery") { LoteriaView() }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    AndroidcomboTheme {
        MainScreen()
    }
}