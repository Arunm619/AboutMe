package com.freshworks.aboutme

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.freshworks.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    private var data : MyData = MyData("Arun sudharsan")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.myData = data
        binding.btnDone.setOnClickListener {

            val ds: String = binding.etNickname.text.toString()

            if (!ds.isEmpty() ) {
                binding.myData?.nickname = ds
                binding.tvNickname.text = ds
                Toast.makeText(this, "Cool, Updated your nickname ,$ds", Toast.LENGTH_SHORT).show()
                binding.tvNickname.visibility = View.VISIBLE
                binding.etNickname.visibility = View.GONE
                binding.btnDone.visibility = View.GONE
            }
            else
            {
                Toast.makeText(this, getString(R.string.cooltext), Toast.LENGTH_SHORT).show()

            }

            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(binding.btnDone.windowToken, 0)
        }




    }
}
