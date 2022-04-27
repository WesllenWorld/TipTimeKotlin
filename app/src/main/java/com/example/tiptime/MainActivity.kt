package com.example.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calcularBotao.setOnClickListener{ calculateTip() }

    }

    private fun calculateTip() {
        val stringInTextField = binding.custoDeServico.text.toString()
        val custo = stringInTextField.toDouble()
        val porcentagem = when(binding.gorjetaOpcoes.checkedRadioButtonId){
            R.id.vinte_porcento -> 0.20
            R.id.dezoito_porcento -> 0.18
            else -> 0.15
        }
        var gorjeta = porcentagem * custo
        if(binding.arredondarGorjetaSwitch.isChecked
        ){
            gorjeta = kotlin.math.ceil(gorjeta)
        }
        val gorjetaFormatada = NumberFormat.getCurrencyInstance().format(gorjeta)
        binding.gorjetaResultado.text = getString(R.string.valor, gorjetaFormatada)
    }



}