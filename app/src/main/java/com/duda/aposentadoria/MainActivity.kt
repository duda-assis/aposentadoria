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
            val genero = listOf("Masculino" , "Feminino")

            //Configuração do Adapter
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, genero)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)

            //Associa o adapter ao Spinner
            binding.genero.adapter = adapter

            //Acionando o botão CALCULAR
            binding.info.setOnClickListener {
                //verifica se o campo está vazio
                if(binding.idade.text.toString().isEmpty()){
                    //se estiver vazia, exibe comentário
                    binding.resultado.text = "Idade não informada. Preencha o campo acima."

                    //realiza a interrupção da execução
                    return@setOnClickListener
                }

            val idade = binding.idade.text.toString().toLong() //lê a idade inserida

            val sexo = binding.genero.selectedItem.toString() //lê o gênero indicado pelo usuário


            }
        }
}
