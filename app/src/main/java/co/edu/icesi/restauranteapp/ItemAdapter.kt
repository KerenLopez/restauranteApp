package co.edu.icesi.restauranteapp

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import co.edu.icesi.restauranteapp.model.Item

class ItemAdapter() : Adapter<ItemView>() {

    val items = ArrayList<Item>()

    constructor(parcel: Parcel) : this() {
    }

    init {
        items.add(Item("Chuleta", 8000.0))
        items.add(Item("Cerveza", 12500.0))
    }

    //Método para construir los esqueletos de los item de la lista
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemView {
        //inflater --> transformar cualquier XML(texto) a View(objeto)
        val inflater = LayoutInflater.from(parent.context)
        val view : View = inflater.inflate(R.layout.item, null, false)
        val itemview = ItemView(view)
        return itemview
    }

    //Vamos a cargarlos datos en los esqueletos
    override fun onBindViewHolder(holder: ItemView, position: Int) {
        val data = items[position]
        holder.nameItem.text = data.name
        holder.priceItem.text = "$ ${data.price}" //String insertion
    }

    fun addItem(item:Item){
        items.add(item)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return items.size
    }

}