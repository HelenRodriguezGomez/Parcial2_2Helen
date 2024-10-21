package com.example.parcial2.SCREENS

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MainMenuScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Menú Principal", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))

        // Botón para ir a la pantalla de Miembros
        Button(
            onClick = { navController.navigate("miembros") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Gestionar Miembros")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botón para ir a la pantalla de Autores
        Button(
            onClick = { navController.navigate("autores") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Gestionar Autores")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botón para ir a la pantalla de Libros
        Button(
            onClick = { navController.navigate("libros") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Gestionar Libros")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botón para ir a la pantalla de Préstamos
        Button(
            onClick = { navController.navigate("prestamos") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Gestionar Préstamos")
        }
    }
}
