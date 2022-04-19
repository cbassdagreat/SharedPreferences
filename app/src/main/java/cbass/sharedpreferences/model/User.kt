package cbass.sharedpreferences.model

import java.io.Serializable

class User (var nombre:String):Serializable {

    override fun toString(): String{
        return nombre
    }
}