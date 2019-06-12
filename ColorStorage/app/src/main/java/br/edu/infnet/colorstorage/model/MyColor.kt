package br.edu.infnet.colorstorage.model


class MyColor(val color:Int = 0) {

    // vai ser útil
    companion object {
        fun fromRGB(r:Int, g: Int, b:Int, a:Int=255): MyColor{
            val color = convertFromRGB(r, g, b, a)
            return MyColor(color)
        }
        fun fromHex(hexCode: String): MyColor {
            val color = convertFromHex(hexCode)
            return MyColor(color)
        }
        fun convertFromRGB(r:Int, g: Int, b:Int, a:Int=255): Int{
            //TODO: fazer a conta
            return 0
        }
        fun convertFromHex(hexCode: String): Int{
            //TODO: fazer a conta
            return 0
        }
    }

}