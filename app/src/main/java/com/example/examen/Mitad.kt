package com.example.examen

import android.content.res.ColorStateList
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Mitad.newInstance] factory method to
 * create an instance of this fragment.
 */
class Mitad : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar el layout para este fragmento
        return inflater.inflate(R.layout.fragment_mitad, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Referencias a los elementos de la UI
        val inputText = view.findViewById<EditText>(R.id.inputText)
        val resultText = view.findViewById<TextView>(R.id.resultText)
        val solveButton = view.findViewById<Button>(R.id.solveButton)

        // Configuración del color del botón
        solveButton.backgroundTintList = ColorStateList.valueOf(
            ContextCompat.getColor(requireContext(), R.color.teal_200)
        )

        // Configuración del botón para solucionar el problema
        solveButton.setOnClickListener {
            val text = inputText.text.toString()
            val solution = solveProblem(text)
            resultText.text = solution
        }
    }

    // Función para cortar y reorganizar la cadena
    private fun solveProblem(text: String): String {
        val length = text.length
        val middle = length / 2

        // Si la longitud es impar, la primera mitad contiene un carácter más
        val firstHalf = text.substring(0, middle + (length % 2))
        val secondHalf = text.substring(middle + (length % 2), length)

        // Retorna la cadena con las mitades intercambiadas
        return "$secondHalf$firstHalf"
    }
}