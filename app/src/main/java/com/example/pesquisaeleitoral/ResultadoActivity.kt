package com.example.pesquisaeleitoral

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultadoActivity : AppCompatActivity() {

    private lateinit var textViewNome: TextView
    private lateinit var textViewTitulo: TextView
    private lateinit var textViewZona: TextView
    private lateinit var textViewSecao: TextView
    private lateinit var textViewCidade: TextView
    private lateinit var textViewEstado: TextView

    private lateinit var imageViewPrefeito: ImageView
    private lateinit var textViewPrefeitoNome: TextView
    private lateinit var textViewPrefeitoNum: TextView
    private lateinit var textViewPartidoPre: TextView

    private lateinit var imageViewVereador: ImageView
    private lateinit var textViewVereadorNome: TextView
    private lateinit var textViewVereadorNum: TextView
    private lateinit var textViewPratido: TextView

   /* override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        // Referência ao TextView no layout
        val textViewWelcome: TextView = findViewById(R.id.textViewWelcome)

        // Recebe o nome de usuário da MainActivity
        val username = intent.getStringExtra("USERNAME")

        // Define o texto de boas-vindas
        textViewWelcome.text = "Bem-vindo, $username!"
    }
}*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        // Inicializando os campos de texto e imagem
        textViewNome = findViewById(R.id.textViewNome)
        textViewTitulo = findViewById(R.id.textViewTitulo)
        textViewZona = findViewById(R.id.textViewZona)
        textViewSecao = findViewById(R.id.textViewSecao)
        textViewCidade = findViewById(R.id.textViewCidade)
        textViewEstado = findViewById(R.id.textViewEstado)

        imageViewPrefeito = findViewById(R.id.imageView2)
        textViewPrefeitoNome = findViewById(R.id.textViewprefeito)
        textViewPrefeitoNum = findViewById(R.id.textViewPrefeitoNum)
        textViewPartidoPre = findViewById(R.id.textViewPartidoPre)

        imageViewVereador = findViewById(R.id.imageView)
        textViewVereadorNome = findViewById(R.id.textViewVereadorNome)
        textViewVereadorNum = findViewById(R.id.textViewVereadorNum)
        textViewPratido = findViewById(R.id.textViewPratido)

       // Obtendo os IDs das imagens
      // val idImagemPrefeito = intent.getIntExtra("ID_IMAGEM_PREFEITO", R.drawable.default_image)
       //val idImagemVereador = intent.getIntExtra("ID_IMAGEM_VEREADOR", R.drawable.default_image)


       // Recebendo os dados da Intent
        val nome = intent.getStringExtra(MainActivity.KEY_USERNAME) ?: ""
        val titulo = intent.getStringExtra(MainActivity.KEY_NUMTITULO) ?: ""
        val zona = intent.getStringExtra(MainActivity.KEY_NUMZONA) ?: ""
        val secao = intent.getStringExtra(MainActivity.KEY_NUMSECAO) ?: ""
        val cidade = intent.getStringExtra(MainActivity.KEY_CIDADE) ?: ""
        val estado = intent.getStringExtra(MainActivity.KEY_ESTADO) ?: ""

        val prefeitoNome = intent.getStringExtra("prefeitoNome") ?: ""
        val prefeitoNum = intent.getStringExtra("prefeitoNum") ?: ""
        val vereadorNome = intent.getStringExtra("vereadorNome") ?: ""
        val vereadorNum = intent.getStringExtra("vereadorNum") ?: ""

       //val imgPrefeito = intent.getStringExtra("ID_IMAGEM_PREFEITO") ?: ""
       val imgPrefeito = intent.getIntExtra("ID_IMAGEM_PREFEITO", 0)
       val imgVereador = intent.getIntExtra("ID_IMAGEM_VEREADOR", 0)

       //val imgVereador = intent.getStringExtra("imagemVereador") ?: ""


        // Definindo os valores nos TextViews
        textViewNome.text = "Nome: $nome"
        textViewTitulo.text = "Título: $titulo"
        textViewZona.text = "Zona: $zona"
        textViewSecao.text = "Seção: $secao"
        textViewCidade.text = "Cidade: $cidade"
        textViewEstado.text = "Estado: $estado"

        textViewPrefeitoNome.text = prefeitoNome
        textViewPrefeitoNum.text = prefeitoNum
       imageViewPrefeito.setImageResource(imgPrefeito)

       textViewVereadorNome.text = vereadorNome
        textViewVereadorNum.text = vereadorNum
        //imageViewVereador.setImageResource(R.drawable.tse_logo)
       imageViewVereador.setImageResource(imgVereador)



        // Botão de fechar
        findViewById<Button>(R.id.button).setOnClickListener {
            finish() // Fecha a atividade
        }
    }
}
