package managers

import tools.Config
import java.awt.Color

object KeyboardManager {
    val levelDefaultColor = Config.levelDefaultColor

    val om = ObjectManager

    fun keyPressed(e: Int){
        if (e in 48..57){

            //buttons from 0 to 9
            val tempLevelDrawnColor = when(e){
                48 -> Color.RED
                49 -> Color.ORANGE
                50 -> Color.YELLOW
                51 -> Color.GREEN
                52 -> Color.BLUE
                53 -> Color(128, 0, 128)
                54 -> Color.PINK
                55 -> Color.GRAY
                56 -> Color.BLACK
                57 -> Color.CYAN
                else-> Color.LIGHT_GRAY
            }

            Config.playerRayColor = tempLevelDrawnColor
            Config.levelDrawnColor = tempLevelDrawnColor

        }else if(e == 87 || e == 65 || e == 83 || e == 68){
            //wasd
            om.playerObjects[0].keyPressed(e)
        }else if(e == 67){
            //67 is c
            for (i in 0 until om.levelObjects.size) {
                om.levelObjects[i].color = levelDefaultColor
            }
        }
    }

    fun keyReleased(e: Int){
        if (e == 87 || e == 65 || e == 83 || e == 68){
            om.playerObjects[0].keyReleased(e)
        }
    }

}