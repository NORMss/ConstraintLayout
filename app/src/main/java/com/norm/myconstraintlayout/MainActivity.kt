package com.norm.myconstraintlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.norm.myconstraintlayout.ui.theme.MyConstraintLayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyConstraintLayoutTheme {
                GreetingPreview()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (text, button, image) = createRefs()
        val bottomGuideLine = createGuidelineFromBottom(0.25f)

        Button(onClick = {

        },
            modifier = Modifier.constrainAs(button) {
                bottom.linkTo(bottomGuideLine)
                top.linkTo(bottomGuideLine)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        ) {
            Text(text = "Click me")
        }
        Text(
            text = "Hello, Android!",
            modifier = Modifier.constrainAs(text) {
                bottom.linkTo(button.top, 16.dp)
                start.linkTo(button.start)
                end.linkTo(button.end)
            }
        )
        Image(
            painterResource(id = R.drawable.img),
            contentDescription = "img1",
            modifier = Modifier
                .size(256.dp)
                .clip(CircleShape)
                .constrainAs(image) {
                    bottom.linkTo(text.top, 16.dp)
                    start.linkTo(button.start)
                    end.linkTo(button.end)
                }
        )
    }
}