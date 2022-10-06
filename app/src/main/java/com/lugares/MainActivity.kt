package com.lugares

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.ktx.auth
import android.util.Log
import android.widget.Toast
import com.lugares.databinding.ActivityMainBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth



class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        FirebaseApp.initializeApp(this)
        auth = Firebase.auth

        //Se define el metodo para el login
        binding.btLogin.setOnClickListener{
            haceLogin();
        }
    }

        //Se define el metodo para el Register
        binding.btRegister.setOnClickListener{
        haceRegister();
        }
}



    private fun haceRegister() {
        var email = binding.etMail.text.toString()
        var clave = binding.etClave.text.toString()

            //Se hace el registro

            auth.createUserWithEmailAndPassword(email,clave)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Log.d("Creando Usuario", "Registrado")
                        val user = auth.currentUser
                        if (user != null) {
                            actualiza(user)
                        }
                    } else {
                        Log.d("Creando Usuario", "Fallo")
                        Toast.makeText(baseContext, "Fallo", Toast.LENGTH_LONG).show()
                        actualiza(null)
                    }
                }
        }

private fun actualiza(user: FirebaseUser?) {
    if (user != null){
        val intent = Intent(this, Principal::class.java)
        startActivity(intent)
    }
}

//Esto hara que una vez autenticado... no pida mas o menos que se cierre la sesion
public override fun onStart() {
    super.onStart()
    val usuario= auth.currentUser
    actualiza(usuario)
}

}

}

private fun haceLogin() {
        var email = binding.etMail.text.toString()
        var clave = binding.etClave.text.toString()



    auth.signInWithEmailAndPassword(email,clave)
        .addOnCompleteListener(this) { task ->
            if (task.isSuccessful) {
                Log.d("Autenticando", "Autenticado")
                val user = auth.currentUser
                if (user != null) {
                    actualiza(user)
                }
            }else{
                Log.d("Autenticando", "Fallo")
                Toast.makeText(baseContext, "Fallo", Toast.LENGHT_LONG).show()
                actualiza(null)
            }
        }
}

