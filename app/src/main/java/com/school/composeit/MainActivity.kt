package com.school.composeit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
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

val sampleConversations = listOf<Message>(
    Message("Albert", "Theory of relativity"),
    Message("Newton", "An apple from the tree"),
    Message("Pythagoras", "Well that's a love triangle.")
)


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
                .clip(CircleShape)
                .border(2.5.dp, MaterialTheme.colors.secondary, CircleShape),
            alignment = Alignment.Center,
            contentScale = ContentScale.Crop
            )

        //horizontal space
        Spacer(modifier = Modifier.width(10.dp))

        Column {
            Text(
                text = message.author,
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.h6
            )
            //vertical space
            Spacer(modifier = Modifier.height(5.dp))
            
            Surface(shape = MaterialTheme.shapes.medium,
                elevation = 2.dp, ) {

                Text(
                    text = message.body,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(5.dp)
                )

            }
            

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


//list of items
@Composable
fun SimpleConversation(messages: List<Message>){

    LazyColumn{
        items(messages){
            message -> MessageCard(message = message)
        }

    }

}

//sample preview
@Preview
@Composable
fun PreviewSimpleConversation(){
    ComposeItTheme {
        SimpleConversation(messages = sampleConversations)
    }
}
































