package cbass.sharedpreferences.ui

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import cbass.sharedpreferences.R
import cbass.sharedpreferences.databinding.FragmentWelcomeBinding


class FragmentWelcome : Fragment() {

    lateinit var binding:FragmentWelcomeBinding
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWelcomeBinding.inflate(layoutInflater)

        //val user:User = arguments?.getSerializable("user") as User

        sharedPreferences = requireActivity().getSharedPreferences("archivo", MODE_PRIVATE)
        with(binding)
        {
            welcomeName.text = sharedPreferences.getString("nombre","")

            advanceButton.setOnClickListener {
                Navigation.findNavController(requireView()).navigate(R.id.action_fragmentWelcome_to_fragmentHome)
            }
        }

        return binding.root

    }


}