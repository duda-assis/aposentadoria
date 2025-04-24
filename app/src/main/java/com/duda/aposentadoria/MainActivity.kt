package com.duda.aposentadoria

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.duda.aposentadoria.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

        private lateinit var binding: ActivityMainBinding //cria a tela //lateinit: permite inicializar a variável sem passar nada para ela (não precisa atribuir nenhum valor: var nome:String="duda")

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater) //inflate: faz leitura
            setContentView(binding.root) //imprime tela

            //Dados para o Spinner
            val genero = listOf("Masculino" , "Feminino")

            //Configuração do Adapter
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, genero) //Adapter = objeto que fazinterface entre a lista e a spinner

            //Aplico o layout
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_item) //argumento: indica que a lista será expressa na vertical

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

                val calculo = if (sexo == "Masculino") 65 - idade else 62 - idade //calculando o tempo para a aposentadoria

                binding.resultado.text = if(calculo > 0) {
                    "Faltam $calculo anos para você se aposentar." //$calculo recapitula o resultado para a pessoa ver quanto tempo falta
                } else {
                    "Você já tem direito à aposentadoria."
                }
            }
        }
}
