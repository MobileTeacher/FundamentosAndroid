package br.edu.infnet.bookerama

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import br.edu.infnet.bookerama.models.Book

class BookAdapter(var items: List<Book>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val card = LayoutInflater.from(parent.context)
                            .inflate(R.layout.book_card, parent, false)

        val viewHolder = BookViewHolder(card)
        return viewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val book = items[position]

        if (holder is BookViewHolder){
            holder.titleTextView.text = book.title
            holder.authorTextView.text = book.author
        }
    }

    fun updateData(booksList: List<Book>){
        items = booksList
        notifyDataSetChanged()
    }


    class BookViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val titleTextView: TextView = itemView.findViewById(R.id.book_title_textview)
        // formas equivalentes
        val authorTextView = itemView.findViewById<TextView>(R.id.author_textview)
    }
}