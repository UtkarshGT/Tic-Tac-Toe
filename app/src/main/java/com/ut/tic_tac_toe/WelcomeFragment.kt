package com.ut.tic_tac_toe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.ut.tic_tac_toe.databinding.FragmentWelcomeBinding

/**
 * A simple [Fragment] subclass.
 * Use the [WelcomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // initialize binding variable
        val binding = DataBindingUtil.inflate<FragmentWelcomeBinding>(
            inflater,
            R.layout.fragment_welcome,
            container,
            false
        )

        // Start the game when play button is pressed
        binding.playButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_welcomeFragment_to_gameFragment)
        }

        return binding.root


    }

}