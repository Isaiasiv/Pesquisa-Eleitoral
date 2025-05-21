package com.example.pesquisaeleitoral

import ExpertPrefeito
import ExpertVereador
import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SelectActivity : AppCompatActivity() {

    private lateinit var spinnerPrefeito: Spinner
    private lateinit var spinnerVereador: Spinner
    private lateinit var imageViewPrefeito: ImageView
    private lateinit var textViewPrefeitoNome: TextView
    private lateinit var textViewPrefeitoNum: TextView

    private lateinit var imageViewVereador: ImageView
    private lateinit var textViewVereadorNome: TextView
    private lateinit var textViewVereadorNum: TextView

    private var idImagemPrefeito: Int = 0 // Adicionando a variável para armazenar o ID da imagem do prefeito
    private var idImagemVereador: Int = 0
    private var idImagem: Int = 0
    private var idImagemV: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select)

        spinnerPrefeito = findViewById(R.id.spinnerPrefeito)
        spinnerVereador = findViewById(R.id.spinnerVereador)
        imageViewPrefeito = findViewById(R.id.imageViewPrefeito)
        textViewPrefeitoNome = findViewById(R.id.textViewPrefeitoNome)
        textViewPrefeitoNum = findViewById(R.id.textViewPrefeitoNum)

        imageViewVereador = findViewById(R.id.imageViewVereador)
        textViewVereadorNome = findViewById(R.id.textViewVereadorNome)
        textViewVereadorNum = findViewById(R.id.textViewVereadorNum)

        setupSpinners()

        val buttonConfirmar: Button = findViewById(R.id.confirmar)
        buttonConfirmar.setOnClickListener {
            // Validação para garantir que ambos os candidatos foram selecionados
            if (textViewPrefeitoNome.text.isNotEmpty() && textViewVereadorNome.text.isNotEmpty()) {
                val prefeitoNome = textViewPrefeitoNome.text.toString()
                val prefeitoNum = textViewPrefeitoNum.text.toString()
                val vereadorNome = textViewVereadorNome.text.toString()
                val vereadorNum = textViewVereadorNum.text.toString()
                // Obter os dados do Intent

                val username = intent.getStringExtra(MainActivity.KEY_USERNAME)
                val numTitulo = intent.getStringExtra(MainActivity.KEY_NUMTITULO)
                val numZona = intent.getStringExtra(MainActivity.KEY_NUMZONA)
                val numSecao = intent.getStringExtra(MainActivity.KEY_NUMSECAO)
                val cidade = intent.getStringExtra(MainActivity.KEY_CIDADE)
                val estado = intent.getStringExtra(MainActivity.KEY_ESTADO)

                val intent = Intent(this, ResultadoActivity::class.java)
                intent.putExtra("prefeitoNome", prefeitoNome)
                intent.putExtra("prefeitoNum", prefeitoNum)
                intent.putExtra("vereadorNome", vereadorNome)
                intent.putExtra("vereadorNum", vereadorNum)
                intent.putExtra("ID_IMAGEM_PREFEITO", idImagem)
                intent.putExtra("ID_IMAGEM_VEREADOR", idImagemV)

                intent.putExtra(MainActivity.KEY_USERNAME, username)
                intent.putExtra(MainActivity.KEY_NUMTITULO, numTitulo)
                intent.putExtra(MainActivity.KEY_NUMZONA, numZona)
                intent.putExtra(MainActivity.KEY_NUMSECAO, numSecao)
                intent.putExtra(MainActivity.KEY_CIDADE, cidade)
                intent.putExtra(MainActivity.KEY_ESTADO, estado)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Por favor, selecione um prefeito e um vereador.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setupSpinners() {
        val prefeitos = arrayOf("Selecione um prefeito", "Junio", "Viviam", "Gabriel", "Paulo")
        val vereadores = arrayOf("Selecione um vereador", "Julio", "Jocivam", "Amaury", "Paulo", "Rachel", "Jaime")

        val adapterPrefeito = ArrayAdapter(this, android.R.layout.simple_spinner_item, prefeitos)
        adapterPrefeito.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerPrefeito.adapter = adapterPrefeito

        val adapterVereador = ArrayAdapter(this, android.R.layout.simple_spinner_item, vereadores)
        adapterVereador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerVereador.adapter = adapterVereador

        spinnerPrefeito.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: android.view.View, position: Int, id: Long) {
                if (position > 0) {
                    val selecionado = prefeitos[position]
                    val candidatoInfo = ExpertPrefeito().getCandidato(selecionado)
                    textViewPrefeitoNome.text = candidatoInfo[0] as String
                    textViewPrefeitoNum.text = candidatoInfo[1] as String
                    idImagem = candidatoInfo[3] as Int // Obtém o ID da imagem
                    imageViewPrefeito.setImageResource(idImagem) // Define a imagem correspondente
                    //imageViewPrefeito.setImageResource(candidatoInfo[3] as Int) // Define a imagem correspondente
                } else {
                    clearPrefeitoInfo()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        spinnerVereador.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: android.view.View, position: Int, id: Long) {
                if (position > 0) {
                    val selecionado = vereadores[position]
                    val candidatoInfo = ExpertVereador().getCandidato(selecionado)
                    textViewVereadorNome.text = candidatoInfo[0] as String
                    textViewVereadorNum.text = candidatoInfo[1] as String
                    idImagemV = candidatoInfo[3] as Int // Obtém o ID da imagem
                    imageViewVereador.setImageResource(idImagemV) // Define a imagem correspondente
                    //imageViewVereador.setImageResource(candidatoInfo[3] as Int) // Define a imagem correspondente
                } else {
                    clearVereadorInfo()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }

    private fun clearPrefeitoInfo() {
        textViewPrefeitoNome.text = ""
        textViewPrefeitoNum.text = ""
        imageViewPrefeito.setImageResource(0) // Limpa a imagem
    }

    private fun clearVereadorInfo() {
        textViewVereadorNome.text = ""
        textViewVereadorNum.text = ""
        imageViewVereador.setImageResource(0) // Limpa a imagem
    }
}
