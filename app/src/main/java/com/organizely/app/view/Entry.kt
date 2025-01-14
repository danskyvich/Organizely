package com.organizely.app.view

import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.organizely.app.R

class Entry : ComponentActivity() {

    private val imageModifier = Modifier
        .size(30.dp, 30.dp)

    @Preview(showSystemUi = true)
    @Composable
    fun MainPageContent() {
        Row (
            Modifier
                .background(color = colorResource(R.color.auth_bg))
                .padding(30.dp, 40.dp, 30.dp, 40.dp)
        ){
            Column (Modifier.fillMaxWidth()) {
                Row (Modifier.fillMaxWidth().weight(1f)) {
                    Spacer(Modifier.weight(1f))
                }
                Row (Modifier.fillMaxWidth().fillMaxWidth()){
                    FrontHeading()
                }
                Column (modifier = Modifier.fillMaxWidth())
                {
                    Spacing(20)
                    GoogleButton()
                    Spacing(20)
                    FbButton()
                    Spacing(20)
                    BorderUI(15, R.color.white)
                    Spacing(20)
                    EmailPasswordColumn()
                    BottomPageCreateAccount()
                    Spacing(20)
                }
            }
        }
    }

    @Composable
    fun FrontHeading() {
        Column () {
            Text("List it.", fontSize = 40.sp, color = colorResource(R.color.white))
            Spacing(5)
            Text("Track it.", fontSize = 45.sp, color = colorResource(R.color.white))
            Spacing(5)
            Text("Organizely.", fontSize = 50.sp, color = colorResource(R.color.white))
        }
    }

    @Composable
    fun Spacing(space: Int) {
        Spacer(modifier = Modifier
            .height(space.dp))
    }

    @Composable
    fun GoogleButton() {
        Button(
            onClick = {/* TODO */ },
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.white)),
            modifier = Modifier
                .layoutId("btnGoogle")
                .fillMaxWidth()
                .height(60.dp)
        ) {
            Row (
                horizontalArrangement = Arrangement.Absolute.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.icon_google),
                    contentDescription = stringResource(R.string.google_desc),
                    alignment = Alignment.CenterStart,
                    modifier = imageModifier
                )
                Column {
                    ButtonText(stringResource(R.string.google), R.color.black)
                }
            }
        }
    }

    @Composable
    fun FbButton() {
        Button(
            onClick = {/* TODO */ },
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.fb_blue)),
            modifier = Modifier
                .layoutId("btnFb")
                .fillMaxWidth()
                .height(60.dp)
        ) {
            Row (
                horizontalArrangement = Arrangement.Absolute.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.icon_facebook),
                    contentDescription = stringResource(R.string.google_desc),
                    alignment = Alignment.CenterStart,
                    modifier = imageModifier
                )
                Column {
                    ButtonText(stringResource(R.string.facebook), R.color.white)
                }
            }
        }
    }

    @Composable
    fun ButtonText(string: String, color: Int) {
        Text(string,
            fontSize = 17.sp,
            color = colorResource(color),
            textAlign = TextAlign.Start,
            modifier = Modifier
                .padding(5.dp,0.dp)
                .height(30.dp)
                .wrapContentHeight(align = Alignment.CenterVertically))
    }

    @Composable
    fun BorderUI(size: Int, colorTr: Int) {
        Text("Or log in using your email account",
            fontSize = size.sp,
            color = colorResource(colorTr),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
        )
    }

    @Composable
    fun PasswordTextField(isEmpty: Boolean) {
        var password by remember { mutableStateOf("") }
        var passwordVisible by remember { mutableStateOf(false) }

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("") },
            placeholder = { Text(stringResource(R.string.password)) },
            shape = RoundedCornerShape(12.dp),
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedTextColor = Color.White,
                unfocusedBorderColor = Color.White,
                focusedTextColor = Color.White,
                focusedBorderColor = Color.White
            ),
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
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
    fun EmailTextField(isEmpty : Boolean) {
        var text by remember { mutableStateOf("") }

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("") },
            placeholder = { Text(stringResource(R.string.email)) },
            shape = RoundedCornerShape(12.dp),
            singleLine = true,
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
    fun EmailPasswordColumn(isEmpty: Boolean = false, isEnabled: Boolean = true) {
        var text by remember { mutableStateOf("") }
        var textVisible by remember { mutableStateOf(false) }

        Column (modifier = Modifier) {
            EmailTextField(isEmpty = false)
            Spacing(8)
            PasswordTextField(isEmpty = false)
        }
    }

    @Composable
    fun BottomPageCreateAccount() {
        Row (
            Modifier.fillMaxWidth()
        ) {
            Row(Modifier.fillMaxWidth().weight(1f)) {}

            Text("Don't have an account?",
                fontSize = 15.sp,
                color = colorResource(R.color.white),
                textAlign = TextAlign.Center)

            Text("Create Account",
                fontSize = 15.sp,
                color = colorResource(R.color.yellow),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(10.dp, 0.dp))

            Row(Modifier.fillMaxWidth().weight(1f)) {}

        }
    }
}