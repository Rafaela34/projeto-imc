package com.example.imcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var editEmail: EditText
    lateinit var editSenha: EditText
    lateinit var btEntrar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()

        val buttonCriarConta = findViewById<Button>(R.id.button_criar_conta)

        editEmail = findViewById(R.id.edit_email)
        editSenha = findViewById(R.id.edit_senha)
        btEntrar = findViewById(R.id.bt_entrar)

        btEntrar.setOnClickListener {
            login()
        }

        buttonCriarConta.setOnClickListener {
            val abrirCadastroImc = Intent(this, NovoUsuarioActivity::class.java)
            startActivity(abrirCadastroImc)
        }
    }

    private fun login() {
        val arquivo = getSharedPreferences("cadastro", MODE_PRIVATE)

        val email = arquivo.getString("email", "")
        val senha = arquivo.getString("senha", "")

        if (editEmail.text.toString() == email && editSenha.text.toString() == senha) {
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }else {
            Toast.makeText(this, "Usuario ou senha incorreta!!", Toast.LENGTH_SHORT).show()
        }
    }
}