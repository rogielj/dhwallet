package com.digitalhouse.dhwallet.Adapter



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.digitalhouse.dhwallet.R
import com.digitalhouse.dhwallet.model.Transaction
import com.digitalhouse.dhwallet.util.Extensions.load


private const val HEADER = 0
private const val HEADER2 = 1
private const val CONTENT = 2

class TransactionAdapter(private val list: List<Transaction>,
private val listener: OnClickListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        if (viewType == HEADER){
            return HeaderViewHolder(inflater.inflate(R.layout.item_only_title_transaction, parent, false))
        }
        if (viewType == HEADER2){
            return Header2ViewHolder(inflater.inflate(R.layout.item_only_title_transaction, parent, false))
        }
        return TransactionViewHolder(inflater.inflate(R.layout.item_transaction, parent, false), listener)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is TransactionViewHolder -> holder.bind(list[position-1])
            is HeaderViewHolder -> holder.bindHeader(holder.itemView.context.getString(R.string.hoje))
            is Header2ViewHolder -> holder.bindSndtitle(holder.itemView.context.getString(R.string.quarta))
        }
//        (holder as TransactionViewHolder).bind(list[position -1])
    }

    override fun getItemViewType(position: Int): Int {
        return when (position){
            0 -> HEADER
            4 -> HEADER2
            else -> {
                CONTENT
            }
        }

//        if (position == 0){
//            return HEADER
//        }
//       return CONTENT

    }

    override fun getItemCount() = list.size + 1
//    override fun getItemCount() = 10


interface OnClickListener {
    fun onClick(transaction: Transaction)
}
    }

class Header2ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val titleonly2: TextView = view.findViewById(R.id.only_title_content_trans)
    fun bindSndtitle(onlytitleTran2: String){
        titleonly2.text = onlytitleTran2
    }

}

class HeaderViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val titleonly: TextView = view.findViewById(R.id.only_title_content_trans)
    fun bindHeader(onlytitleTran: String){
        titleonly.text = onlytitleTran
    }
}

class TransactionViewHolder(view: View, listener: TransactionAdapter.OnClickListener) : RecyclerView.ViewHolder(view) {

    private val image: ImageView = view.findViewById(R.id.image_transaction)
    private val titletran: TextView = view.findViewById(R.id.title_transaction)
    private val subtitletran: TextView = view.findViewById(R.id.subtitle_transaction)
    private val valueop: TextView = view.findViewById(R.id.value_item_transaction)
    private var currentTransaction: Transaction? = null

    init {
        view.setOnClickListener {
            // Se ele for diferente de nulo
            currentTransaction?.let{
                listener.onClick(it)
            }
            Toast.makeText(this.itemView.context,"Item [${currentTransaction?.title}] selecionado", Toast.LENGTH_SHORT).show()
        }
    }

    fun bind(item: Transaction) {

        currentTransaction = item
        titletran.text = item.title
        subtitletran.text = item.subtitle
        valueop.text = item.value

        image.load(item.img)

            if (valueop.text.contains("-")){
                valueop.setTextColor(itemView.context.getColor(R.color.bittersweet))
            }
        else if(valueop.text.contains("+")){
            valueop.setTextColor(itemView.context.getColor(R.color.apple))
        }

    }
}