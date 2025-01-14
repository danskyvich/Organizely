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
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.organizely.app.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class AuthEmailVefCode : ComponentActivity() {

    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun PageContent() {
        var timer by rememberSaveable { mutableIntStateOf(0)}

        Row(
            Modifier
                .background(colorResource(R.color.auth_bg))
                .fillMaxSize()
                .padding(30.dp, 30.dp, 30.dp, 40.dp)

        ) {
            Column(Modifier.fillMaxWidth()) {

                Row(Modifier.fillMaxWidth().weight(1f)) {}

                Column(Modifier.fillMaxWidth()) {
                    Text("The verification email has been sent", fontSize = 35.sp, color = colorResource(
                        R.color.white
                    ))
                    Spacer(Modifier.height(5.dp))
                    Text("Please input the verification code below.", fontSize = 19.sp, color = colorResource(
                        R.color.white
                    ))
                    Spacer(Modifier.height(10.dp))
                    CodeField(isEmpty = false)
                }

                Column(Modifier.fillMaxWidth()) {
                    Text("$timer", fontSize = 15.sp, color = colorResource(R.color.white),
                        modifier = Modifier.align(Alignment.CenterHorizontally))
                    Spacer(Modifier.height(7.dp))
                    Text("Resend code", fontSize = 15.sp, color = colorResource(R.color.white),
                        modifier = Modifier.align(Alignment.CenterHorizontally))
                }
                LaunchedEffect(Unit) {
                    launch {
                        while(true) {
                            delay(1_000)
                            timer++
                        }
                    }
                }

                Row(Modifier.fillMaxWidth().weight(1f)) {}

                Row(Modifier.fillMaxWidth()) {
                    VerifyButton()
                }
            }
        }
    }

    @Composable
    fun CodeField(isEmpty: Boolean) {
        var text by remember { mutableStateOf("")}

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
    }

    @Composable
    fun VerifyButton() {
        Button(
            onClick = { /*TODO*/},
            colors = ButtonDefaults.buttonColors(colorResource(R.color.yellow)),
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
        ) {
            Text("Verify", fontSize = 19.sp, color = colorResource(R.color.black))
        }
    }
}