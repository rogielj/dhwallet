package com.digitalhouse.dhwallet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_transaction.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(
                R.id.fragmentContainer, TransactionFragment.newInstance(
                    "R$ 45,35", "R$ 536"
                )
            )
//            .addToBackStack("transaction")
            .commit()
    }

//    private fun trocarFragment() {
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.fragmentContainer, TransferFragment())
//            .addToBackStack(null)
//            .commit()
//    }
}