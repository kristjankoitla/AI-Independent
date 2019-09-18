package objects

import java.awt.Color
import java.awt.Graphics

class LevelObject(

    x: Double,
    y: Double,
    width: Int,
    height: Int,
    shape: String,
    color: Color)

    : ValuedObject(x, y, width, height, shape, color) {


    override fun draw(g: Graphics) {
        g.color = color
        if (shape.toUpperCase() == "RECTANGLE") g.fillRect(x.toInt(), y.toInt(), width, height)
        else if (shape.toUpperCase() == "OVAL") g.fillOval(x.toInt(), y.toInt(), width, height)
    }
}