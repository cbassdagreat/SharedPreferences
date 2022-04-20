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
import cbass.sharedpreferences.databinding.FragmentInicialBinding
import com.google.android.material.snackbar.Snackbar


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
                val bundle:Bundle = Bundle()
                bundle.putString("nombre",nombre)
                if (nameInput.text!!.isNotEmpty()) {
                    if (sharedPreferences.getString(nombre, "").equals(nombre)) {
                        Navigation.findNavController(requireView())
                            .navigate(R.id.action_fragmentInicial_to_fragmentHome,bundle)

                    } else {
                        sharedPreferences.edit().putString(nombre, nombre).commit()
                        /**sharedPreferences.edit().putString("user${getValor()}",nombre).commit()
                        for(i in 0..getValor())
                        {
                        if(i == 0)
                        {
                        log.i("TAG", sharedPreferences.getString("user",""))
                        }
                        }
                         **/
                        Navigation.findNavController(requireView())
                            .navigate(R.id.action_fragmentInicial_to_fragmentWelcome)
                    }



                }
                else{
                    Snackbar.make(contenedor, "Nombre no puede estar vacío", Snackbar.LENGTH_SHORT).show()
                }


            }



        }



        return binding.root
    }



}