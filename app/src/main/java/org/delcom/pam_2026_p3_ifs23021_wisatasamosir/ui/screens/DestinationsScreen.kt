package org.delcom.pam_2026_p3_ifs23021_wisatasamosir.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items   // <-- WAJIB ini!
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.delcom.pam_2026_p3_ifs23021_wisatasamosir.data.DummyData
import org.delcom.pam_2026_p3_ifs23021_wisatasamosir.data.DestinationData
import java.text.NumberFormat
import java.util.Locale

@Composable
fun DestinationsScreen(
    onOpenDetail: (String) -> Unit
) {
    val data = DummyData.getDestinations()

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(
            items = data,              // <-- ini yang benar
            key = { it.id }            // <-- id harus ada di model
        ) { item ->
            DestinationCard(
                item = item,
                onClick = { onOpenDetail(item.id) }
            )
        }
    }
}

@Composable
private fun DestinationCard(
    item: DestinationData,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = item.imageRes),
                contentDescription = item.namaWisata,
                modifier = Modifier
                    .size(92.dp)
                    .clip(RoundedCornerShape(14.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = item.namaWisata,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(Modifier.height(4.dp))
                Text(text = item.lokasi, style = MaterialTheme.typography.bodyMedium)
                Spacer(Modifier.height(6.dp))
                Text(
                    text = "Peminat: ${formatNumber(item.peminat)}",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}

private fun formatNumber(value: Int): String {
    val localeId = Locale.Builder().setLanguage("id").setRegion("ID").build()
    return NumberFormat.getNumberInstance(localeId).format(value)
}