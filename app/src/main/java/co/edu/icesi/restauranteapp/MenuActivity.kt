package co.edu.icesi.restauranteapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import co.edu.icesi.restauranteapp.databinding.ActivityMainBinding
import co.edu.icesi.restauranteapp.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {

    lateinit var binding:ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.aBtn.setOnClickListener(::selectItem)
        binding.bBtn.setOnClickListener(::selectItem)
        binding.cBtn.setOnClickListener(::selectItem)
    }

    fun selectItem(view: View){
        val button = view as Button
        var text = button.text
        val intent = Intent()
        intent.putExtra("name",text)
        setResult(RESULT_OK,intent)
        finish()
    }

}