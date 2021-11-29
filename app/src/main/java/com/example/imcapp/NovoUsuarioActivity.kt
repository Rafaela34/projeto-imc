package com.example.imcapp

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import java.util.*

class NovoUsuarioActivity : AppCompatActivity() {

    lateinit var editEmail: EditText
    lateinit var editSenha: EditText
    lateinit var editNome: EditText
    lateinit var editAltura: EditText
    lateinit var editProfissao: EditText
    lateinit var editDataNascimento: EditText
    lateinit var radioFeminino:  RadioButton
    lateinit var radioMasculino: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novo_usuario)

        editEmail = findViewById(R.id.edit_novo_email)
        editSenha = findViewById(R.id.edit_novo_senha)
        editNome = findViewById(R.id.edit_novo_nome)
        editAltura = findViewById(R.id.edit_novo_altura)
        editProfissao = findViewById(R.id.edit_novo_profissao)
        editDataNascimento = findViewById(R.id.edit_novo_dataNascimento)
        radioFeminino = findViewById(R.id.radio_feminino)
        radioMasculino = findViewById(R.id.radio_masculino)

        //abrr um calendario ao clicar no campo de nascimaneto
        editDataNascimento.setOnClickListener {
            abrirCalendario()
        }
    }

    private fun abrirCalendario() {

        val calendario = Calendar.getInstance()
            val dia = calendario.get(Calendar.DAY_OF_MONTH)
            val mes = calendario.get(Calendar.MONTH)
            val ano = calendario.get(Calendar.YEAR)

            val  dpd = DatePickerDialog(this,
                    DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->

                        var mesFinal = ""

                        if (month < 9){
                            mesFinal = "0{$month + 1}"

                        } else{

                            mesFinal = "{$month + 1}"
                        }
                        var diaFinal = ""

                        if(dayOfMonth < 10){
                            diaFinal = "0$dayOfMonth"
                        }else{
                            diaFinal = "$dayOfMonth"
                        }

                        editDataNascimento.setText("$dayOfMonth/{$mesFinal}/$year")

            }, ano, mes, dia)

            dpd.show()


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_novo_usuario, menu)

        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        // Salvar os dados do usuário em um sharedPreferences
        // Criar um arquivo sharedPreferences
        // Se o arquivo já existir o arquivo será aberto
        val dados = getSharedPreferences("cadastro", MODE_PRIVATE)

        // Criar umm editor para o arquivo
        val editor = dados.edit()
        editor.putString("email", editEmail.text.toString())
        editor.putString("senha", editSenha.text.toString())
        editor.putString("nome", editNome.text.toString())
        editor.putFloat("altura", editAltura.text.toString().toFloat())
        editor.putString("nascimento", editDataNascimento.text.toString())
        editor.putString("profissao", editProfissao.text.toString())
        editor.putString("sexo", if(radioFeminino.isChecked) "F" else "M")

        Toast.makeText(this, "Usuário cadastrado com suscesso!", Toast.LENGTH_SHORT).show()
        finish()

        editor.apply()

        return true
    }
}