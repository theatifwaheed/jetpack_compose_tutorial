package com.fluxpert.jetpack_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fluxpert.jetpack_compose.ui.theme.Jetpack_composeTheme

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Jetpack_composeTheme {
//        Greeting("Atif", "Android")
        ComposeArticle(
            image = painterResource(R.drawable.bg_compose_background),
            title = "Jetpack Compose Tutorial",
            paragraphs = listOf(
                "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.",
                "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app\\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\\'s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name.",
            ),
        )
    }
}

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
                    ComposeArticle(
                        image = painterResource(R.drawable.bg_compose_background),
                        title = "Jetpack Compose Tutorial",
                        paragraphs = listOf(
                            "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.",
                            "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app\\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\\'s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name.",
                        ),
                    )
//                    Greeting(
//                        message = "XYZ", from = "Atif"
//                    )
                }
            }
        }
    }
}

@Composable
fun ComposeArticle(
    image: Painter, title: String, paragraphs: List<String>, modifier: Modifier = Modifier
) {
    val textModifier: Modifier = Modifier
        .padding(
            start = 16.dp, top = 10.dp, end = 16.dp
        )
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Top,
    ) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
        )
        XTitle(title = title, modifier = textModifier)
        paragraphs.map { pg ->
            XParagraph(message = pg, modifier = textModifier)
        }
    }
}

@Composable
fun XTitle(title: String, modifier: Modifier) {
    Text(
        text = title,
        fontSize = 20.sp,
        color = Color.Black,
        textAlign = TextAlign.Center,
        modifier = modifier
    )
}

@Composable
fun XParagraph(message: String, modifier: Modifier) {
    Text(
        text = message,
        fontSize = 12.sp,
        color = Color.Black,
        textAlign = TextAlign.Justify,
        modifier = modifier
    )
}

//@Composable
//fun Greeting(message: String, from: String, modifier: Modifier = Modifier) {
//    val image = painterResource(R.drawable.androidparty)
//
//    Box(modifier) {
//        Image(
//            painter = image,
//            contentDescription = null,
//            contentScale = ContentScale.Crop,
//            alpha = 0.5F,
//        )
//        GreetingText(
//            message = message, from = from,
//            /// Can Also do this
////            modifier = Modifier.padding(
////                start = 16.dp,
////                top = 16.dp,
////                end = 16.dp,
////                bottom = 16.dp,
////            )
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(
//                    50.dp
//                )
//
//        )
//    }
//
//}

//@Composable
//fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
//    Column(
//        modifier = modifier,
//        verticalArrangement = Arrangement.Center,
//    ) {
//        Text(
//            text = stringResource(R.string.happy_birthday_string, message),
//            fontSize = 80.sp,
//            lineHeight = 100.sp,
//            textAlign = TextAlign.Center,
//        )
//        Text(
//            text = stringResource(R.string.from_text, from),
//            fontSize = 36.sp,
//            modifier = Modifier
//                .padding(16.dp)
//                .align(alignment = Alignment.End)
//        )
//    }
//}


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