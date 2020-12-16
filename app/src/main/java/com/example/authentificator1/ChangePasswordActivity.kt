package com.example.authentificator1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class ChangePasswordActivity : AppCompatActivity() {

    private lateinit var changePasswordEditText : EditText
    private lateinit var changePasswordButton: Button
    private lateinit var mAUTH : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)

        mAUTH = FirebaseAuth.getInstance()
        changePasswordEditText = findViewById(R.id.ChangePasswordEditText)
        changePasswordButton = findViewById(R.id.ChangeResetButton)

        changePasswordButton.setOnClickListener {
            val newPassword = changePasswordEditText.text.toString()
            if (newPassword.isEmpty()) {
                Toast.makeText(this, "Empty!",Toast.LENGTH_LONG).show()
            } else {
                mAUTH.currentUser?.updatePassword(newPassword)
                    ?.addOnCompleteListener { task ->
                        if(task.isSuccessful) {
                            startActivity(Intent(this, PersonActivity::class.java))
                            finish()
                        } else {
                            Toast.makeText(this, "Error!",Toast.LENGTH_LONG).show()
                        }
                }
            }
        }
    }
}