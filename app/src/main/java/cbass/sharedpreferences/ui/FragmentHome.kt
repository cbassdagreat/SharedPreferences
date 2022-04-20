package cbass.sharedpreferences.ui

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cbass.sharedpreferences.R
import cbass.sharedpreferences.databinding.FragmentHomeBinding


class FragmentHome : Fragment() {

    lateinit var binding: FragmentHomeBinding
    lateinit var sharedPreferences: SharedPreferences
    var edad:String = ""
    var nombre:String = ""
    var idioma:String = ""
    var aleman:Boolean = true
    var ingles:Boolean = true
    var espanol:Boolean = true



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater)
        sharedPreferences = requireActivity().getSharedPreferences("archivo", Context.MODE_PRIVATE)
        val key: String? = arguments?.getString("nombre")
        with(binding)
        {
           // nicknameTitle.text = sharedPreferences.getString(nombre,nombre)
            //ageInput.hint = sharedPreferences.getString(edad,"")
            //nicknameInput.hint = sharedPreferences.getString(nombre,"")

            aleman = sharedPreferences.getBoolean("aleman", false)
            if (aleman == true)
            {
                cbAle.isChecked = true
            }
            ingles = sharedPreferences.getBoolean("ingles", false)
            if(ingles == true)
            {
                cbIng.isChecked = true
            }
            espanol = sharedPreferences.getBoolean("espanol", false)
            if (espanol == true)
            {
                cbEsp.isChecked = true
            }

            nombre = sharedPreferences.getString(key,"").toString()
            if (nombre != null)
            {
                nicknameTitle.text = nombre
                nicknameInput.text = nombre.toEditable()
            }
            otroLangInput.isEnabled = false
            cbOtro.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    otroLangInput.isEnabled = true

                } else {
                    otroLangInput.isEnabled = false
                }
            }
            edad = sharedPreferences.getString("edad","").toString()
            if (edad != null)
            {
                ageInput.text = edad.toEditable()
                //nicknameInput.hint = sharedPreferences.getString(key,"")
            }

            idioma = sharedPreferences.getString("idioma","").toString()
            if (idioma!=null)
            {
                otroLangInput.text = idioma.toEditable()
            }






            saveButton.setOnClickListener {
                //edad = ageInput.text.toString()
                //nombre = nicknameInput.text.toString()
                //idioma = otroLangInput.text.toString()
                //sharedPreferences.edit().putString(nombre,nombre).commit()
                //sharedPreferences.edit().putString(edad,edad).commit()
                //val nombre: String = sharedPreferences.

                nicknameTitle.text = nombre

                if (cbAle.isChecked)
                {
                    var aleman = true
                    sharedPreferences.edit().putBoolean("aleman",aleman).commit()

                }
                if (cbEsp.isChecked)
                {
                    var espanol = true
                    sharedPreferences.edit().putBoolean("espanol", espanol).commit()
                }
                if (cbIng.isChecked)
                {
                    var ingles = true
                    sharedPreferences.edit().putBoolean("ingles", ingles).commit()

                }
                if (nicknameInput.text!!.isNotEmpty())
                {
                    nombre = nicknameInput.text.toString()
                }
                if (ageInput.text!!.isNotEmpty())
                {
                    edad = ageInput.text.toString()
                }


                sharedPreferences.edit().putString("idioma",idioma.toString()).commit()
                sharedPreferences.edit().putString("nombre",nombre.toString()).commit()
                sharedPreferences.edit().putString("edad",edad.toString()).commit()




        }

        return binding.root


    }

}
    fun String.toEditable(): Editable =  Editable.Factory.getInstance().newEditable(this)

}