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

            //Dados para o Spinner: lista
            val genero = listOf("Masculino" , "Feminino")

            //Configuração do Adapter: faz a interface
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, genero) //Adapter = objeto que fazinterface entre a lista e a spinner
            //primeiro parametro: instância da tela / segundo parametro: layout / terceiro parâmetro:lista

            //Aplico o layout
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_item) //argumento: indica que a lista será expressa na vertical

            //Associa o adapter ao Spinner: preenche o spinner
            binding.genero.adapter = adapter

            //Acionando o botão CALCULAR
            binding.info.setOnClickListener {

                val idade = binding.idade.text.toString().toLong() //lê a idade inserida
                val sexo = binding.genero.selectedItem.toString() //lê o gênero indicado pelo usuário

                if (idade != null){
                    val calculo = if (sexo == "Masculino") { //calculando o tempo para a aposentadoria
                        65 - idade }
                    else {
                        62 - idade
                    }

                    binding.resultado.text = if(calculo > 0) {
                        "Faltam $calculo anos para você se aposentar." //$calculo recapitula o resultado para a pessoa ver quanto tempo falta
                    } else {
                        "Você já tem direito à aposentadoria."
                    }
                }

                else{
                    //MOSTRA ERRO CASO SEJA NULO
                    binding.resultado.text="Idade não informada. Digite no campo acima."
                }



            }
        }
}
