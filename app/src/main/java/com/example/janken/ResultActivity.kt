package com.example.janken

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView


class ResultActivity : AppCompatActivity() {

    val gu = 0
    val ch = 1
    val pa = 2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        //intentで送られ来たidを取り出す
        val id = intent.getIntExtra("MY_HAND" ,0)

        var myHandImage = findViewById<ImageView>(R.id.MyHandImage)
        var comHandImage = findViewById<ImageView>(R.id.ComHandImage)
        var resultLabel = findViewById<TextView>(R.id.ResultLabel)
        var backButton = findViewById<Button>(R.id.BackButton)

        val myHand: Int
        myHand = when(id){
            R.id.Gu -> {
                myHandImage.setImageResource(R.drawable.gu)
                gu  //0を代入
            }
            R.id.Choki -> {
                myHandImage.setImageResource(R.drawable.choki)
                ch
            }
            R.id.Pa -> {
                myHandImage.setImageResource(R.drawable.pa)
                pa
            }
            else -> gu
        }

        //コンピューターの手を決める
        val comHand = (Math.random() * 3).toInt()
        when(comHand){
            gu -> comHandImage.setImageResource(R.drawable.com_gu)
            ch -> comHandImage.setImageResource(R.drawable.com_choki)
            pa -> comHandImage.setImageResource(R.drawable.com_pa)
        }

        //勝敗判定
        val gameResult = (comHand - myHand +3) % 3
        when(gameResult){
            0 -> resultLabel.setText(R.string.result_draw)
            1 -> resultLabel.setText(R.string.result_win)
            2 -> resultLabel.setText(R.string.result_lose)
        }

        backButton.setOnClickListener { finish() }

    }
}