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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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

class QuadrantModel {
    var title: String = ""
    var description: String = ""
    var color: Color = Color.Red

    constructor(title: String, description: String, color: Color = Color.Red) {
        this.title = title
        this.description = description
        this.color = color
    }
}

val quadrantModelList: List<QuadrantModel> = listOf(
    QuadrantModel(
        title = "Text composable",
        description = "Displays text and follows the recommended Material Design guidelines",
        color = Color(0xFFEADDFF),
    ),
    QuadrantModel(
        title = "Image composable",
        description = "Creates a composable that lays out and draws a given Painter class object",
        color = Color(0xFFD0BCFF)

    ),
    QuadrantModel(
        title = "Row composable",
        description = "A layout composable that places its children in a horizontal sequence",
        color = Color(0xFFB69DF8)

    ),
    QuadrantModel(
        title = "Column composable",
        description = "A layout composable that places its children in a vertical sequence.",
        color = Color(0xFFF6EDFF)
    )
);

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Jetpack_composeTheme {
        ComposeQuadrant(data = quadrantModelList)
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            Jetpack_composeTheme {
                Scaffold { paddingValue ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValue),
                    ) {
                        ComposeQuadrant(
                            data =
                                quadrantModelList,
                        )
                    }
                }

            }
        }
    }
}

@Composable
fun ComposeQuadrant(
    data: List<QuadrantModel>, modifier: Modifier = Modifier
) {
    val textModifier: Modifier = Modifier.padding(
        start = 16.dp, top = 10.dp, end = 16.dp
    )
    var index: Int = 0

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Top,
    ) {
        while (index < data.size) {
            val model1: QuadrantModel = data[index]
            index++

            var model2: QuadrantModel? = null
            if (index < data.size) {
                model2 =
                    data[index];
                index++
            }
            Row(
                Modifier.weight(1f)
            ) {
                QuadrantInfoCard(
                    model = model1,
                    modifier = textModifier.weight(1f)
                )
                if (model2 != null)
                    QuadrantInfoCard(
                        model = model2,
                        modifier = textModifier.weight(1f)
                    )
            }
        }
    }
}

@Composable
fun QuadrantInfoCard(model: QuadrantModel, modifier: Modifier) {
    Column(

        modifier = modifier
            .fillMaxSize()
            .background(model.color)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        XTitle(title = model.title)
        XParagraph(message = model.description)
    }
}


@Composable
fun XTitle(title: String, modifier: Modifier = Modifier) {
    Text(
        text = title,
        fontSize = 20.sp,
        textAlign = TextAlign.Center,
        modifier = modifier,
    )
}

@Composable
fun XParagraph(message: String, modifier: Modifier = Modifier) {
    Text(
        text = message, fontSize = 12.sp,
        textAlign = TextAlign.Justify, modifier = modifier
    )
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

//                Surface(
//                    modifier = Modifier
//                        .fillMaxSize(),
////                        .safeContentPadding(),
//                ) {
//                    ComposeArticle(
//                        image = painterResource(R.drawable.bg_compose_background),
//                        title = "Jetpack Compose Tutorial",
//                        paragraphs = listOf(
//                            "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.",
//                            "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app\\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\\'s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name.",
//                        ),
//                    )
////                    Greeting(
////                        message = "XYZ", from = "Atif"
////                    )
//                }