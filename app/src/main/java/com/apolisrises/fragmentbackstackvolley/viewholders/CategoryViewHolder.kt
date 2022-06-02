package com.apolisrises.fragmentbackstackvolley.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.apolisrises.fragmentbackstackvolley.R
import com.apolisrises.fragmentbackstackvolley.data.Category
import com.apolisrises.fragmentbackstackvolley.databinding.ViewHolderCategoryBinding
import com.squareup.picasso.Picasso

class CategoryViewHolder(val binding: ViewHolderCategoryBinding
):RecyclerView.ViewHolder(binding.root) {

    fun setData(category: Category) {
        binding.apply {
            tvCategory.text = category.category_name
            val url = "https://psmobitech.com/myshop/images/${category.category_image_url}"
            Picasso.get().load(url).placeholder(R.mipmap.ic_launcher).into(ivCategoryImg)
        }
    }
}