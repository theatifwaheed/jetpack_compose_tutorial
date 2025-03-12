package com.fluxpert.jetpack_compose

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fluxpert.jetpack_compose.ui.theme.Jetpack_composeTheme

@Preview(showBackground = true)
@Composable
fun ComposeQuadrantPreview() {
    Jetpack_composeTheme {
        BasicQuadrant.ComposeQuadrant()
    }
}

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

class BasicQuadrant {
    companion object {

        val quadrantModelList: List<QuadrantModel> = listOf(
            QuadrantModel(
                title = "Text composable",
                description = "Displays text and follows the recommended Material Design guidelines",
                color = Color(0xFFEADDFF),
            ), QuadrantModel(
                title = "Image composable",
                description = "Creates a composable that lays out and draws a given Painter class object",
                color = Color(0xFFD0BCFF)

            ), QuadrantModel(
                title = "Row composable",
                description = "A layout composable that places its children in a horizontal sequence",
                color = Color(0xFFB69DF8)

            ), QuadrantModel(
                title = "Column composable",
                description = "A layout composable that places its children in a vertical sequence.",
                color = Color(0xFFF6EDFF)
            )
        );

        @Composable
        fun ComposeScaffold() {
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

        @Composable
        fun ComposeQuadrant(
            modifier: Modifier = Modifier,
            data: List<QuadrantModel> = quadrantModelList,
        ) {
            val textModifier: Modifier = Modifier.padding(
//                start = 16.dp, top = 10.dp, end = 16.dp
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
                        model2 = data[index];
                        index++
                    }
                    Row(
                        Modifier.weight(1f)
                    ) {
                        QuadrantInfoCard(
                            model = model1, modifier = textModifier.weight(1f)
                        )
                        if (model2 != null) QuadrantInfoCard(
                            model = model2, modifier = textModifier.weight(1f)
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
                color = Color.Black
            )
        }

        @Composable
        fun XParagraph(message: String, modifier: Modifier = Modifier) {
            Text(
                text = message,
                fontSize = 12.sp,
                textAlign = TextAlign.Justify,
                modifier = modifier,
                color = Color.Black
            )
        }
    }


}