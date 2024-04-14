package com.example.mykotlinapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnAdd :Button
    private lateinit var btnSub :Button
    private lateinit var btnMul :Button
    private lateinit var btnDiv :Button
    private lateinit var etaA: TextView
    private lateinit var etaB:TextView
    private lateinit var resultTv:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        btnAdd = findViewById(R.id.add)
        btnSub = findViewById(R.id.sub)
        btnMul = findViewById(R.id.multiply)
        btnDiv = findViewById(R.id.divide)
        etaA = findViewById(R.id.eta_a)
        etaB=findViewById(R.id.eta_b)
        resultTv=findViewById(R.id.resultId)
        btnAdd.setOnClickListener(this)
        btnSub.setOnClickListener(this)
        btnMul.setOnClickListener(this)
        btnDiv.setOnClickListener(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(v: View?) {
        val a = etaA.text.toString().toDouble()
        val b = etaB.text.toString().toDouble()
        var result= 0.0
       when(v?.id){
           R.id.add->{ result=a+b}
           R.id.sub->{result=a-b}
           R.id.multiply->{result=a*b}
           R.id.divide->{result=a/b}
       }
        resultTv.text= "Result is $result"

    }
}