package objects

import java.awt.Color
import java.awt.event.KeyEvent

class PlayerObject(

    x: Double,
    y: Double,
    width: Int,
    height: Int,
    shape: String,
    color: Color,
    speed: Int,
    rotationSpeed: Int)

    : MovingObject(x, y, width,height, shape, color, speed, rotationSpeed) {


    fun keyPressed(key: Int) {

        if (key == KeyEvent.VK_D) right = true
        if (key == KeyEvent.VK_A) left = true
        if (key == KeyEvent.VK_W) up = true
        if (key == KeyEvent.VK_S) down = true
    }

    fun keyReleased(key: Int) {

        if (key == KeyEvent.VK_D) right = false
        if (key == KeyEvent.VK_A) left = false
        if (key == KeyEvent.VK_W) up = false
        if (key == KeyEvent.VK_S) down = false
    }
}