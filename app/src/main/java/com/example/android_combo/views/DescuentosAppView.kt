package com.example.navegacion.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.runtime.*


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EntradaTextoView() {
    var num1: String by remember { mutableStateOf("") }
    var num2: String by remember { mutableStateOf("") }
    var descuento: String by remember { mutableStateOf("") }
    var resultado: String by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        OutlinedTextField(
            value = num1,
            onValueChange = { num1 = it },
            label = { Text("Precio") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = num2,
            onValueChange = { num2 = it },
            label = { Text("Descuento") },
            modifier = Modifier.fillMaxWidth()
        )

        val interactionSource = remember { MutableInteractionSource() }

        Button(
            onClick = {
                val n1 = num1.toDoubleOrNull() ?: 0.0
                val n2 = num2.toDoubleOrNull() ?: 0.0
                val desc = n1 * (n2 * 0.01)
                val total = n1 - desc
                descuento = desc.toString()
                resultado = total.toString()
            },
            modifier = Modifier.padding(top = 16.dp),
            interactionSource = interactionSource
        ) {
            Text("Calcular")
        }

        Button(
            onClick = {
                num1 = ""
                num2 = ""
                descuento = ""
                resultado = ""
            },
            modifier = Modifier.padding(top = 16.dp),
            interactionSource = interactionSource
        ) {
            Text("Limpiar")
        }


        OutlinedTextField(
            value = descuento,
            onValueChange = { },
            label = { Text("Descuento") },
            readOnly = true,
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = resultado,
            onValueChange = { },
            label = { Text("Total") },
            readOnly = true,
            modifier = Modifier.fillMaxWidth()
        )
    }
}
