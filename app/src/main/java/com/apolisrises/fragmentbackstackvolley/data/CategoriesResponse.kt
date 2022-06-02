package com.apolisrises.fragmentbackstackvolley.data

data class CategoriesResponse(
    val status: Int,
    val message: String,
    val categories: List<Category>
)