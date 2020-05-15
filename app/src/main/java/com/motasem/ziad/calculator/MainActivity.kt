package com.motasem.ziad.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about -> {
                val i = Intent(this, AboutActivity::class.java)
                startActivity(i)
            }
            R.id.privacy -> {
                val i = Intent(this, PrivacyPolicyActivity::class.java)
                startActivity(i)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    var isNewOperation = true
    var oldNumber = ""
    lateinit var operation: String

    fun btnNumberEvent(view: View) {
        if (isNewOperation) {
            txtResult.text = " "
        }

        isNewOperation = false
        var tvNumber = txtResult.text.toString()
        val btnSelect = view as Button

        when (btnSelect.id) {
            btn0.id -> tvNumber += "0"
            btn1.id -> tvNumber += "1"
            btn2.id -> tvNumber += "2"
            btn3.id -> tvNumber += "3"
            btn4.id -> tvNumber += "4"
            btn5.id -> tvNumber += "5"
            btn6.id -> tvNumber += "6"
            btn7.id -> tvNumber += "7"
            btn8.id -> tvNumber += "8"
            btn9.id -> tvNumber += "9"
            btnPlusMinus.id -> tvNumber = "-$tvNumber"
            btnDot.id -> tvNumber += "."
        }

        txtResult.text = tvNumber


    }

    fun btnOperationEvent(view: View) {
        oldNumber = txtResult.text.toString()
        isNewOperation = true
        val btnSelect = view as Button

        when (btnSelect.id) {
            btnDivision.id -> operation = "/"
            btnMultiplication.id -> operation = "*"
            btnSubtraction.id -> operation = "-"
            btnAddition.id -> operation = "+"
            btnPercent.id -> operation = "%"
        }
    }

    fun btnEqualEvent(view: View) {
        val newNumber = txtResult.text.toString()
        var finalResult: Double? = null

        when (operation) {
            "/" -> finalResult = oldNumber.toDouble() / newNumber.toDouble()
            "*" -> finalResult = oldNumber.toDouble() * newNumber.toDouble()
            "-" -> finalResult = oldNumber.toDouble() - newNumber.toDouble()
            "+" -> finalResult = oldNumber.toDouble() + newNumber.toDouble()
            "%" -> finalResult = oldNumber.toDouble() % newNumber.toDouble()
        }
        txtResult.text = finalResult.toString()
        isNewOperation = true
    }

    fun btnClear(view: View) {
        isNewOperation = true
        txtResult.text = "0"
    }


}
