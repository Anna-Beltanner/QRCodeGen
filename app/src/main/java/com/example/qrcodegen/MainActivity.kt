package com.example.qrcodegen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidmads.library.qrgenearator.QRGContents
import androidmads.library.qrgenearator.QRGEncoder
import com.google.zxing.WriterException

class MainActivity : AppCompatActivity() {

    var iv: ImageView? = null
    var buttonGenerate: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iv = findViewById(R.id.imageView)
        buttonGenerate = findViewById(R.id.button)
        buttonGenerate?.setOnClickListener {
            generateQR("Your QR code is generated!")

        }
    }


    private fun generateQR(text: String) {
        val codeGenerator = QRGEncoder(text, null, QRGContents.Type.TEXT, 500)
        try {
            val bitMap = codeGenerator.encodeAsBitmap()
            iv?.setImageBitmap(bitMap)
        } catch (e: WriterException) {

        }
    }
}





