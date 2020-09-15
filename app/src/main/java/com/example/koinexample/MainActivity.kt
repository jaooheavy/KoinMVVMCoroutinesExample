package com.example.koinexample

import MainViewModel
import android.app.ProgressDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by inject()

    private val progressDialog: ProgressDialog by lazy {
        ProgressDialog(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progressDialog.setMessage("Aguarde...")

        viewModel.name.observe(this, {
            progressDialog.dismiss()
            tvMessage.text = it
        })

        tvMessage.setOnClickListener {
            progressDialog.show()
            viewModel.loadData()
        }
    }
}