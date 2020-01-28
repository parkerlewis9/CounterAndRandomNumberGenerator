package com.example.firstapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    var count = 0

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val showCountTextView = view.findViewById<TextView>(R.id.random_number_text)
        showCountTextView.text = count.toString()

        view.findViewById<Button>(R.id.random_button).setOnClickListener {
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(this.count)
            findNavController().navigate(action)
        }

        view.findViewById<Button>(R.id.toast_button).setOnClickListener {
            val myToast = Toast.makeText(context, "Hello Toast", Toast.LENGTH_SHORT)
            myToast.show()
        }

        view.findViewById<Button>(R.id.count_button).setOnClickListener {
            countMe(showCountTextView)
        }
    }

    fun countMe(view : TextView) {
        this.count++
        view.text = count.toString()
    }
}
