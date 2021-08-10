package com.example.datapassing

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.datapassing.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /* receiving the data from the first fragment */
        val bundle = SecondFragmentArgs.fromBundle(arguments)
        binding.textProduct.text = bundle.product
        binding.btnPurchase.setOnClickListener {
            val name = binding.editName.text.toString()
            val phone = binding.editNumber.text.toString()
            val card = binding.editCard.text.toString()
            val cvv = binding.editCvv.text.toString()
            // this is a demo only
            if (name.length > 2) {
                if (phone.length == 10) {
                    if (card.length == 12) {
                        if (cvv.length == 3) {
                            // transaction will happen someday
                            // and then we can switch to last fragment
                            moveToFragment(true)
                        } else {
                            moveToFragment(false)
                        }
                    } else {
                        binding.editCard.error = "card length is invalid"
                        binding.editCard.requestFocus()
                    }
                } else {
                    binding.editNumber.error = "phone number length is invalid"
                    binding.editNumber.requestFocus()
                }
            }
        }
    }

    private fun moveToFragment(b: Boolean) {
        val action = SecondFragmentDirections.actionSecondFragmentToSuccessFragment()
        action.paymentStatus = b
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}