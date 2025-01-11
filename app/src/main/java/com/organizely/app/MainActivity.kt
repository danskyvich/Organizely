package com.organizely.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GoogleButton()
        }
    }
}

@Preview
@Composable
fun PagePreview() {
    GoogleButton()
}

@Composable
fun GoogleButton() {
    Button(
    onClick = { /* TODO */ },
    modifier = Modifier) {
        Row (
            horizontalArrangement = Arrangement.Absolute.Center
        ) {
            Image(painter = painterResource(R.drawable.google), contentDescription = stringResource(R.string.google_desc))
            Column {
                ButtonText("Google")
            }
        }
    }
}

@Composable
fun ButtonText(socialMedia: String) {
    Text("Continue with $socialMedia")
}