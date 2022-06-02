package com.apolisrises.fragmentbackstackvolley.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.apolisrises.fragmentbackstackvolley.R
import com.apolisrises.fragmentbackstackvolley.data.Category
import com.apolisrises.fragmentbackstackvolley.data.Subcategory
import com.apolisrises.fragmentbackstackvolley.databinding.ViewHolderSubcategoryBinding
import com.squareup.picasso.Picasso

class SubCategoryViewHolder(val binding: ViewHolderSubcategoryBinding
):RecyclerView.ViewHolder(binding.root) {

    fun setData(subCategory: Subcategory) {
        binding.apply {
            tvCategory.text = subCategory.subcategory_name
            val url = "https://psmobitech.com/myshop/images/${subCategory.subcategory_image_url}"
            Picasso.get().load(url).placeholder(R.mipmap.ic_launcher).into(ivCategoryImg)
        }
    }
}