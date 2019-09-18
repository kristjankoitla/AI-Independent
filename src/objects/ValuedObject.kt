package objects

import java.awt.Color
import java.awt.Graphics

open class ValuedObject(
    var x: Double,
    var y: Double,
    var width: Int,
    var height: Int,
    var shape: String,
    var color: Color
) {

    var rotation = 0.0
    var xm = 0
    var ym = 0

    open fun tick(){}

    open fun draw(g: Graphics){
        xm = (x + width/2).toInt()
        ym = (y + height/2).toInt()

    }
}