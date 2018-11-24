package com.example.shankar.patterndemo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    private val providers = arrayListOf(AuthUI.IdpConfig.EmailBuilder().build(),
            AuthUI.IdpConfig.PhoneBuilder().build(),
            AuthUI.IdpConfig.GoogleBuilder().build())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        buttonLogin.setOnClickListener{v->
            if(FirebaseAuth.getInstance().currentUser != null){
                startActivity(Intent(this@Main2Activity, AuthenticatedUserActivity::class.java))
            } else {
                startActivityForResult(AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .setLogo(R.drawable.ic_menu_mylocation)
                        .setTosAndPrivacyPolicyUrls("https://medium.com/@jcmsalves",
                                "https://github.com/jcmsalves")
                        .build(),
                REQUEST_CODE_SIGN_IN)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_CODE_SIGN_IN){
            if(resultCode == Activity.RESULT_OK){
                startActivity(Intent(this@Main2Activity, AuthenticatedUserActivity::class.java))
            } else {
                Toast.makeText(this, "Failed to sign in", Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        private const val REQUEST_CODE_SIGN_IN = 201
    }
}
