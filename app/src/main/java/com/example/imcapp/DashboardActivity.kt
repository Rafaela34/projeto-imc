package com.example.imcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DashboardActivity : AppCompatActivity() {

    lateinit var tvNome: TextView
    lateinit var tvProfissao: TextView
    lateinit var tvAltura: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        supportActionBar!!.hide()

        tvNome = findViewById(R.id.edit_nome)
        tvProfissao = findViewById(R.id.edit_profissao)
        tvAltura = findViewById(R.id.edit_novo_altura)


        //Carregar os dados da SharedPrederences no campos da dashboard

        //Abrir o arquivo cadastro
         val arquivo = getSharedPreferences("cadastro", MODE_PRIVATE)

        //Pegar os dados do arquivo e jogar nos TexViews

        tvNome.text = arquivo.getString("nome", "")
        tvProfissao.text = arquivo.getString("profissao", "")
        tvAltura.text = arquivo.getFloat("altura", 0.0f).toString()


    }
}