package com.mkalegend.selfmarketing

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_preview_message.*

class PreviewMessageActivity : AppCompatActivity() {

    private lateinit var message: PreviewMessage
    private lateinit var messageString: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview_message)

        completeMessage()
        setupButton()
    }

    private fun completeMessage() {
        message = intent.getSerializableExtra("Message") as PreviewMessage
        messageString = """
                Hi, ${message.contactName}
                
                My name is ${message.displayName} and I am ${message.addJuniorStatus()}${message.spinnerPosition}.
                
                I have a portfolio of apps to demonstrate my technical skills that I can show on request. 
                
                I am able to start a new position ${message.getDate()}
                
                Please get in touch if you have a suitable position for me.
                
                Thanks and best regards
            """.trimIndent()

        textViewMessage.text = messageString
    }

    private fun setupButton() {
        buttonSendMessage.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("smsto:${message.contactNumber}")
                putExtra("sms_body", messageString)
            }
            startActivity(intent)
        }
    }

}