package com.than.tugasramadhan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class BarangListAdapter: ListAdapter<Barang, BarangListAdapter.BarangViewHolder>(BARANG_COMPARATOR) {
    class BarangViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val barangItemView: TextView = itemView.findViewById(R.id.textView)
        fun Bind(text: String?){
            barangItemView.text = text
        }
        companion object {
            fun create(parent: ViewGroup): BarangViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recyclerview_item, parent, false)
                return BarangViewHolder(view)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BarangViewHolder {
        return BarangViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: BarangViewHolder, position: Int) {
        val current = getItem(position)
        holder.Bind(current.nama_barang)
    }
    companion object {
        private val BARANG_COMPARATOR = object : DiffUtil.ItemCallback<Barang>() {
            override fun areItemsTheSame(oldItem: Barang, newItem: Barang): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: Barang, newItem: Barang): Boolean {
                return oldItem.nama_barang == newItem.nama_barang
            }
        }
    }
}