package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                ArtSpaceAppLayout()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpaceApp(){
    ArtSpaceAppLayout()
}


@Composable
fun ArtSpaceAppLayout( modifier: Modifier = Modifier ){
    var pic by remember { mutableStateOf(1) }

    val imageResource = when (pic) {
        1 -> R.drawable.art1
        2 -> R.drawable.art2
        3 -> R.drawable.art3
        4 -> R.drawable.art4
        5 -> R.drawable.art5
        6 -> R.drawable.art6
        else -> R.drawable.art7
    }

    val stringResource = when (pic) {
        1 -> R.string.art1
        2 -> R.string.art2
        3 -> R.string.art3
        4 -> R.string.art4
        5 -> R.string.art5
        6 -> R.string.art6
        else -> R.string.art7
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
            .padding(25.dp)

    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
                .shadow(5.dp)
        ) {
            Image(
                painter = painterResource(imageResource),
                contentDescription = null,
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .padding(25.dp)
                    .align(Alignment.Center)
//                    .fillMaxWidth(0.9f)
//                    .fillMaxSize(0.9f)
                    .background(color = Color.White)
                    .shadow(elevation = 1.dp, ambientColor = Color.Black)
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        ElevatedCard(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            ),
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp)
            ){
                Text(
                    text = stringResource(stringResource),
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp
                )

                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "@" + stringResource(R.string.artist),
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { pic = paginate(pic, -1) },
                modifier = Modifier.width(150.dp)
            ) {
                Text( text = "Previous" )
            }

            Button(
                onClick = { pic = paginate(pic, 1) },
                modifier = Modifier.width(150.dp)
            ) {
                Text( text = "Next" )
            }
        }
    }
}

fun paginate(currentPic: Int, action: Int): Int{
    val nextPic = currentPic + action
    val result = when (nextPic) {
        0 -> 1
        8 -> 7
        else -> nextPic
    }

    return result
}

//buildAnnotatedString {
//    val title = stringResource(stringResource)
//    val artist = "@" + stringResource(R.string.artist)
//
//    val titleStyle = SpanStyle(
//        fontFamily = FontFamily.SansSerif,
//        background = Color.Yellow
//    )
//
//    withStyle(style = titleStyle) {
//        append(title)
//    }
//
//}