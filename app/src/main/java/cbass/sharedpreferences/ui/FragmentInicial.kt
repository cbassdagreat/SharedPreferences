package cbass.sharedpreferences.ui

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import cbass.sharedpreferences.R
import cbass.sharedpreferences.databinding.FragmentInicialBinding
import cbass.sharedpreferences.model.User
import java.util.prefs.AbstractPreferences


class FragmentInicial : Fragment() {

    lateinit var binding: FragmentInicialBinding
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentInicialBinding.inflate(layoutInflater)
        sharedPreferences = requireActivity().getSharedPreferences("archivo", MODE_PRIVATE)


        with(binding)
        {
            loginButton.setOnClickListener {
                val nombre: String = nameInput.text.toString()
                val user:User = User(nombre)
                val bundle:Bundle = Bundle()
                bundle.putSerializable("user",user)
                sharedPreferences.edit().putString("nombre",nombre).commit()
                Navigation.findNavController(requireView()).navigate(R.id.action_fragmentInicial_to_fragmentWelcome)


            }



        }



        return binding.root
    }


}