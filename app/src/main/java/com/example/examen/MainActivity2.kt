package com.example.examen

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.examen.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding : ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(DosPalabras())


        binding.bottonNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.DosPalabras -> replaceFragment(DosPalabras())
                R.id.Mitad -> replaceFragment(Mitad())
                R.id.quitar-> replaceFragment(quitar())

                else ->{

                }


            }
            true
        }




        }


    private fun replaceFragment(fragment: Fragment){
        val fragmentManager=supportFragmentManager
        val fragmentTransaction= fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layaout,fragment)
        fragmentTransaction.commit()

    }
}
