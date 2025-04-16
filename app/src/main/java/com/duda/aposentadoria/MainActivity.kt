package com.duda.aposentadoria

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.duda.aposentadoria.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

        private lateinit var binding: ActivityMainBinding //lateinit: permite inicializar a variável sem passar nada para ela (não precisa atribuir nenhum valor: var nome:String="duda")

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater) //inflate: faz leitura
            setContentView(binding.root)

            //Dados para o Spinner
            val itens = listOf("Masculino" , "Feminino")

            //Configuração do Adapter
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, itens)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)

            //Associa o adapter ao Spinner
            binding.spinner.adapter = adapter

        }
}
