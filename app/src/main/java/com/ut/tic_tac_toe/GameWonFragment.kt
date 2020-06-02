package com.ut.tic_tac_toe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.ut.tic_tac_toe.databinding.FragmentGameWonBinding
import kotlinx.android.synthetic.main.fragment_game_won.*

/**
 * A simple [Fragment] subclass.
 * Use the [GameWonFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GameWonFragment : Fragment()
{

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        // initialize binding variable
        val binding = DataBindingUtil.inflate<FragmentGameWonBinding>(
            inflater,
            R.layout.fragment_game_won,
            container,
            false
        )

        // get player won int from gameFragment
        val args = GameWonFragmentArgs.fromBundle(requireArguments())
        val winner = args.winner

        if (winner == 1)
        {
            binding.winnerLogo.setImageResource(R.drawable.ic_circle)
            binding.winnerDisplay.text = "Player One Won !"
        } else
        {
            binding.winnerLogo.setImageResource(R.drawable.ic_cross)
            binding.winnerDisplay.text = "Player Two Won !"
        }

        return binding.root
    }

}