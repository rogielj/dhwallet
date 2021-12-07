package com.digitalhouse.dhwallet.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.digitalhouse.dhwallet.R
import com.digitalhouse.dhwallet.model.Contact
import com.digitalhouse.dhwallet.util.Extensions.load

class ContactAdapter (private val itens: List<Contact>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ContactViewHolder(inflater.inflate(R.layout.item_contact, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder){
            is ContactViewHolder -> holder.bind(itens[position])
        }
    }

    override fun getItemCount() = itens.size
}

class ContactViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val image: ImageView = view.findViewById(R.id.image_contact)
    private val title: TextView = view.findViewById(R.id.title_contact)
    private val subtitle: TextView = view.findViewById(R.id.subtitle_contact)

    fun bind(item: Contact){

        image.load(item.image)

        title.text = item.name
        subtitle.text = item.type.description
    }

}