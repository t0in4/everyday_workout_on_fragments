package com.example.testingfragmenttofragment2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.testingfragmenttofragment2.databinding.FragmentTwoBinding


class two : Fragment() {
    lateinit var binding: FragmentTwoBinding
    lateinit var navc2: NavController


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTwoBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button2.setOnClickListener {
            if (binding.digit1.text.toString().trim().isNotBlank() &&
                    binding.digit2.text.toString().trim().isNotEmpty()) {
                binding.result.text = (binding.digit1.text.toString().toInt() +
                        binding.digit2.text.toString().toInt()).toString()
                binding.operation.text = "${binding.digit1.text} + ${binding.digit2.text} = ${binding.result.text}"
            } else {
                binding.operation.text = "Please fill the cells"
            }
        }

        navc2 = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.next2).setOnClickListener {
            navc2.navigate(R.id.action_two_to_three)
        }
    }

  /*  override fun onClick(v: View?) {
        navc2?.navigate(R.id.action_one_to_two )
    }
*/
    companion object {

        @JvmStatic
        fun newInstance() = one()
    }


}