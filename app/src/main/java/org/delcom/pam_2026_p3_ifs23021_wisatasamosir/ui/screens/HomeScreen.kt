package org.delcom.pam_2026_p3_ifs23021_wisatasamosir.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.delcom.pam_2026_p3_ifs23021_wisatasamosir.R
import org.delcom.pam_2026_p3_ifs23021_wisatasamosir.data.DummyData
import org.delcom.pam_2026_p3_ifs23021_wisatasamosir.data.DestinationData
import org.delcom.pam_2026_p3_ifs23021_wisatasamosir.helper.RouteHelper
import java.text.NumberFormat
import java.util.Locale

@Composable
fun HomeScreen(navController: NavController) {

    val data = DummyData.getDestinations()
    val totalPeminat = data.sumOf { it.peminat }
    val top3 = data.sortedByDescending { it.peminat }.take(3)

    val categories = listOf("Semua", "Alam", "Pantai", "Budaya", "Kawasan", "Viewpoint")
    val selectedCategory = remember { mutableStateOf("Semua") }

    val rekomendasi = if (selectedCategory.value == "Semua") {
        top3
    } else {
        data.filter { it.kategori.equals(selectedCategory.value, ignoreCase = true) }
            .sortedByDescending { it.peminat }
            .take(3)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {

        // HERO / Banner
        Image(
            painter = painterResource(id = R.drawable.tele), // ganti jika mau
            contentDescription = "Banner Wisata Samosir",
            modifier = Modifier
                .fillMaxWidth()
                .height(210.dp)
                .clip(RoundedCornerShape(18.dp)),
            contentScale = ContentScale.Crop
        )

        // Judul + Deskripsi singkat
        Text(
            text = "Wisata Samosir",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Temukan destinasi terbaik di Pulau Samosir (Danau Toba). " +
                    "Lihat tempat populer, lokasi, rating, dan peminatnya.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        // QUICK STATS (2 kartu kecil)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            StatCard(
                title = "Destinasi",
                value = data.size.toString(),
                modifier = Modifier.weight(1f)
            )
            StatCard(
                title = "Total Peminat",
                value = formatNumber(totalPeminat),
                modifier = Modifier.weight(1f)
            )
        }

        // KATEGORI (chips)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            categories.forEach { cat ->
                FilterChip(
                    selected = selectedCategory.value == cat,
                    onClick = { selectedCategory.value = cat },
                    label = { Text(cat) }
                )
            }
        }

        // TOP 3 (horizontal cards)
        Text(
            text = "Rekomendasi Populer",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            rekomendasi.forEach { item ->
                TopDestinationCard(
                    item = item,
                    onClick = {
                        navController.navigate(RouteHelper.detail(item.id))
                    }
                )
            }
        }

        // CTA Button
        Button(
            onClick = { navController.navigate(RouteHelper.destinations()) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Lihat Daftar Wisata")
        }
    }
}

@Composable
private fun StatCard(title: String, value: String, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(
            modifier = Modifier.padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(text = title, style = MaterialTheme.typography.labelMedium)
            Text(
                text = value,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
private fun TopDestinationCard(
    item: DestinationData,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .width(220.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(18.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column {
            Image(
                painter = painterResource(id = item.imageRes),
                contentDescription = item.namaWisata,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.padding(12.dp)) {
                Text(
                    text = item.namaWisata,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 1
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    text = item.lokasi,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 1
                )
                Spacer(Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AssistChip(
                        onClick = { },
                        label = { Text(item.kategori) }
                    )
                    Text(
                        text = "⭐ ${item.rating}",
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}

private fun formatNumber(value: Int): String {
    val localeId = Locale.Builder().setLanguage("id").setRegion("ID").build()
    return NumberFormat.getNumberInstance(localeId).format(value)
}