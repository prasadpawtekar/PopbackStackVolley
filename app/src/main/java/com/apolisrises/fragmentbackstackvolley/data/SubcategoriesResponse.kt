package com.apolisrises.fragmentbackstackvolley.data

data class SubcategoriesResponse(
    val message: String,
    val status: Int,
    val subcategories: List<Subcategory>
)