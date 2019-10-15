package com.example.shankar.patterndemo

import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.shankar.patterndemo.utils.AppSignatureHelper
import com.firebase.ui.auth.AuthUI
import com.google.android.gms.auth.api.credentials.Credential
import com.google.android.gms.auth.api.credentials.Credentials
import com.google.android.gms.auth.api.credentials.HintRequest
import com.google.android.gms.auth.api.phone.SmsRetriever
import com.google.android.gms.common.api.CommonStatusCodes
import com.google.android.gms.common.api.Status
import kotlinx.android.synthetic.main.activity_authenticated_user.*






class AuthenticatedUserActivity : AppCompatActivity() {

    private val RESOLVE_HINT = 100
    private val mCredentialsApiClient by lazy { Credentials.getClient(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authenticated_user)

        buttonLogout.setOnClickListener{v->
            AuthUI.getInstance().signOut(this).addOnCompleteListener {
                Toast.makeText(this, "User signed out", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
        buttonDelete.setOnClickListener{v->
            AuthUI.getInstance()
                    .delete(this)
                    .addOnCompleteListener {
                        Toast.makeText(this, "User account deleted", Toast.LENGTH_SHORT).show()
                        finish()
                    }
        }

        AppSignatureHelper.getAppSignatures(this)

        editTextPhone.onFocusChangeListener = View.OnFocusChangeListener { v, hasFocus ->
            if(hasFocus){
                requestHint()
            }
        }

        buttonGenerate.setOnClickListener{v->
            startSMSListener()
        }

        textView.movementMethod = ScrollingMovementMethod()

    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(smsReceiver)
    }


    // Construct a request for phone numbers and show the picker
    private fun requestHint() {
        val hintRequest = HintRequest.Builder()
                .setPhoneNumberIdentifierSupported(true)
                .build()

        val intent = mCredentialsApiClient.getHintPickerIntent(hintRequest)
        startIntentSenderForResult(intent.intentSender,
                RESOLVE_HINT, null, 0, 0, 0)
    }

    // Obtain the phone number from the result
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RESOLVE_HINT) {
            if (resultCode == Activity.RESULT_OK) {
                val credential:Credential = data!!.getParcelableExtra(Credential.EXTRA_KEY)
                // credential.getId();  <-- will need to process phone number string
                editTextPhone.setText(credential.id)
            }
        }
    }

    private fun startSMSListener(){
        val client = SmsRetriever.getClient(this /* context */)
        val task = client.startSmsRetriever()
        task.addOnSuccessListener {result->
            Log.i("startSMSListener", "success, result="+result)
            // Successfully started retriever, expect broadcast intent
            registerReceiver(smsReceiver, IntentFilter(SmsRetriever.SMS_RETRIEVED_ACTION))
        }

        task.addOnFailureListener {e->
            Log.i("startSMSListener", "failure, e="+e)
            // Failed to start retriever, inspect Exception for more details
            // ...
        }
    }



    val smsReceiver = object: BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            if (SmsRetriever.SMS_RETRIEVED_ACTION == intent.action) {
                val extras = intent.extras
                val status = extras!!.get(SmsRetriever.EXTRA_STATUS) as Status

                when (status.statusCode) {
                    CommonStatusCodes.SUCCESS ->{
                        // Get SMS message contents
                        val message: String = extras.get(SmsRetriever.EXTRA_SMS_MESSAGE) as String
                        textView.text = message
                        Toast.makeText(this@AuthenticatedUserActivity, "message received: "+message, Toast.LENGTH_LONG).show()
                    }
                    CommonStatusCodes.TIMEOUT -> {

                    }
                }
            }
        }
    }

}
