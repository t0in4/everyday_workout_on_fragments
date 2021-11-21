package com.example.testingfragmenttofragment2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.testingfragmenttofragment2.databinding.FragmentThreeBinding


class three : Fragment() {
    lateinit var binding: FragmentThreeBinding
    lateinit var navc3: NavController


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThreeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.up.setOnClickListener {
            binding.imageView.y = binding.imageView.y - 12
        }

        binding.down.setOnClickListener {
            binding.imageView.y = binding.imageView.y + 12
        }

        binding.left.setOnClickListener {
            binding.imageView.x = binding.imageView.x - 12
        }

        binding.right.setOnClickListener {
            binding.imageView.x = binding.imageView.x + 12
        }

        binding.wanda.setOnClickListener {
            if (binding.imageView.visibility == View.INVISIBLE) {
                binding.imageView.visibility = View.VISIBLE
            } else {
                binding.imageView.visibility = View.INVISIBLE
            }
        }

        navc3 = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.next3).setOnClickListener {
            navc3.navigate(R.id.action_three_to_one)
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = three()
    }
}