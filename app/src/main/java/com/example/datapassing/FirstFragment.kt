package com.example.datapassing

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.datapassing.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnContinue.setOnClickListener {
            var product: String = ""
            when {
                binding.rCoffee.isChecked -> {
                    product = binding.rCoffee.text.toString()
                }
                binding.rEspresso.isChecked -> {
                    product = binding.rEspresso.text.toString()
                }
                binding.rIceCream.isChecked -> {
                    product = binding.rIceCream.text.toString()
                }
            }

            /* create an object*/
            val dir = FirstFragmentDirections.actionFirstFragmentToSecondFragment()

            /* set the argument value to send it to second fragment */
            dir.product = product

            /* launching the second fragment with the value */
            findNavController().navigate(dir)

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}