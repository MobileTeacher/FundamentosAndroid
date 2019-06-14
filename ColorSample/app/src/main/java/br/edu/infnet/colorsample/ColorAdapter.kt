package br.edu.infnet.colorsample

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import br.edu.infnet.colorsample.model.MyColor


const val EMPTY_CARD = 0
const val REGULAR_CARD = 1

class ColorAdapter(var items:MutableList<MyColor> = mutableListOf()):
                RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val card = LayoutInflater
                .from(parent.context)
                .inflate(if(viewType == EMPTY_CARD)
                            R.layout.empty_card
                        else
                            R.layout.color_card,
                        parent, false)

        return if(viewType == EMPTY_CARD) EmptyViewHolder(card) else ColorViewHolder(card)
    }

    override fun getItemViewType(position: Int) = if (items.isEmpty()) EMPTY_CARD else REGULAR_CARD


    override fun getItemCount() = if(items.isEmpty()) 1 else items.size


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ColorViewHolder){
            val myColor = items[position]
            holder.aliasTextView.text = myColor.alias
            holder.colorCodeTextView.text = myColor.code
        }
    }

    fun addColor(newColor: MyColor){
        items.add(newColor)
        val pos = items.size - 1
        notifyItemInserted(items.size)
    }

    class ColorViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val aliasTextView = itemView.findViewById<TextView>(R.id.color_alias_textview)
        val colorCodeTextView = itemView.findViewById<TextView>(R.id.color_code_textview)
    }
    class EmptyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

}