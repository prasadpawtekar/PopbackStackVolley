package com.apolisrises.fragmentbackstackvolley.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.apolisrises.fragmentbackstackvolley.R
import com.apolisrises.fragmentbackstackvolley.data.Product
import com.apolisrises.fragmentbackstackvolley.databinding.ViewHolderProductBinding
import com.squareup.picasso.Picasso

class ProductViewHolder(val binding: ViewHolderProductBinding
): RecyclerView.ViewHolder(binding.root) {

    fun setData(product: Product) {
        binding.apply {
            tvDescription.text = product.description
            tvTitle.text = product.product_name
            tvPrice.text = "Price = ${product.price}"

            val url = "https://psmobitech.com/myshop/images/${product.product_image_url}"
            try {
                Picasso.get().load(url).placeholder(R.mipmap.ic_launcher).into(binding.ivProductPhoto)
            } finally {

            }
        }
    }
}