package com.lewishr.honestbakers.ui.screens.Bakes

import android.content.ContentValues
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.pdf.PdfDocument
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.lewishr.honestbakers.R
import com.lewishr.honestbakers.viewmodel.BakesViewModel
import com.lewishr.honestbakers.model.Bakes
import com.lewishr.honestbakers.navigation.ROUT_ADD_BAKES
import com.lewishr.honestbakers.navigation.ROUT_BAKES_LIST
import com.lewishr.honestbakers.navigation.ROUT_EDIT_BAKES
import com.lewishr.honestbakers.navigation.editBakesRoute


import java.io.IOException
import java.io.OutputStream

@RequiresApi(Build.VERSION_CODES.Q)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BakesListScreen(navController: NavController, viewModel: BakesViewModel) {
    val bakesList by viewModel.allBakes.observeAsState(emptyList())
    var showMenu by remember { mutableStateOf(false) }
    var searchQuery by remember { mutableStateOf("") }

    val filteredBakes = bakesList.filter {
        it.name.contains(searchQuery, ignoreCase = true)
    }

    Scaffold(
        topBar = {
            Column {
                TopAppBar(
                    title = { Text("Bakes", fontSize = 20.sp) },
                    colors = TopAppBarDefaults.mediumTopAppBarColors(Color.LightGray),
                    actions = {
                        IconButton(onClick = { showMenu = true }) {
                            Icon(imageVector = Icons.Default.MoreVert, contentDescription = "Menu")
                        }
                        DropdownMenu(
                            expanded = showMenu,
                            onDismissRequest = { showMenu = false }
                        ) {
                            DropdownMenuItem(
                                text = { Text("Bakes List") },
                                onClick = {
                                    navController.navigate(ROUT_BAKES_LIST)
                                    showMenu = false
                                }
                            )
                            DropdownMenuItem(
                                text = { Text("Add Product") },
                                onClick = {
                                    navController.navigate(ROUT_ADD_BAKES)
                                    showMenu = false
                                }
                            )
                        }
                    }
                )


                //Search Bar
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 8.dp),
                    placeholder = { Text("Search bakess...") },
                    singleLine = true,
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search",
                            tint = Color.Gray
                        )
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Black,  // Border color when focused
                        unfocusedBorderColor = Color.Gray, // Border color when not focused
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.DarkGray
                    )
                )
            }
        },
        bottomBar = { BottomNavigationBar1(navController) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            LazyColumn {
                items(filteredBakes.size) { index ->
                    BakesItem(navController, filteredBakes[index], viewModel)
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun BakesItem(navController: NavController, bakes: Bakes, viewModel: BakesViewModel) {
    val painter: Painter = rememberAsyncImagePainter(
        model = bakes.imagePath?.let { Uri.parse(it) } ?: Uri.EMPTY
    )
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable {
                if (bakes.id != 0) {
                    navController.navigate(ROUT_EDIT_BAKES)
                }
            },
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            // Bakes Image
            Image(
                painter = painter,
                contentDescription = "Bakes Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )

            // Gradient Overlay
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .align(Alignment.BottomStart)
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.7f))
                        )
                    )
            )

            // Product Info
            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(start = 12.dp, bottom = 60.dp)
            ) {
                Text(
                    text = bakes.name,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    text = "Price: Ksh${bakes.price}",
                    fontSize = 16.sp,
                    color = Color.White
                )
            }

            // Buttons (Message, Edit, Delete, Download PDF)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .align(Alignment.BottomEnd)
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {


                    // Edit Product
                    IconButton(
                        onClick = {
                            navController.navigate(editBakesRoute(bakes.id))
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = "Edit",
                            tint = Color.White
                        )
                    }

                    // Delete Product
                    IconButton(
                        onClick = { viewModel.deleteBakes(bakes) }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = "Delete",
                            tint = Color.White
                        )
                    }

                    // Download PDF
                    IconButton(
                        onClick = { generateBakesPDF(context, bakes) }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.download),
                            contentDescription = "",
                            tint = Color.White
                        )
                    }
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.Q)
fun generateBakesPDF(context: Context, bakes: Bakes) {
    val pdfDocument = PdfDocument()
    val pageInfo = PdfDocument.PageInfo.Builder(300, 500, 1).create()
    val page = pdfDocument.startPage(pageInfo)
    val canvas = page.canvas
    val paint = android.graphics.Paint()

    val bitmap: Bitmap? = try {
        bakes.imagePath?.let {
            val uri = Uri.parse(it)
            context.contentResolver.openInputStream(uri)?.use { inputStream ->
                BitmapFactory.decodeStream(inputStream)
            }
        }
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }

    bitmap?.let {
        val scaledBitmap = Bitmap.createScaledBitmap(it, 250, 150, false)
        canvas.drawBitmap(scaledBitmap, 25f, 20f, paint)
    }

    paint.textSize = 16f
    paint.isFakeBoldText = true
    canvas.drawText("Product Details", 80f, 200f, paint)

    paint.textSize = 12f
    paint.isFakeBoldText = false
    canvas.drawText("Name: ${bakes.name}", 50f, 230f, paint)
    canvas.drawText("Price: Ksh${bakes.price}", 50f, 250f, paint)


    pdfDocument.finishPage(page)

    // Save PDF using MediaStore (Scoped Storage)
    val fileName = "${bakes.name}_Details.pdf"
    val contentValues = ContentValues().apply {
        put(MediaStore.MediaColumns.DISPLAY_NAME, fileName)
        put(MediaStore.MediaColumns.MIME_TYPE, "application/pdf")
        put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_DOWNLOADS)
    }

    val contentResolver = context.contentResolver
    val uri = contentResolver.insert(MediaStore.Downloads.EXTERNAL_CONTENT_URI, contentValues)

    if (uri != null) {
        try {
            val outputStream: OutputStream? = contentResolver.openOutputStream(uri)
            if (outputStream != null) {
                pdfDocument.writeTo(outputStream)
                Toast.makeText(context, "PDF saved to Downloads!", Toast.LENGTH_LONG).show()
            }
            outputStream?.close()
        } catch (e: IOException) {
            e.printStackTrace()
            Toast.makeText(context, "Failed to save PDF!", Toast.LENGTH_LONG).show()
        }
    } else {
        Toast.makeText(context, "Failed to create file!", Toast.LENGTH_LONG).show()
    }

    pdfDocument.close()
}

// Bottom Navigation Bar Component
@Composable
fun BottomNavigationBar1(navController: NavController) {
    NavigationBar(
        containerColor = Color(0xFFA2B9A2),
        contentColor = Color.White
    ) {
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate(ROUT_BAKES_LIST) },
            icon = { Icon(Icons.Default.Home, contentDescription = "Bakes List") },
            label = { Text("Home") }
        )
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate(ROUT_ADD_BAKES) },
            icon = { Icon(Icons.Default.AddCircle, contentDescription = "Add Bakes") },
            label = { Text("Add") }
        )
    }
}