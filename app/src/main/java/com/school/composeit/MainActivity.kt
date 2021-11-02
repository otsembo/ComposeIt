package com.school.composeit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.school.composeit.ui.theme.ComposeItTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            ComposeItTheme {
                MessageCard(message = Message("Albert Einstein",
                    "Madness is attempting to do the same thing and expecting different results!"))
            }

        }

    }
}


data class Message(val author:String, val body:String)


//composable function
@Composable
fun MessageCard(message:Message){
    
    Row {
      
        Image(
            painter = painterResource(id = R.drawable.banner),
            contentDescription = "Image Drawable",
            modifier = Modifier
                .padding(2.dp)
                .height(125.dp)
                .width(125.dp)
                .clip(CircleShape),
            alignment = Alignment.Center,
            contentScale = ContentScale.Crop
            )

        //horizontal space
        Spacer(modifier = Modifier.width(10.dp))

        Column {
            Text(text = message.author)
            //vertical space
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = message.body)
        }
    }

}

//preview
@Preview
@Composable
fun PreviewMessageCard(){
    MessageCard(
        message = Message("Albert Einstein",
            "Madness is attempting to do the same thing and expecting different results!")
    )
}