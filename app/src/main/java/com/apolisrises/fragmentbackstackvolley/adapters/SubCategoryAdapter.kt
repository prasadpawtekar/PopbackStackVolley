package com.apolisrises.fragmentbackstackvolley.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.apolisrises.fragmentbackstackvolley.data.Subcategory
import com.apolisrises.fragmentbackstackvolley.databinding.ViewHolderSubcategoryBinding
import com.apolisrises.fragmentbackstackvolley.viewholders.SubCategoryViewHolder

class SubCategoryAdapter(val subCategories: List<Subcategory>
): RecyclerView.Adapter<SubCategoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubCategoryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ViewHolderSubcategoryBinding.inflate(layoutInflater, parent, false)
        return SubCategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SubCategoryViewHolder, position: Int) {
        holder.setData(subCategories[position])

        if(this::subCategorySelectedListener.isInitialized) {
            holder.itemView.setOnClickListener {
                subCategorySelectedListener(subCategories[position], position)
            }
        }
    }

    override fun getItemCount() = subCategories.size

    lateinit var subCategorySelectedListener: (Subcategory, Int) -> Unit

    fun setOnSubCategorySelectedListener(listener: (Subcategory, Int) -> Unit) {
        subCategorySelectedListener = listener
    }
}