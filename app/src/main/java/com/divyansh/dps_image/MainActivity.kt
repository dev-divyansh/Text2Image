package com.divyansh.dps_image

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.chaquo.python.PyObject
import com.chaquo.python.Python
import com.divyansh.dps_image.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var Txt_data = binding.inputText.text.toString()



            binding.btnClick.setOnClickListener {

                var py: Python = Python.getInstance()
                var pyObject: PyObject = py.getModule("pyscript")

                if (binding.inputText.text.toString().isBlank() == true) {
                    Toast.makeText(this, "Enter some text", Toast.LENGTH_SHORT).show()
                } else {
                    try {
                        var pyobj: PyObject =
                            pyObject.callAttr("main", binding.inputText.text.toString())
                        Picasso.get()
                            .load(pyobj.toString())
                            .into(binding.resultImage)
                    }
                    catch(e : Exception) {
                        Toast.makeText(this , "invalid input statement - > response rejected by API" , Toast.LENGTH_SHORT).show()
                    }

                }
            }
        }

    }
