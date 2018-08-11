package com.developer.eric.voiceandtextmessenger

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginButton.setOnClickListener {
            val email = emailEditTextLogin.text.toString()
            val password = passwordEditTextLogin.text.toString()

            Log.d("Login", "Attempt login with email/pw: $email")

            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                .addOnSuccessListener {
                    val intent = Intent(this, LatestMessagesActivity::class.java)

                    // when back button is pressed avoids sending you back to register activity
                    // because the stack is cleared
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intent)
                }

                .addOnFailureListener {
                    Log.d("LoginActivity", it.toString())
                }
        }

        backToRegistrationTextView.setOnClickListener {
            finish()
        }
    }
}