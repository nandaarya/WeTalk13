package com.example.wetalk13

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wetalk13.databinding.LayoutItemBinding

class BookListAdapter : RecyclerView.Adapter<BookListAdapter.BookListViewHolder>() {

    private var listOfBook = ArrayList<Book>()

    fun addBookList(list: List<Book>) {
        this.listOfBook.clear()
        this.listOfBook.addAll(list)
        notifyDataSetChanged()
    }

    inner class BookListViewHolder(private val binding: LayoutItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) {
            val itemNow = listOfBook[position]

            binding.tvBookTitle.text = itemNow.bookTitle
            binding.tvSinopsis.text = itemNow.synopsis

            Glide
                .with(itemView.context)
                .load(itemNow.bookCover)
                .fitCenter()
                .into(binding.ivBookPhotos)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookListViewHolder {
        return BookListViewHolder(
            LayoutItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return listOfBook.size
    }

    override fun onBindViewHolder(holder: BookListViewHolder, position: Int) {
        holder.bind(position)
    }
}