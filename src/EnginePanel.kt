import managers.KeyboardManager
import managers.MouseManager
import managers.ObjectManager
import java.awt.Graphics
import java.awt.event.*
import javax.swing.JPanel

class EnginePanel : JPanel(), Runnable, KeyListener, MouseMotionListener, MouseListener, MouseWheelListener {

    companion object{
        //TODO fps counter
        var frame = 0
        var fps = 0
    }

    var isRunning = false
    var desiredFPS = 120
    var targetTime = 1000/desiredFPS


    val om = ObjectManager
    val mm = MouseManager
    val km = KeyboardManager


    init {
        addKeyListener(this)
        addMouseMotionListener(this)
        addMouseListener(this)
        addMouseWheelListener(this)
        isFocusable = true
        start()
    }

    fun start(){
        isRunning = true
        val thread = Thread(this)
        thread.start()
    }

    override fun run() {
        while(isRunning){
            val start = System.nanoTime()

            tick()
            repaint()

            var elapsed = System.nanoTime() - start
            var wait = targetTime - elapsed / 1000000

            if (wait <= 0) wait = 5

            try {
                Thread.sleep(wait)
            }catch (e: Exception){
                e.stackTrace
            }
        }
    }

    fun tick(){
        frame++
        for (item in om.levelObjects) item.tick()
        for (item in om.playerObjects) item.tick()
    }

    override fun paint(g: Graphics?) {
        super.paint(g)

        for (item in om.levelObjects) item.draw(g!!)
        for (item in om.playerObjects) item.draw(g!!)
        for (item in om.interfaceObjects) item.draw(g!!, om)
    }

    override fun keyTyped(e: KeyEvent?) {}

    //TODO create keyboard filter class
    override fun keyPressed(e: KeyEvent?) {
        km.keyPressed(e!!.keyCode)
    }

    override fun keyReleased(e: KeyEvent?) {
        km.keyReleased(e!!.keyCode)
    }

    override fun mouseMoved(e: MouseEvent?) {
        mm.mouseMoved(e!!.point)
    }

    override fun mouseDragged(e: MouseEvent?) {
        mm.mouseDragged(e!!, om)
    }

    override fun mousePressed(e: MouseEvent?) {
        mm.mousePressed(e!!)
    }

    override fun mouseReleased(e: MouseEvent?) {
        mm.mouseReleased(e!!)
    }

    override fun mouseEntered(e: MouseEvent?) {}
    override fun mouseClicked(e: MouseEvent?) {}
    override fun mouseExited(e: MouseEvent?) {}

    override fun mouseWheelMoved(e: MouseWheelEvent?) {
        mm.mouseWheelMoved(e!!)
    }
}