package com.example.testingfragmenttofragment2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.testingfragmenttofragment2.databinding.FragmentOneBinding


class one : Fragment(), View.OnClickListener {
    lateinit var binding: FragmentOneBinding
    lateinit var navc: NavController


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOneBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button1.setOnClickListener {
            binding.text2.text = binding.text1.text
        }

        navc = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.next1).setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        navc?.navigate(R.id.action_one_to_two )
    }

    companion object {

        @JvmStatic
        fun newInstance() = one()
    }
}