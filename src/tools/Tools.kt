package tools

import managers.MouseManager
import java.awt.Color
import java.awt.Point

object Tools {

    fun toRad(degree: Double): Double{
        return(degree * Math.PI / 180.0)
    }

    fun clamp(value: Double, max: Double, min:Double): Double{
        if (value.compareTo(min) < 0) return min
        else if (value.compareTo(max) > 0) return max
        else return value
    }

    fun colorPicker(color: String): Color{
        return when(color){
            "red" -> Color.RED
            "orange" -> Color.ORANGE
            "yellow" -> Color.YELLOW
            "green" -> Color.GREEN
            "blue" -> Color.BLUE
            "purple" -> Color(128, 0, 128)
            "pink" -> Color.PINK
            "gray" -> Color.GRAY
            "lightGray" -> Color.LIGHT_GRAY
            else-> Color.BLACK
        }
    }

    fun getObjectIndex(point: Point, size: Int): ArrayList<Int>{
        val x = ((point.x)/ Config.levelRectSize)
        val y = ((point.y)/ Config.levelRectSize)

        val holder = arrayListOf<Int>()

        for (h in -(size-1)/2..(size-1)/2) {
            for (v in -(size-1)/2..(size-1)/2) {
                holder.add((x+v)+(y+h)*(Config.panelWidth / Config.levelRectSize))
            }
        }

        return (holder)
    }

}