package co.edu.icesi.restauranteapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import co.edu.icesi.restauranteapp.databinding.ActivityMainBinding
import co.edu.icesi.restauranteapp.model.Item

class MainActivity : AppCompatActivity() {

    //Otra forma (inicialización tardía)
    lateinit var binding:ActivityMainBinding

    lateinit var adapter: ItemAdapter

    //Con ? --> Optional
    //var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater) //traer referencia del elemento y coloca XML encima
        setContentView(binding.root)

        //Configuración de la Recycler
        adapter = ItemAdapter()
        binding.itemsRV.layoutManager = LinearLayoutManager(this)
        binding.itemsRV.setHasFixedSize(true) //Genera scroll
        binding.itemsRV.adapter = adapter

        //Generar el launcher (Main -> Menu, Menu -> Main)
        //Con val asigno, con var no
        val launcher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult(),
            ::onDataReceived
        )

        binding.addItemBtn.setOnClickListener{
            val intent = Intent(this, MenuActivity::class.java)
            //startActivity(intent) -->  Esta forma no sirve porque con startActivity no podemos hacer que la 2da actividad nos regrese info
            launcher.launch(intent)
        }
    }

    fun onDataReceived(result: ActivityResult){
        if(result.resultCode == RESULT_OK){
            val itemSelected = result.data?.extras?.getString("name")
            //Desempaquetamiento seguro
            itemSelected?.let{
                Log.e(">>>>>", it)
                adapter.addItem(Item(it, 10500.0))
            }
        }else if (result.resultCode == RESULT_CANCELED){

        }
    }
}