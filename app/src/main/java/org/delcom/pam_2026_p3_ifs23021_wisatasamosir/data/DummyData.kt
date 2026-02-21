package org.delcom.pam_2026_p3_ifs23021_wisatasamosir.data

import org.delcom.pam_2026_p3_ifs23021_wisatasamosir.R

object DummyData {

    fun getDestinations(): List<DestinationData> = listOf(

        DestinationData(
            id = "1",
            namaWisata = "Batu Hoda",
            lokasi = "Samosir, Danau Toba",
            peminat = 12500,
            deskripsi = "Spot batu unik di tepi Danau Toba. Cocok untuk foto dan menikmati pemandangan danau.",
            imageRes = R.drawable.batuhoda,
            rating = 4.6,
            kategori = "Alam",
            jamBuka = "08.00 - 18.00",
            harga = "Rp 10.000 - 20.000",
            mapsUrl = "https://www.google.com/maps/search/?api=1&query=Batu+Hoda+Samosir"
        ),

        DestinationData(
            id = "2",
            namaWisata = "Bukit Holbung",
            lokasi = "Harian, Samosir",
            peminat = 18700,
            deskripsi = "Bukit hijau dengan panorama Danau Toba dari ketinggian. Waktu terbaik: pagi atau sore.",
            imageRes = R.drawable.bukitholbung,
            rating = 4.7,
            kategori = "Alam",
            jamBuka = "06.00 - 18.30",
            harga = "Rp 10.000 - 15.000",
            mapsUrl = "https://www.google.com/maps/search/?api=1&query=Bukit+Holbung+Samosir"
        ),

        DestinationData(
            id = "3",
            namaWisata = "Air Terjun Efrata",
            lokasi = "Sosor Dolok, Samosir",
            peminat = 9800,
            deskripsi = "Air terjun cantik dengan akses yang relatif mudah. Cocok untuk wisata alam dan foto.",
            imageRes = R.drawable.efrata,
            rating = 4.5,
            kategori = "Alam",
            jamBuka = "08.00 - 17.30",
            harga = "Rp 5.000 - 10.000",
            mapsUrl = "https://www.google.com/maps/search/?api=1&query=Air+Terjun+Efrata+Samosir"
        ),

        DestinationData(
            id = "4",
            namaWisata = "Pantai Pasir Putih Parbaba",
            lokasi = "Pangururan, Samosir",
            peminat = 23100,
            deskripsi = "Pantai tepi Danau Toba dengan pasir terang. Populer untuk santai dan bermain air.",
            imageRes = R.drawable.parbaba,
            rating = 4.6,
            kategori = "Pantai",
            jamBuka = "08.00 - 18.00",
            harga = "Rp 10.000 - 25.000",
            mapsUrl = "https://www.google.com/maps/search/?api=1&query=Pantai+Pasir+Putih+Parbaba+Samosir"
        ),

        DestinationData(
            id = "5",
            namaWisata = "Tomok (Makam Raja Sidabutar)",
            lokasi = "Tomok, Samosir",
            peminat = 20500,
            deskripsi = "Wisata budaya Batak yang terkenal. Ada situs sejarah, pertunjukan budaya, dan pusat suvenir.",
            imageRes = R.drawable.tomok,
            rating = 4.6,
            kategori = "Budaya",
            jamBuka = "08.00 - 17.00",
            harga = "Rp 5.000 - 15.000",
            mapsUrl = "https://www.google.com/maps/search/?api=1&query=Tomok+Makam+Raja+Sidabutar+Samosir"
        ),

        DestinationData(
            id = "6",
            namaWisata = "Tuktuk Siadong",
            lokasi = "Tuktuk, Samosir",
            peminat = 26000,
            deskripsi = "Area wisata dan penginapan populer. Banyak kuliner, spot sunset, dan suasana santai.",
            imageRes = R.drawable.tuktuk,
            rating = 4.7,
            kategori = "Kawasan",
            jamBuka = "24 Jam",
            harga = "Gratis (area umum)",
            mapsUrl = "https://www.google.com/maps/search/?api=1&query=Tuktuk+Siadong+Samosir"
        ),

        DestinationData(
            id = "7",
            namaWisata = "Menara Pandang Tele",
            lokasi = "Tele, Samosir",
            peminat = 14200,
            deskripsi = "Tempat menikmati panorama Danau Toba dan Pulau Samosir dari ketinggian. Cocok untuk foto landscape.",
            imageRes = R.drawable.tele,
            rating = 4.5,
            kategori = "Viewpoint",
            jamBuka = "07.00 - 18.00",
            harga = "Rp 5.000 - 10.000",
            mapsUrl = "https://www.google.com/maps/search/?api=1&query=Menara+Pandang+Tele+Samosir"
        ),

        DestinationData(
            id = "8",
            namaWisata = "Pantai Malau",
            lokasi = "Samosir, Danau Toba",
            peminat = 8700,
            deskripsi = "Pantai yang lebih tenang untuk bersantai. Nyaman untuk piknik dan menikmati suasana danau.",
            imageRes = R.drawable.malau,
            rating = 4.3,
            kategori = "Pantai",
            jamBuka = "08.00 - 18.00",
            harga = "Rp 5.000 - 10.000",
            mapsUrl = "https://www.google.com/maps/search/?api=1&query=Pantai+Malau+Samosir"
        ),

        DestinationData(
            id = "9",
            namaWisata = "Talmak (Spot Alam Samosir)",
            lokasi = "Samosir",
            peminat = 6500,
            deskripsi = "Spot alam dengan nuansa hijau dan udara sejuk. Cocok untuk healing, santai, dan foto.",
            imageRes = R.drawable.talmak,
            rating = 4.2,
            kategori = "Alam",
            jamBuka = "08.00 - 17.30",
            harga = "Rp 5.000 - 10.000",
            mapsUrl = "https://www.google.com/maps/search/?api=1&query=Talmak+Samosir"
        ),

        DestinationData(
            id = "10",
            namaWisata = "Danau Sidihoni",
            lokasi = "Samosir",
            peminat = 9100,
            deskripsi = "Danau di atas danau: berada di Pulau Samosir dengan suasana sejuk dan pemandangan yang unik.",
            imageRes = R.drawable.sidihomi,
            rating = 4.4,
            kategori = "Alam",
            jamBuka = "08.00 - 17.30",
            harga = "Rp 5.000 - 10.000",
            mapsUrl = "https://www.google.com/maps/search/?api=1&query=Danau+Sidihoni+Samosir"
        )
    )

    fun findById(id: String): DestinationData? =
        getDestinations().find { it.id == id }
}