package tools
import org.w3c.dom.Element
import java.awt.Color
import java.awt.Font
import java.io.File
import javax.xml.parsers.DocumentBuilderFactory

object Config {

    private val docBuilderFactory = DocumentBuilderFactory.newInstance()
    private val docBuilder = docBuilderFactory.newDocumentBuilder()
    private val doc = docBuilder.parse(File("C:\\Users\\koitl\\IdeaProjects\\Independent\\src\\tools\\config.xml"))

    val panelWidth: Int
    val panelHeight: Int
    val levelRectSize: Int
    val playerSpeed: Int
    val playerRotationSpeed: Int
    val playerColor: Color
    val font: Font
    val fontColor: Color
    val levelDefaultColor: Color
    var levelDrawnColor: Color
    var playerRayColor: Color
    var penSize = 1

    init {
        panelWidth = getElementValue("panel", "width").toInt()
        panelHeight = getElementValue("panel", "height").toInt()
        levelRectSize = getElementValue("level", "rectSize").toInt()
        playerSpeed = getElementValue("player", "speed").toInt()
        playerRotationSpeed = getElementValue("player", "rotationSpeed").toInt()

        playerColor = Tools.colorPicker(getElementValue("player", "color"))
        fontColor = Tools.colorPicker(getElementValue("font", "color"))
        levelDefaultColor = Tools.colorPicker(getElementValue("level", "defaultColor"))
        levelDrawnColor = Tools.colorPicker(getElementValue("level", "drawnColor"))
        playerRayColor = Tools.colorPicker(getElementValue("player", "rayColor"))

        font = Font(
            getElementValue("font", "style"),
            Font.BOLD,
            getElementValue("font", "size").toInt()
        )
    }


    fun getElementValue(node: String, element: String): String{
        //fNode to not overshadow node
        var fNode = doc.getElementsByTagName(node).item(0)
        fNode = fNode as Element

        return(fNode.getElementsByTagName(element).item(0).textContent)
    }
}