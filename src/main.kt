import tools.Config
import javax.swing.JFrame

fun main() {
    val panelWidth = Config.panelWidth
    val panelHeight = Config.panelHeight

    val frame = JFrame("Independent")
    val panel = EnginePanel()

    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    frame.setSize(panelWidth+16, panelHeight+100)
    frame.add(panel)
    frame.isVisible = true
}