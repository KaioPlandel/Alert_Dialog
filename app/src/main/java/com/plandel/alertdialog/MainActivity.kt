package com.plandel.alertdialog

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import com.plandel.alertdialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.firstDialog.setOnClickListener{

            AlertDialog.Builder(this)
                .setTitle("Delete Contact")
                .setMessage("Do you want to delete this contact?")
                .setIcon(R.drawable.ic_baseline_delete_24)
                .setPositiveButton("Yes",DialogInterface.OnClickListener { _, _ ->
                    Toast.makeText(this,"Deleted",Toast.LENGTH_SHORT).show()
                })
                .setNegativeButton("No",DialogInterface.OnClickListener { _, _->
                    Toast.makeText(this,"Not deleted",Toast.LENGTH_SHORT).show()
                })
                .create()
                .show()
        }

        binding.secondDialog.setOnClickListener{
            var options = arrayOf("item1","item2","item3","item4")

            AlertDialog.Builder(this)
                .setTitle("Choose one Option")
                .setMultiChoiceItems(options,null,DialogInterface.OnMultiChoiceClickListener { dialog, which, isChecked ->
                    Toast.makeText(this,"the item is $which and $isChecked",Toast.LENGTH_SHORT).show()
                })
                .setPositiveButton("yes",DialogInterface.OnClickListener { dialog, which ->
                    Toast.makeText(this,"ok",Toast.LENGTH_SHORT).show()
                })
                .create()
                .show()
        }
    }
}