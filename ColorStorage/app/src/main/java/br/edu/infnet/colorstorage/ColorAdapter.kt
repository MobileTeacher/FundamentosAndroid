package br.edu.infnet.colorstorage

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.edu.infnet.colorstorage.model.MyColor

class ColorAdapter(var items: List<MyColor> = listOf()): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): RecyclerView.ViewHolder {
        val itemCard = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.color_card, parent, false)
        return ColorViewHolder(itemCard)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    override fun getItemCount() = items.size

    class ColorViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val colorView = itemView.findViewById<View>(R.id.color_view)
    }
}