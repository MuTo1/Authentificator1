package com.example.authentificator1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class PersonActivity : AppCompatActivity() {

    private lateinit var personInfoTextView: TextView
    private lateinit var changePasswordButton: Button
    private lateinit var logOutButton: Button

    private lateinit var mAuth : FirebaseAuth



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person)
        mAuth = FirebaseAuth.getInstance()

        personInfoTextView = findViewById(R.id.PersonInfoTextView)
        changePasswordButton = findViewById(R.id.PasswordChangeButton)
        logOutButton = findViewById(R.id.LogOutButton)

        personInfoTextView.text = mAuth.currentUser?.uid

        logOutButton.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
            finish()
            mAuth.signOut()
        }
        changePasswordButton.setOnClickListener {
            startActivity(Intent(this, ChangePasswordActivity::class.java))
        }

    }
}