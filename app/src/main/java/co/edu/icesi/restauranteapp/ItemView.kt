package co.edu.icesi.restauranteapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import co.edu.icesi.restauranteapp.databinding.ItemBinding

class ItemView(root : View) : ViewHolder(root){

    private val binding = ItemBinding.bind(root)
    val nameItem = binding.nameItemTV
    val priceItem = binding.priceItemTV

}