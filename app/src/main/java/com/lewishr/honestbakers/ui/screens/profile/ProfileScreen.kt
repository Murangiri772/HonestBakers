package com.lewishr.honestbakers.ui.screens.profile

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import com.lewishr.honestbakers.ui.theme.newbrown




import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.lewishr.honestbakers.R


@Composable
fun ProfileScreen(
    navController: NavController,
    clientName: String = "John Doe",
    clientPhone: String = "+1 (555) 867-5309",
    clientEmail: String = "john.doe@example.com",
    clientImageResId: Int = R.drawable.img
) {
    // State to hold the selected image URI
    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }

    // Image picker launcher to pick image from gallery
    val imagePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        if (uri != null) {
            selectedImageUri = uri
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF9F9F9)),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            // Profile image clickable to change
            val painter = if (selectedImageUri != null) {
                rememberAsyncImagePainter(model = selectedImageUri)
            } else {
                 
            }

            // Client image in circular shape
            Image(
                painter = painterResource(id = clientImageResId),
                contentDescription = "Client Profile Picture",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(140.dp)
                    .clip(CircleShape)
                    .background(Color.White)
                    .clickable {
                        // Launch image picker
                        imagePickerLauncher.launch("image/*")
                    }
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Client name text
            Text(
                text = clientName,

                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp,
                    color = Color(0xFF333333)

            )

            Spacer(modifier = Modifier.height(32.dp))

            // Contact info card
            Card(
                modifier = Modifier.fillMaxWidth(),


            ) {
                Column(
                    modifier = Modifier.fillMaxWidth().background(newbrown).padding(vertical = 16.dp, horizontal = 24.dp)
                ) {
                    ContactRow(icon = Icons.Default.Phone, contactInfo = clientPhone)
                    Spacer(modifier = Modifier.height(16.dp))
                    ContactRow(icon = Icons.Default.Email, contactInfo = clientEmail)
                }
            }
        }
    }
}

@Composable
fun ContactRow(icon: androidx.compose.ui.graphics.vector.ImageVector, contactInfo: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFF6200EE),
            modifier = Modifier.size(28.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = contactInfo,
            fontSize = 18.sp,
            color = Color(0xFF444444)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(rememberNavController())
}

