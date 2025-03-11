package com.fluxpert.jetpack_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fluxpert.jetpack_compose.ui.theme.Jetpack_composeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Jetpack_composeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Greeting(
                        message = "XYZ", from = "Atif"
                    )
                }
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
            }
        }
    }
}

@Composable
fun Greeting(message: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.androidparty)

    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F,
        )
        GreetingText(
            message = message, from = from,
            /// Can Also do this
//            modifier = Modifier.padding(
//                start = 16.dp,
//                top = 16.dp,
//                end = 16.dp,
//                bottom = 16.dp,
//            )
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    50.dp
                )

        )
    }

}

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = stringResource(R.string.happy_birthday_string, message),
            fontSize = 80.sp,
            lineHeight = 100.sp,
            textAlign = TextAlign.Center,
        )
        Text(
            text = stringResource(R.string.from_text, from),
            fontSize = 36.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.End)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Jetpack_composeTheme {
        Greeting("Atif", "Android")
    }
}


/// Just programming code for learning.
//fun main() {
//    val count: Int = 2
//    println("Value is: $count")
//    var nullable: Int?= null
//    var nullable2: Int?= null
//    println("nullable is $nullable")
//    nullable = nullable2 ?: 201
//    println("nullable updated to $nullable")
//    println(myFunction("Atif", nullable))
//}
//
//fun myFunction(name: String, age: Int = 20): String?{
//    if(age > 100){
//        return null
//    }
//    var ageS: String = "s"
//    if(age < 2 && age > -1){
//        ageS = ""
//    } else{
//        ageS = "(s)"
//    }
//    return "Hello $name, you're $age year$ageS old";
//}