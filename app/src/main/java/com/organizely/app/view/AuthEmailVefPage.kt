package com.organizely.app.view

import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.organizely.app.R

class AuthEmailVefPage : ComponentActivity() {

    @Preview(showSystemUi = true, showBackground = true)
    @Composable
    fun PageContent() {
        Row(Modifier
            .background(colorResource(R.color.auth_bg))
            .padding(30.dp, 30.dp, 30.dp, 40.dp)
            .fillMaxSize()
        ) {
            Column(
                Modifier.fillMaxSize()
            ) {
                Row(Modifier.fillMaxWidth().weight(1f)) {}

                Image(
                    painter = painterResource(R.drawable.vector_email_vef),
                    contentDescription = "Email image",
                    modifier = Modifier.size(250.dp)
                        .align(Alignment.CenterHorizontally))
                Column() {
                    Text("YOU ARE ONE STEP AWAY", fontSize = 13.sp, color = colorResource(R.color.white))
                    Text("Verify your Email", fontSize = 45.sp, color = colorResource(R.color.white))
                    Text("In order to verify the authenticity of your account, please verify the email that you had chosen.", fontSize = 19.sp, color = colorResource(
                        R.color.white
                    ))
                }

                Row(Modifier.fillMaxWidth().weight(1f)) {}

                Row() {
                    ContinueButton()
                }
            }
        }
    }

    @Composable
    fun ContinueButton() {
        Button(
            onClick = {/*TODO*/},
            colors = ButtonDefaults.buttonColors(colorResource(R.color.yellow)),
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
        ) {
            Text("Continue", fontSize = 19.sp, color = colorResource(R.color.black))
        }
    }
}