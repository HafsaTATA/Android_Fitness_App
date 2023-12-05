package com.firstapp.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.app.ProgressDialog
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class LoginActivity : AppCompatActivity() {
    private lateinit var btnGoogle: ImageView
    private lateinit var createNewAccount: TextView
    private lateinit var inputEmail: EditText
    private lateinit var inputPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var progressDialog: ProgressDialog

    private lateinit var mAuth: FirebaseAuth
    private lateinit var client: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        /*
        // move to sign up interface:
        val signUpButton = findViewById<TextView>(R.id.createNewAccount)

        signUpButton.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)


        }

        //houda:
        createNewAccount = findViewById(R.id.createNewAccount)
        inputEmail = findViewById(R.id.inputEmail)
        inputPassword = findViewById(R.id.inputPassword)
        btnLogin = findViewById(R.id.btnLogin)


        progressDialog = ProgressDialog(this)
        mAuth = FirebaseAuth.getInstance()


        btnLogin.setOnClickListener {
            performLogin()
        }

        createNewAccount.setOnClickListener {
            startActivity(Intent(this@LoginActivity, SignUpActivity::class.java))
        }

        btnGoogle = findViewById(R.id.btnGoogle)
        val options = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        client = GoogleSignIn.getClient(this, options)

        btnGoogle.setOnClickListener {
            val signInIntent = client.signInIntent
            startForResult.launch(signInIntent)
        }

         */
    }
/*
    private fun performLogin() {
        val email = inputEmail.text.toString()
        val password = inputPassword.text.toString()

        if (!email.matches(Regex("[a-zA-Z0-9._-]+@[a-z]+\\.[a-z]+"))) {
            inputEmail.error = "Enter Connext Email"
        } else if (password.isEmpty() || password.length < 6) {
            inputPassword.error = "Enter Proper Password"
        } else {
            progressDialog.setMessage("Please Wait While Login...")
            progressDialog.setTitle("Login")
            progressDialog.setCanceledOnTouchOutside(false)
            progressDialog.show()

            mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, OnCompleteListener<AuthResult> { task ->
                    if (task.isSuccessful) {
                        progressDialog.dismiss()
                        sendUserToNextActivity()
                        Toast.makeText(this@LoginActivity, "Login Successful", Toast.LENGTH_SHORT).show()
                    } else {
                        progressDialog.dismiss()
                        Toast.makeText(
                            this@LoginActivity,
                            "${task.exception}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                })
        }
    }

    private fun sendUserToNextActivity() {
        val intent = Intent(this@LoginActivity, SignUpActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

    private val startForResult: ActivityResultLauncher<Intent> =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val data: Intent? = result.data
                if (data != null) {
                    handleGoogleSignInResult(data)
                }
            }
        }
    private fun handleGoogleSignInResult(data: Intent) {
        val task = GoogleSignIn.getSignedInAccountFromIntent(data)
        try {
            val account = task.getResult(ApiException::class.java)
            val credential: AuthCredential = GoogleAuthProvider.getCredential(account!!.idToken, null)
            FirebaseAuth.getInstance().signInWithCredential(credential)
                .addOnCompleteListener(this, OnCompleteListener<AuthResult> { googleTask ->
                    if (googleTask.isSuccessful) {
                        val intent = Intent(applicationContext, LoginActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(
                            this@LoginActivity,
                            "Authentication Failed: ${googleTask.exception?.message}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                })

        } catch (e: ApiException) {
            Toast.makeText(
                this@LoginActivity,
                "Error retrieving Google account: ${e.message}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
    override fun onStart() {
        super.onStart()
        val user = FirebaseAuth.getInstance().currentUser
        if (user != null) {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
*/
}