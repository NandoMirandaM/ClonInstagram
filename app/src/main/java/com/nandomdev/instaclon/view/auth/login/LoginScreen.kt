package com.nandomdev.instaclon.view.auth.login

import androidx.compose.foundation.BorderStroke
import com.nandomdev.instaclon.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Preview
@Composable
fun LoginScreen(loginViewModel: LoginViewModel = viewModel()) {
    val uiState by loginViewModel.uiState.collectAsStateWithLifecycle()

    Scaffold { padding ->
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(padding)
                .padding(horizontal = 24.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Español(México)",
                modifier = Modifier.padding(vertical = 20.dp),
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(modifier = Modifier.weight(1f))
            Image(
                modifier = Modifier.size(60.dp),
                painter = painterResource(R.drawable.instaclon_logo),
                contentDescription = "InstaClon Logo"
            )
            Spacer(modifier = Modifier.weight(1f))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(30.dp),
                label = {
                    Text(
                        text = "Usuario, correo electrónico o móvil",
                        color = MaterialTheme.colorScheme.onBackground
                    )
                },
                value = uiState.email,
                onValueChange = { loginViewModel.onEmailChanged(email = it) }
            )
            Spacer(modifier = Modifier.height(12.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(30.dp),
                label = {
                    Text(
                        text = "Contraseña",
                        color = MaterialTheme.colorScheme.onBackground
                    )
                },
                value = uiState.password,
                onValueChange = { loginViewModel.onPasswordChanged(password = it) }
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                onClick = {},
                enabled = uiState.isLoginEnabled
            ) {
                Text(
                    modifier = Modifier.padding(4.dp),
                    text = "Iniciar sesión",
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
            TextButton(onClick = {}) {
                Text(
                    "¿Has olvidado la contraseña?",
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Spacer(modifier = Modifier.weight(1.5f))
            OutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
                onClick = {}) {
                Text(
                    text = "Crear cuenta nueva",
                    color = MaterialTheme.colorScheme.primary
                )
            }
            Icon(
                modifier = Modifier
                    .width(65.dp)
                    .padding(vertical = 20.dp),
                painter = painterResource(R.drawable.ic_meta),
                contentDescription = "InstaClon Logo",
                tint = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}