package com.organizely.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.organizely.app.ui.theme.OrganizelyTheme

class AuthSignUp : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OrganizelyTheme {
                PagePreview()
            }
        }
    }

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
            Text("Email", fontSize = 17.sp, color = colorResource(R.color.white))
            Spacing(13)
            TextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("") },
                shape = RoundedCornerShape(12.dp),
                supportingText = {
                    if (isEmpty) {
                        Text("Empty fields")
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
            )
            Text("Password", fontSize = 17.sp, color = colorResource(R.color.white))
            Spacing(13)
            TextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("") },
                shape = RoundedCornerShape(12.dp),
                supportingText = {
                    if (isEmpty) { Text("Empty fields") }
                },
                modifier = Modifier
                    .fillMaxWidth()
            )
            Text("Retype password", fontSize = 17.sp, color = colorResource(R.color.white))
            Spacing(13)
            TextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("") },
                shape = RoundedCornerShape(12.dp),
                supportingText = { if (isEmpty) {
                        Text("Empty fields") }
                },
                modifier = Modifier.fillMaxWidth()
            )
        }
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