package com.example.uuu

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.uuu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    var CorrecyAnswer:Int = 0
    var NotCorrectAnswer:Int = 0

    var FirstNum:Int = 0
    var SecondNum:Int = 0
    var Index:Int = 0
    var SymbolArray:CharArray = charArrayOf('+','-','*','/')

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onClickStart(view: View)
    {
        Example()
    }

    fun onClickCheck(view: View)
    {
        if (SymbolArray[Index] == '+')
        {
            if (FirstNum + SecondNum == binding.editText.text.toString().toInt())
            {
                CorrecyAnswer++
            }
            else
            {
                NotCorrectAnswer++
            }
        }
        else if (SymbolArray[Index] == '-')
        {
            if (FirstNum - SecondNum == binding.editText.text.toString().toInt())
            {
                CorrecyAnswer++
            }
            else
            {
                NotCorrectAnswer++
            }
        }
        else if (SymbolArray[Index] == '*')
        {
            if (FirstNum * SecondNum == binding.editText.text.toString().toInt())
            {
                CorrecyAnswer++
            }
            else
            {
                NotCorrectAnswer++
            }
        }
        else if (SymbolArray[Index] == '/')
        {
            if (FirstNum / SecondNum == binding.editText.text.toString().toInt())
            {
                CorrecyAnswer++
            }
            else
            {
                NotCorrectAnswer++
            }
        }
        binding.txtCountCorrect.text = CorrecyAnswer.toString()
        binding.txtCountNotCorrect.text = NotCorrectAnswer.toString()



        binding.txtAllEnsvers.text =  (CorrecyAnswer + NotCorrectAnswer).toString()

        binding.txtProcent.text = ((CorrecyAnswer.toFloat() / (CorrecyAnswer + NotCorrectAnswer)) * 100f).toString() + "%"

        Example()
    }

    fun Example()
    {
        FirstNum = (0..99).random()
        SecondNum = (0..99).random()
        Index = (0..3).random()

        if (SymbolArray[Index] == '/')
        {
            while ((FirstNum % SecondNum) != 0)
            {
                FirstNum = (1..99).random()
                SecondNum = (1..99).random()
            }
        }

        binding.txtFirstNumber.text = FirstNum.toString()
        binding.txtSecopndNumber.text = SecondNum.toString()
        binding.txtSign.text = SymbolArray[Index].toString()
    }
}