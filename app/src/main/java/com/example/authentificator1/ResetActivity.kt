package com.example.authentificator1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class ResetActivity : AppCompatActivity() {

    private lateinit var resetEmailTextView: TextView
    private lateinit var sendRequestButton: Button

    private lateinit var mAUTH : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset)

        mAUTH = FirebaseAuth.getInstance()

        resetEmailTextView = findViewById(R.id.RecoveryEmailEditText)
        sendRequestButton = findViewById(R.id.RecoveryRequestButton)

        sendRequestButton.setOnClickListener{
            val email = resetEmailTextView.text.toString()
            if (email.isEmpty()) {
                Toast.makeText(this, "Error!",Toast.LENGTH_LONG).show()
            } else {
                mAUTH.sendPasswordResetEmail(email).addOnCompleteListener { Task ->
                    if (Task.isSuccessful) {
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    } else {
                        Toast.makeText(this,"Error!",Toast.LENGTH_LONG).show()
                    }
                }
            }
        }



    }
}