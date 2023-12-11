package com.sample.setwallpaper

import android.app.WallpaperManager
import android.content.Context
import android.graphics.BitmapFactory
import android.media.Image
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import java.io.IOException

val imageList = listOf(
    R.drawable.image1,
    R.drawable.image2,
    R.drawable.image3
    // Add more images as needed
)

@Composable
fun ImageList(context: Context) {
    LazyColumn{
        items(imageList.size) {index ->
            val theItem = imageList[index]
            ImageCard(theItem, context)
        }

    }
}

@Composable
fun ImageCard(image: Int, context: Context){
    Card(
        modifier = Modifier
            .padding(16.dp)
            .clickable {
                setWallpaper(image, context)
            }
    ) {
        Image(painter = painterResource(id = image),
            contentDescription = null,
            modifier = Modifier.height(200.dp))
    }
}

fun setWallpaper(image: Int, context: Context ) {
    val wallpaperManager = WallpaperManager.getInstance(context)
    val bitmap = BitmapFactory.decodeResource(context.resources,image)

    try {
        wallpaperManager.setBitmap(bitmap)
        Toast.makeText(context, "Wallpaper set successfully", Toast.LENGTH_SHORT).show()
    } catch(e: IOException) {
        Toast.makeText(context, "Error setting wallpaper", Toast.LENGTH_SHORT).show()
    }

}

