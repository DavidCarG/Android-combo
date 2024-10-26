package com.example.navegacion.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.foundation.interaction.MutableInteractionSource
import com.example.android_combo.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnosPerrunosView() {
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var edad = remember { mutableStateOf("") }
        var resultado = remember { mutableStateOf("") }

        Image(
            painter = painterResource(id = R.drawable.borzoi),
            contentDescription = null,
            contentScale = ContentScale.FillHeight
        )

        Text(text = "Mis Años Perrunos", modifier = Modifier.padding(16.dp))

        OutlinedTextField(
            value = edad.value,
            onValueChange = { edad.value = it },
            label = { Text("Mi edad humana") }
        )

        ElevatedButton(
            onClick = {
                val res = edad.value.toIntOrNull()?.times(7) ?: 0
                resultado.value = res.toString()
            },
            interactionSource = remember { MutableInteractionSource() } // Explicitly specify interactionSource
        ) {
            Text("Calcular")
        }

        OutlinedTextField(
            value = resultado.value,
            onValueChange = {},
            label = { Text("Edad Perruna") },
            readOnly = true
        )
    }
}
