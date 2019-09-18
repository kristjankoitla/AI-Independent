package managers


import objects.InterfaceObject
import objects.LevelObject
import objects.PlayerObject
import tools.Config

object ObjectManager {

    val rectSize = Config.levelRectSize
    val panelWidth = Config.panelWidth
    val panelHeight = Config.panelHeight
    val playerSpeed = Config.playerSpeed
    val playerColor = Config.playerColor
    val playerRotationSpeed = Config.playerRotationSpeed
    val levelDefaultColor = Config.levelDefaultColor

    var playerObjects = arrayListOf<PlayerObject>()
    var levelObjects = arrayListOf<LevelObject>()
    var interfaceObjects = arrayListOf<InterfaceObject>()

    init {
        createLevel()
        playerObjects.add(PlayerObject(0.0, 0.0, 20, 20, "OVAL", playerColor, playerSpeed, playerRotationSpeed))

        interfaceObjects.add(InterfaceObject("frame", 10, panelHeight + 15))
        interfaceObjects.add(InterfaceObject("position", 10, panelHeight + 32))
        interfaceObjects.add(InterfaceObject("rotation", 10, panelHeight + 49))
        interfaceObjects.add(InterfaceObject("penSize", 230, panelHeight + 15))
        interfaceObjects.add(InterfaceObject("0-red  1-orange  2-yellow  3-green  4-blue", 390, panelHeight + 15))
        interfaceObjects.add(InterfaceObject("5-purple  6-pink  7-gray  8-black  9-cyan", 390, panelHeight + 32))
        interfaceObjects.add(InterfaceObject("c-clear all", 390, panelHeight + 49))
    }

    private fun createLevel(){
        val color = levelDefaultColor
        //TODO actually fit the boxes

        for (x in 0 until panelHeight / rectSize) {
            for (y in 0 until panelWidth / rectSize) {
                levelObjects.add(LevelObject(
                    y*rectSize.toDouble(),
                    x*rectSize.toDouble(),
                    rectSize,
                    rectSize,
                    "RECTANGLE",
                    color
                ))
            }
        }
    }

}