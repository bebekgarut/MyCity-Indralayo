package com.example.recommendedplacesinlayo.model

data class ItemRecommendation(
    val nama: String,
    val deskripsi: String,
    val gambar: Int
)

data class Recommendation(
    val kategori: String,
    val items: List<ItemRecommendation>,
    val iconResId: Int
)



