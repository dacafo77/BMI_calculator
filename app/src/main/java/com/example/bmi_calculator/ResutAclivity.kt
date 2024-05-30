package com.example.bmi_calculator

import android.graphics.Color
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.math.pow
import kotlin.math.round

class ResutAclivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resut_aclivity)

        val height = intent.getIntExtra("height", 0)
        val weight = intent.getIntExtra("weight", 0)

        //BMI 계산
        var value = weight / (height/100.0).pow(2.0)
        value = round(value*10)/10

        var resultText = ""
        var resImage = 0
        var resColor = 0

        if (value < 18.5) {
            resultText = "저체중"
            resImage = R.drawable.img_lv1
            resColor = Color.YELLOW
        } else if (value >= 18.5 && value < 23.0) {
            resultText = "정상 체중"
            resImage = R.drawable.img_lv2
            resColor = Color.GREEN
        } else if (value >= 23 && value < 25.0) {
            resultText = "과체중"
            resImage = R.drawable.img_lv3
            resColor = Color.BLUE
        } else if (value >= 25.0 && value < 30.0) {
            resultText = "경도 비만"
            resImage = R.drawable.img_lv3
            resColor = Color.BLACK
        } else if (value >= 30.0 && value < 35.0) {
            resultText = "경도비만"
            resImage = R.drawable.img_lv4
            resColor = Color.MAGENTA
        } else {
            resultText = "고도 비만"
            resImage = R.drawable.img_lv3
            resColor = Color.RED
        }

        val tv_resvalue = findViewById<TextView>(R.id.tv_resvalue)
        val tv_title = findViewById<TextView>(R.id.tv_title)
        val Iv_image = findViewById<ImageView>(R.id.Iv_image)
        val btn_back = findViewById<Button>(R.id.btn_back)

        tv_resvalue.text = value.toString()
        tv_title.text = resultText
        Iv_image.setImageResource(resImage)
        tv_resvalue.setTextColor(resColor)

        btn_back.setOnClickListener { finish()
        }
    }

    }
