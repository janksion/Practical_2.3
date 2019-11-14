package com.example.practical_23

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalculate.setOnClickListener() {
            val carPrice: Double = txtCarPrice.text.toString().toDouble()
            val downPay: Double = txtDownPayment.text.toString().toDouble()
            val interestRate: Double = (txtInterestRate.text.toString().toDouble()) / 100
            val loanPeriod: Int = txtLoanPeriod.text.toString().toInt()

            val carLoan: Double
            val interest: Double
            val monthlyPay: Double

            carLoan = carPrice - downPay
            interest = carLoan * interestRate * loanPeriod
            monthlyPay = (carLoan + interest) / loanPeriod / 12

            lblMonthlyPay.text = "Your monthly payment is RM %.2f".format(monthlyPay)

            val inputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)

            val text = "Calculate Completed"
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(applicationContext, text, duration)
            toast.show()
        }

        btnReset.setOnClickListener{
            txtCarPrice.text.clear()
            txtDownPayment.text.clear()
            txtInterestRate.text.clear()
            txtLoanPeriod.text.clear()
            lblMonthlyPay.text = ""
        }
    }
}
