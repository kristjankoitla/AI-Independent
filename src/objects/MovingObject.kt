package objects

import tools.Config
import java.awt.Color
import java.awt.Graphics
import tools.Tools

open class MovingObject(

    x: Double,
    y: Double,
    width: Int,
    height: Int,
    shape: String,
    color: Color,
    val speed: Int,
    val rotateSpeed: Int)

    : ValuedObject(x, y, width, height, shape, color) {

    val panelWidth = Config.panelWidth
    val panelHeight = Config.panelHeight

    var right = false
    var left = false
    var up = false
    var down = false

    override fun draw(g: Graphics){
        xm = (x + width/2).toInt()
        ym = (y + height/2).toInt()

        g.color = Config.playerRayColor
        g.drawLine(
            xm, ym,
            xm + (100*Math.sin(Tools.toRad(rotation))).toInt(),
            ym - (100*Math.cos(Tools.toRad(rotation))).toInt()
        )

        g.color = color
        g.fillOval(x.toInt(), y.toInt(), width, height)
    }

    override fun tick(){
        //TODO collision
        if (rotation >= 360.0) rotation -= 360.0
        if (rotation <= 0) rotation += 360.0

        if (right) rotation += rotateSpeed
        if (left) rotation -= rotateSpeed

        if (up){
            y -= speed * Math.cos(Tools.toRad(rotation))
            x += speed * Math.sin(Tools.toRad(rotation))
        }
        if (down){
            y += speed * Math.cos(Tools.toRad(rotation))
            x -= speed * Math.sin(Tools.toRad(rotation))
        }

        x = Tools.clamp(x, panelWidth.toDouble() - width, 0.0)
        y = Tools.clamp(y, panelHeight.toDouble() - height, 0.0)
    }
}