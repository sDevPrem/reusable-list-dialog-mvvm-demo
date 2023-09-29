package com.sdevprem.commonlistdialog.ui.common.listdialog

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.sdevprem.commonlistdialog.databinding.ListBottomSheetItemBinding

class ListBottomSheetAdapter(
    list: List<String> = emptyList(),
    val onItemClick : (pos : Int) -> Unit
) : Adapter<ListBottomSheetAdapter.ListBottomSheetItemVH>() {

    var list = list
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class ListBottomSheetItemVH(val binding: ListBottomSheetItemBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListBottomSheetItemVH {
        return ListBottomSheetItemVH(
            ListBottomSheetItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ListBottomSheetItemVH, position: Int) {
        holder.binding.itemTitle.text = list[position]
        holder.binding.root.setOnClickListener{
            onItemClick(position)
        }
    }
}