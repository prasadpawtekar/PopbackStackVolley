package com.apolisrises.fragmentbackstackvolley.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.apolisrises.fragmentbackstackvolley.data.Category
import com.apolisrises.fragmentbackstackvolley.databinding.ViewHolderCategoryBinding
import com.apolisrises.fragmentbackstackvolley.viewholders.CategoryViewHolder

class CategoryAdapter(val categories: List<Category>
): RecyclerView.Adapter<CategoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ViewHolderCategoryBinding.inflate(layoutInflater, parent, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.setData(categories[position])

        if(this::categorySelectedListener.isInitialized) {
            holder.itemView.setOnClickListener {
                categorySelectedListener(categories[position], position)
            }
        }
    }

    override fun getItemCount() = categories.size

    lateinit var categorySelectedListener: (Category, Int) -> Unit

    fun setOnCategorySelectedListener(listener: (Category, Int) -> Unit) {
        categorySelectedListener = listener
    }
}