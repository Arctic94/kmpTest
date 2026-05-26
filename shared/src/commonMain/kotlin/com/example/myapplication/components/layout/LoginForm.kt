package com.example.myapplication.components.layout

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.input.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// 1. Definimos nuestro "Form Controller" (como un FormGroup de Angular)
class LoginFormState {
    val username = TextFieldState()
    val password = TextFieldState()

    // --- Transformaciones (Interceptores de entrada) ---
    
    // Filtramos manualmente los números para que no se puedan ni escribir ni pegar
    val usernameFilter = InputTransformation {
        // 'asCharSequence()' nos da el texto que se intenta ingresar
        val text = asCharSequence()
        for (i in text.length - 1 downTo 0) {
            if (text[i].isDigit()) {
                delete(i, i + 1) // Eliminamos el carácter si es un número
            }
        }
    }

    // Validaciones (Equivalente a Validators)
    val usernameError: String? by derivedStateOf {
        val text = username.text.toString()
        when {
            text.isEmpty() -> "El usuario es obligatorio"
            // El filtro ya garantiza que no hay números, así que la validación es más limpia
            else -> null
        }
    }

    val passwordError: String? by derivedStateOf {
        val text = password.text.toString()
        when {
            text.length < 6 -> "Mínimo 6 caracteres"
            else -> null
        }
    }

    // Estado para controlar cuándo mostrar errores (como el 'submitted' de Angular)
    var showErrors by mutableStateOf(false)

    val isValid by derivedStateOf { usernameError == null && passwordError == null }
}

@Composable
fun ReactiveLoginPage() {
    val form = remember { LoginFormState() }

    Column(
        Modifier
            .safeContentPadding()
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        // --- Input Usuario ---
        OutlinedTextField(
            state = form.username,
            // Aplicamos la transformación aquí
            inputTransformation = form.usernameFilter,
            label = { Text("Usuario (letras solamente)") },
            modifier = Modifier.fillMaxWidth(),
            isError = form.showErrors && form.usernameError != null,
            supportingText = {
                if (form.showErrors) {
                    form.usernameError?.let { Text(it) }
                }
            }
        )

        Spacer(Modifier.height(8.dp))

        // --- Input Password ---
        SecureTextField(
            state = form.password,
            label = { Text("Contraseña (6+ caracteres)") },
            modifier = Modifier.fillMaxWidth(),
            isError = form.showErrors && form.passwordError != null,
            supportingText = {
                if (form.showErrors) {
                    form.passwordError?.let { Text(it) }
                }
            }
        )

        Spacer(Modifier.height(24.dp))

        // --- Botón Submit ---
        Button(
            onClick = {
                form.showErrors = true // Marcamos como "touched/submitted"
                if (form.isValid) {
                    println("Enviando: ${form.username.text}")
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Enviar")
        }
    }
}
