package com.example.firstapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private val args: SecondFragmentArgs by navArgs()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val count = args.myArg
        val random = java.util.Random()
        var randomNumber = 0
        if (count > 0) {
            randomNumber = random.nextInt(count + 1)
        }

        view.findViewById<TextView>(R.id.textview_header).text =
                getString(R.string.random_heading, args.myArg)

        view.findViewById<TextView>(R.id.textview_random).text = randomNumber.toString()

        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }
}
