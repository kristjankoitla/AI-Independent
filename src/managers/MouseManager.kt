package managers

import tools.Config
import java.awt.Point
import java.awt.event.MouseEvent

import tools.Config.levelDrawnColor
import tools.Tools
import java.awt.event.MouseWheelEvent

//TODO convert to levelManager
object MouseManager {

    val rectSize = Config.levelRectSize
    val panelWidth = Config.panelWidth
    val levelDefaultColor = Config.levelDefaultColor
    //val levelDrawnColor = Config.levelDrawnColor

    var leftDown = false
    var rightDown = false

    fun mouseMoved(point: Point) {

        //om.valuedObjects[getObjectIndex(point)].color = Color.BLUE
    }

    //called when mouse is dragged; used for drawing
    fun mouseDragged(e: MouseEvent, om: ObjectManager){
        val point = e.point

        //draws if right button is down, deletes if not
        val holder = Tools.getObjectIndex(point, Config.penSize)
        for (i in holder)
            om.levelObjects[i].color = if (rightDown) levelDefaultColor else levelDrawnColor

    }

    //converts coordinates of mouse to ValuedObject index


    //button 1 == left; button 3 == right
    fun mousePressed(e: MouseEvent){
        if (e.button == 1) leftDown = true
        if (e.button == 3) rightDown = true
    }

    fun mouseReleased(e: MouseEvent){
        if (e.button == 1) leftDown = false
        if (e.button == 3) rightDown = false
    }

    fun mouseWheelMoved(e: MouseWheelEvent){
        if (e.wheelRotation == 1) Config.penSize += 2
        if (e.wheelRotation == -1 && Config.penSize > 2) Config.penSize -= 2
    }
}