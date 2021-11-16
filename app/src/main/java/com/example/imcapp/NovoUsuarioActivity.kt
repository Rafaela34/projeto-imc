package com.example.imcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText

class NovoUsuarioActivity : AppCompatActivity() {

    lateinit var editEmail: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novo_usuario)

        editEmail = findViewById(R.id.edit_novo_email)
    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        returnInflater.inflate(R.menu_novo_usuario, menu)
//
//        return true
//    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        // Salvar os dados do usuário em um sharedPreferences
        // Criar um arquivo sharedPreferences
        // Se o arquivo já existir o arquivo será aberto
        val dados = getSharedPreferences("cadastro", MODE_PRIVATE)

        // Criar umm editor para o arquivo
        val editor = dados.edit()
        editor.putString("email", editEmail.text.toString())
        editor.apply()

        return true
    }
}