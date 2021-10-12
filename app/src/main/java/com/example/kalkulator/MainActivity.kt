package com.example.kalkulator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.example.kalkulator.databinding.ActivityMainBinding
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var stateNow : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.BTkirim.setOnClickListener { kirim() }
        binding.BTlingkaran.setOnClickListener {prepare("lingkaran") }
        binding.BTpersegi.setOnClickListener { prepare("persegi") }
        binding.BTsegitiga.setOnClickListener { prepare("segitiga") }
        setContentView(binding.root)
    }
    fun prepare(jenis : String){
        binding.CVmenu.visibility = View.VISIBLE
        binding.CVhasil.visibility = View.GONE

        binding.ETlebar.visibility =View.VISIBLE
        binding.TVlebar.visibility = View.VISIBLE

        binding.ETpanjang.setText("")
        binding.ETlebar.setText("")

        this.stateNow = jenis
        when (jenis){
            "lingkaran" -> {
                binding.TVpanjang.text = "Diameter"
                binding.ETlebar.visibility =View.GONE
                binding.TVlebar.visibility = View.GONE
            }
            "persegi" -> {
                binding.TVpanjang.text = "Panjang"
                binding.TVlebar.text = "Lebar"
            }
            "segitiga" -> {
                binding.TVpanjang.text = "Alas"
                binding.TVlebar.text = "Tinggi"
            }
        }
    }


    fun kirim(){
        binding.CVhasil.visibility = View.VISIBLE
        when (this.stateNow){
            "lingkaran" -> lingkaran()
            "persegi" -> persegi()
            "segitiga" -> segitiga()
        }
    }
    fun lingkaran(){
        val diameter = binding.ETpanjang.text.toString().toDouble()

        val luas : Double = 22/7 * (diameter/2)
        val keliling : Double = 22/7 * diameter

        binding.TVluas.text = "Luas : ${luas}"
        binding.TVkeliling.text = "Keliling : ${keliling}"
    }

    fun persegi(){
        val panjang = binding.ETpanjang.text.toString().toDouble()
        val lebar = binding.ETlebar.text.toString().toDouble()

        val luas : Double= panjang * lebar
        val keliling : Double= 2 * (panjang+ lebar)

        binding.TVluas.text = "Luas : ${luas}"
        binding.TVkeliling.text = "Keliling : ${keliling}"
    }
    fun segitiga(){
        val alas = binding.ETpanjang.text.toString().toDouble()
        val tinggi = binding.ETlebar.text.toString().toDouble()

        val luas: Double = alas * tinggi / 2
        val c : Double = sqrt(((tinggi * tinggi) + (alas * alas )))
        val keliling : Double = alas + luas + c

        binding.TVluas.text = "Luas : ${luas}"
        binding.TVkeliling.text = "Keliling : ${keliling}"

    }
}