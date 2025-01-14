package com.organizely.app.view

import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.organizely.app.R

class AuthSignUp : ComponentActivity() {

    @Preview(showSystemUi = true, showBackground = true)
    @Composable
    fun PagePreview() {
        Row (Modifier.background(colorResource(R.color.auth_bg))
            .fillMaxSize()
            .padding(30.dp, 40.dp, 30.dp, 40.dp)) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            )   {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()) {

                        Heading("Sign Up")
                        Spacing(20)
                        Form()
                        }

                        Row (Modifier.fillMaxWidth().weight(1f)) {}

                        Row (Modifier.fillMaxWidth())
                        {
                        ContinueButton()
                    }
                }
            }
    }

    @Composable
    fun Spacing(int: Int) {
        Spacer(modifier = Modifier
            .height(int.dp))
    }

    @Composable
    fun Heading(heading: String) {
        Text(heading, fontSize = 45.sp, color = colorResource(R.color.white))
    }

    @Composable
    fun Form(isEmpty: Boolean = false) {
        var text by remember { mutableStateOf("") }

        Column (
        ) {
            Text(stringResource(R.string.email), fontSize = 17.sp, color = colorResource(R.color.white))
            Spacing(13)
            EmailField(isEmpty = false)
            Text(stringResource(R.string.password), fontSize = 17.sp, color = colorResource(R.color.white))
            Spacing(13)
            PasswordField(isEmpty = false)
            Text("Retype password", fontSize = 17.sp, color = colorResource(R.color.white))
            Spacing(13)
            RetypeField(isEmpty = false)
        }
    }

    @Composable
    fun EmailField(isEmpty: Boolean) {
        var text by remember { mutableStateOf("")}

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("") },
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedTextColor = Color.White,
                unfocusedBorderColor = Color.White,
                focusedTextColor = Color.White,
                focusedBorderColor = Color.White
            ),
            supportingText = {
                if (isEmpty) {
                    Text("Empty fields")
                }
            },
            modifier = Modifier
                .fillMaxWidth()
        )
    }

    @Composable
    fun PasswordField(isEmpty: Boolean) {
        var text by remember { mutableStateOf("")}
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("") },
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedTextColor = Color.White,
                unfocusedBorderColor = Color.White,
                focusedTextColor = Color.White,
                focusedBorderColor = Color.White
            ),
            supportingText = {
                if (isEmpty) {
                    Text("Empty fields")
                }
            },
            modifier = Modifier
                .fillMaxWidth()
        )
    }

    @Composable
    fun RetypeField(isEmpty: Boolean) {
        var text by remember {mutableStateOf("")}
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("") },
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedTextColor = Color.White,
                unfocusedBorderColor = Color.White,
                focusedTextColor = Color.White,
                focusedBorderColor = Color.White
            ),
            supportingText = {
                if (isEmpty) {
                    Text("Empty fields")
                }
            },
            modifier = Modifier
                .fillMaxWidth()
        )
    }

    @Composable
    fun ContinueButton() {
        Button(
            onClick = { /*TODO*/},
            colors = ButtonDefaults.buttonColors(colorResource(R.color.yellow)),
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp))
        {
            Text("Continue", color = colorResource(R.color.black), textAlign = TextAlign.Center, fontSize = 19.sp)
        }
    }
}