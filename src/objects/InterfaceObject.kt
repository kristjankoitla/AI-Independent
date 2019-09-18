package objects

import managers.ObjectManager
import tools.Config
import java.awt.Color
import java.awt.Font
import java.awt.Graphics

class InterfaceObject(val text: String, val x: Int, val y: Int) {

    val font = Config.font
    val fontColor = Config.fontColor

    fun draw(g: Graphics, om: ObjectManager){
        g.color = Color.BLACK

        val text = when(text){
            "frame" -> "frame: ${EnginePanel.frame}"
            "position" -> "x pos: %.2f".format(om.playerObjects[0].x) + " y pos: %.2f".format(om.playerObjects[0].y)
            "rotation" -> "rotation: ${om.playerObjects[0].rotation} degrees"
            "penSize" -> "pen size: ${Config.penSize} pixels"
            else -> text
        }

        g.font = font
        g.color = fontColor
        g.drawString(text, x, y)
    }

}