package com.example.igprofile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape

import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons

import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen() {
    BlackBackgroundSquare()
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar()
        Spacer(modifier = Modifier.height(60.dp))
        ProfileSection(
            name = "Amit Segal",
            company = "N12 news channel",
        )
        Spacer(modifier = Modifier.height(20.dp))
        // voting bar
        VotingBar(
            leftyPercent = 10, rightyPercent = 90
        )
    }
}

@Composable
fun VotingBar(
    modifier: Modifier = Modifier, leftyPercent: Int, rightyPercent: Int
) {
    var leftyPercentWeight: Float = (leftyPercent / 10).toFloat()
    var rightyPercentWeight: Float = (rightyPercent / 10).toFloat()
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(Color.White)
            .border(1.dp, Color.Black, CircleShape)
    ) {
        Column(
            // add rounded corners to the left side
            modifier = Modifier
                .background(Color(0xFFA60321))
                .height(50.dp)
                .weight(leftyPercentWeight)
                .clip(CircleShape),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {

        }
        Column(
            modifier = Modifier
                .background(Color(0xFF03588C))
                .height(50.dp)
                .weight(rightyPercentWeight)
                .clip(CircleShape),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
            // add rounded corners to the right side
        ) {}
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(Color.White),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Row {
            Box(
                modifier = Modifier
                    .size(30.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFA60321))
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "Right $rightyPercent%", fontSize = 20.sp, fontWeight = FontWeight.Bold
            )
        }

        Row() {
            Box(
                modifier = Modifier
                    .size(30.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF03588C))
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "Left $leftyPercent%", fontSize = 20.sp, fontWeight = FontWeight.Bold
            )
        }


    }

}

@Composable
fun BlackBackgroundSquare() {
    Box(
        // modifier fill only half the screen
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            // insert background color as hex
            .background(Color(0xFF2C3E50))
    )
}

@Composable
fun TopBar(
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxWidth()
    ) {
        Icon(
            imageVector = Icons.Default.Menu,
            contentDescription = "Back",
            tint = Color.White,
            modifier = Modifier
                .size(40.dp)
                .padding(start = 5.dp)
        )
        Text(
            text = "Profile",
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp,
            color = Color.White
        )
        Spacer(modifier = Modifier.size(40.dp))
    }

}


@Composable
fun ProfileSection(
    name: String, company: String, modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        RoundImage(
            image = painterResource(id = R.drawable.profile_pic), modifier = Modifier.size(250.dp)
        )
        Text(
            text = name,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp,
            color = Color.Black
        )
        Text(
            text = company,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.Black
        )
    }
}

@Composable
fun RoundImage(
    image: Painter, modifier: Modifier = Modifier
) {
    Image(
        painter = image,
        contentDescription = "Profile image",
        modifier = modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(
                width = 6.dp, color = Color.White, shape = CircleShape
            )
            .padding(3.dp)
            .clip(CircleShape)
    )
}



