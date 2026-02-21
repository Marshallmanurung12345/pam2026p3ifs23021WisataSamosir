package org.delcom.pam_2026_p3_ifs23021_wisatasamosir.data

data class DestinationData(
    val id: String,
    val namaWisata: String,
    val lokasi: String,
    val peminat: Int,
    val deskripsi: String,
    val imageRes: Int,

    val rating: Double,
    val kategori: String,
    val jamBuka: String,
    val harga: String,
    val mapsUrl: String,
)
