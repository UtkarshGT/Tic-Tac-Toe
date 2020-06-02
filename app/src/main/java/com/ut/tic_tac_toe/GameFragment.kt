package com.ut.tic_tac_toe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.ut.tic_tac_toe.databinding.FragmentGameBinding

/**
 * A simple [Fragment] subclass.
 * Use the [GameFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GameFragment : Fragment()
{
    // Keep a track of which player played what location
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    // used to swap between player 1 and 2
    var activePlayer: Int = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        // initialize binding variable
        val binding = DataBindingUtil.inflate<FragmentGameBinding>(
            inflater,
            R.layout.fragment_game,
            container,
            false
        )

        // Set onClicks for button grid
        binding.button1.setOnClickListener { buttonClick(it) }
        binding.button2.setOnClickListener { buttonClick(it) }
        binding.button3.setOnClickListener { buttonClick(it) }

        binding.button4.setOnClickListener { buttonClick(it) }
        binding.button5.setOnClickListener { buttonClick(it) }
        binding.button6.setOnClickListener { buttonClick(it) }

        binding.button7.setOnClickListener { buttonClick(it) }
        binding.button8.setOnClickListener { buttonClick(it) }
        binding.button9.setOnClickListener { buttonClick(it) }

        // End game listener
        binding.endButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_gameFragment_to_welcomeFragment)
        }

        return binding.root
    }

    fun buttonClick(view: View)
    {
        val buttonSelected = view as ImageView
        var cellID = 0
        when (buttonSelected.id)
        {
            R.id.button1 -> cellID = 1
            R.id.button2 -> cellID = 2
            R.id.button3 -> cellID = 3

            R.id.button4 -> cellID = 4
            R.id.button5 -> cellID = 5
            R.id.button6 -> cellID = 6

            R.id.button7 -> cellID = 7
            R.id.button8 -> cellID = 8
            R.id.button9 -> cellID = 9
        }

        playGame(cellID, buttonSelected)
    }

    private fun playGame(cellID: Int, buttonSelected: ImageView)
    {
        // Add button played to the respective player Arrays

        var drawableResource = R.drawable.ic_circle

        if (activePlayer == 1)
        {
            drawableResource = R.drawable.ic_circle
            player1.add(cellID)
            activePlayer = 2
        } else
        {
            drawableResource = R.drawable.ic_cross
            player2.add(cellID)
            activePlayer = 1
        }

        // display img in click location
        buttonSelected.setImageResource(drawableResource)

        // disable the button
        buttonSelected.isEnabled = false

        checkWinner()

    }

    private fun checkWinner()
    {
        var winner = 0

        // First Row
        if (player1.contains(1) && player1.contains(2) && player1.contains(3))
        {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3))
        {
            winner = 2
        }

        // For Second Row
        if (player1.contains(4) && player1.contains(5) && player1.contains(6))
        {
            winner = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6))
        {
            winner = 2
        }

        // For Third Row
        if (player1.contains(7) && player1.contains(8) && player1.contains(9))
        {
            winner = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9))
        {
            winner = 2
        }

        // First Column
        if (player1.contains(1) && player1.contains(4) && player1.contains(7))
        {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7))
        {
            winner = 2
        }

        // For Second Column
        if (player1.contains(2) && player1.contains(5) && player1.contains(8))
        {
            winner = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8))
        {
            winner = 2
        }

        // For Third Columnm
        if (player1.contains(3) && player1.contains(6) && player1.contains(9))
        {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9))
        {
            winner = 2
        }

        // Check for Diagonal 1
        if (player1.contains(1) && player1.contains(5) && player1.contains(9))
        {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(5) && player2.contains(9))
        {
            winner = 2
        }
        // Check for Diagonal 2
        if (player1.contains(3) && player1.contains(5) && player1.contains(7))
        {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(5) && player2.contains(7))
        {
            winner = 2
        }

        if (winner != 0)
        {
            // Pass winner player number to Won fragment using safe args
            view?.findNavController()
                ?.navigate(GameFragmentDirections.actionGameFragmentToGameWonFragment(winner))
        }
    }
}