package com.example.parcial2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navController = rememberNavController()
            NavHost(navController = navController, startDestination = "menu") {
                composable("menu") { MenuScreen(navController) }
                composable("autores") { AutoresScreen() }
                composable("miembros") { MiembrosScreen() }
                composable("libros") { LibrosScreen() }
                composable("prestamos") { PrestamosScreen() }
            }
        }
    }
}

@Composable
fun MenuScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Seleccione una opción:")

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = { navController.navigate("autores") }) {
            Text(text = "Autores")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = { navController.navigate("miembros") }) {
            Text(text = "Miembros")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = { navController.navigate("libros") }) {
            Text(text = "Libros")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = { navController.navigate("prestamos") }) {
            Text(text = "Préstamos")
        }
    }
}

@Composable
fun AutoresScreen() {
    var autores by remember { mutableStateOf(mutableListOf<String>()) }
    var nuevoAutor by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(text = "Lista de Autores")

        Spacer(modifier = Modifier.height(20.dp))

        // Campo de texto para añadir un nuevo autor
        TextField(
            value = nuevoAutor,
            onValueChange = { nuevoAutor = it },
            label = { Text("Añadir Autor") }
        )

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = {
            if (nuevoAutor.isNotEmpty()) {
                autores.add(nuevoAutor)
                nuevoAutor = ""
            }
        }) {
            Text(text = "Añadir")
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Listar los autores
        for ((index, autor) in autores.withIndex()) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = autor)
                Button(onClick = { autores.removeAt(index) }) {
                    Text(text = "Eliminar")
                }
            }
        }
    }
}

@Composable
fun MiembrosScreen() {
    // Implementa funcionalidades para miembros aquí
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Lista de Miembros")
        // Similar a AutoresScreen
    }
}

@Composable
fun LibrosScreen() {
    // Implementa funcionalidades para libros aquí
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Lista de Libros")
        // Similar a AutoresScreen
    }
}

@Composable
fun PrestamosScreen() {
    // Implementa funcionalidades para préstamos aquí
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Lista de Préstamos")
        // Similar a AutoresScreen
    }
}
