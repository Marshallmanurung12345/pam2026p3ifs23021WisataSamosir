package org.delcom.pam_2026_p3_ifs23021_wisatasamosir.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.delcom.pam_2026_p3_ifs23021_wisatasamosir.data.DummyData
import java.text.NumberFormat
import java.util.Locale

@Composable
fun DestinationDetailScreen(
    id: String,
    onBack: () -> Unit
) {
    val item = DummyData.findById(id)
    val context = LocalContext.current

    if (item == null) {
        Column(Modifier.fillMaxSize().padding(16.dp)) {
            Text("Data tidak ditemukan.")
            Spacer(Modifier.height(8.dp))
            Button(onClick = onBack) { Text("Kembali") }
        }
        return
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Button(onClick = onBack) { Text("Back") }

        Image(
            painter = painterResource(item.imageRes),
            contentDescription = item.namaWisata,
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .clip(RoundedCornerShape(18.dp)),
            contentScale = ContentScale.Crop
        )

        Text(
            text = item.namaWisata,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = item.lokasi,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        // Chips ringkas (kategori, peminat)
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            AssistChip(onClick = { }, label = { Text(item.kategori) })
            AssistChip(onClick = { }, label = { Text("Peminat: ${formatNumber(item.peminat)}") })
        }

        // Card info tambahan (rating, jam buka, harga)
        Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
        ) {
            Column(
                modifier = Modifier.padding(14.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                InfoRow(Icons.Filled.Star, "Rating", item.rating.toString())
                InfoRow(Icons.Filled.AccessTime, "Jam Buka", item.jamBuka)
                InfoRow(Icons.Filled.AttachMoney, "Harga/Tiket", item.harga)
            }
        }

        Text(
            text = "Deskripsi",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold
        )
        Text(text = item.deskripsi, style = MaterialTheme.typography.bodyMedium)

        Button(
            onClick = {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(item.mapsUrl))
                context.startActivity(intent)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(Icons.Filled.Map, contentDescription = null)
            Spacer(Modifier.width(8.dp))
            Text("Buka di Google Maps")
        }
    }
}

@Composable
private fun InfoRow(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    label: String,
    value: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            Icon(icon, contentDescription = null)
            Text(text = label, fontWeight = FontWeight.SemiBold)
        }
        Text(text = value)
    }
}

private fun formatNumber(value: Int): String {
    val localeId = Locale.Builder().setLanguage("id").setRegion("ID").build()
    return NumberFormat.getNumberInstance(localeId).format(value)
}