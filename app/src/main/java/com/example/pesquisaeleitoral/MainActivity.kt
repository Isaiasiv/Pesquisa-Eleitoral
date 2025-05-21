package com.example.pesquisaeleitoral

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var nomeCompleto: EditText
    private lateinit var numberTitulo: EditText
    private lateinit var numberZona: EditText
    private lateinit var numberSecao: EditText
    private lateinit var cidade: EditText
    private lateinit var spinnerEstado: Spinner
    private var estadoSelecionado: String = ""

    companion object {
        const val KEY_USERNAME = "USERNAME"
        const val KEY_NUMTITULO = "NUMTITULO"
        const val KEY_NUMZONA = "NUMZONA"
        const val KEY_NUMSECAO = "NUMSECAO"
        const val KEY_CIDADE = "CIDADE"
        const val KEY_ESTADO = "ESTADO"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializando os campos de texto
        nomeCompleto = findViewById(R.id.NomeCompleto)
        numberTitulo = findViewById(R.id.NumberTitulo)
        numberZona = findViewById(R.id.editTextNumberZona)
        numberSecao = findViewById(R.id.editTextNumberSecao)
        cidade = findViewById(R.id.editTextCidade)
        spinnerEstado = findViewById(R.id.spinnerEstado)

        // Carregar os estados do arquivo strings.xml
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.estados,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerEstado.adapter = adapter

        // Configurando o listener do Spinner
        spinnerEstado.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                estadoSelecionado = parent?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        // Botão próximo
        val buttonProximo: Button = findViewById(R.id.proximo)
        buttonProximo.setOnClickListener {
            if (validarCampos()) {
                // Criando o Intent para enviar os dados à ResultadoActivity
                val intentResultado = Intent(this, ResultadoActivity::class.java).apply {
                    putExtra(KEY_USERNAME, nomeCompleto.text.toString())
                    putExtra(KEY_NUMTITULO, numberTitulo.text.toString())
                    putExtra(KEY_NUMZONA, numberZona.text.toString())
                    putExtra(KEY_NUMSECAO, numberSecao.text.toString())
                    putExtra(KEY_CIDADE, cidade.text.toString())
                    putExtra(KEY_ESTADO, estadoSelecionado)


                }

                // Passar o Intent para a SelectActivity
                val intentSelect = Intent(this, SelectActivity::class.java).apply {
                    putExtras(intentResultado)
                }

                startActivity(intentSelect)
            } else {
                Toast.makeText(this, "Por favor, preencha todos os campos obrigatórios.", Toast.LENGTH_SHORT).show()
            }
        }

        // Ajustando o padding conforme o insets do sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    //vericica se todos campos foi prenxidos
    private fun validarCampos(): Boolean {
        return nomeCompleto.text.isNotEmpty() &&
                numberTitulo.text.isNotEmpty() &&
                numberZona.text.isNotEmpty() &&
                numberSecao.text.isNotEmpty() &&
                cidade.text.isNotEmpty() &&
                estadoSelecionado.isNotEmpty()
    }
}
