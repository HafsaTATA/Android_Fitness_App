package com.firstapp.app

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class SignUpActivity : AppCompatActivity() {
    private  lateinit var inputUsername: EditText
    private lateinit var inputEmail: EditText
    private lateinit var inputPassword: EditText
    private lateinit var inputConfirmPassword: EditText
    private lateinit var btnSignUp: Button
    private lateinit var progressDialog: ProgressDialog

    private lateinit var mAuth: FirebaseAuth
    private var mUser: FirebaseUser? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        inputUsername = findViewById(R.id.inputUsername)
        inputEmail = findViewById(R.id.inputEmail)
        inputPassword = findViewById(R.id.inputPassword)
        inputConfirmPassword = findViewById(R.id.confirm_mdp)

        btnSignUp = findViewById(R.id.btnCreate)
        progressDialog = ProgressDialog(this)
        mAuth = FirebaseAuth.getInstance()


        btnSignUp.setOnClickListener {
            performAuth()
        }
    }

    private fun performAuth() {
        val username = inputUsername.text.toString()
        val email = inputEmail.text.toString()
        val password = inputPassword.text.toString()
        val confirmPassword = inputConfirmPassword.text.toString()

        if (username.isEmpty()) {
            inputUsername.error = "Enter Connext UserName"
        }else if (!email.matches(Regex("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"))) {
            inputEmail.error = "Enter Connext Email"
        } else if (password.isEmpty() || password.length < 6) {
            inputPassword.error = "Enter Proper Password"
        } else if (password != confirmPassword) {
            inputConfirmPassword.error = "Password Not match Both field"
        } else {
            progressDialog.setMessage("Pease Wait While Registration...")
            progressDialog.setTitle("Registration")
            progressDialog.setCanceledOnTouchOutside(false)
            progressDialog.show()

            mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, OnCompleteListener<AuthResult> { task ->
                    if (task.isSuccessful) {
                        progressDialog.dismiss()
                        sendUserToNextActivity()
                        Toast.makeText(this@SignUpActivity, "Registration Successful", Toast.LENGTH_SHORT).show()
                    } else {
                        progressDialog.dismiss()
                        Toast.makeText(this@SignUpActivity, "${task.exception}", Toast.LENGTH_SHORT).show()
                    }
                })
        }
    }

    private fun sendUserToNextActivity() {
        val intent = Intent(this@SignUpActivity, HomeActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }
}