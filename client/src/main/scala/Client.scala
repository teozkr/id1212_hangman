package se.nullable.kth.id1212.hangman.client

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.{ Parent, Scene }
import javafx.stage.Stage
import view.ViewController
import controller.ClientController


class Client extends Application {
  override def start(stage: Stage): Unit = {
    val controller = new ClientController()
    val view = new ViewController(controller)
    controller.addListener(view.UpdateListener)

    val fxml = new FXMLLoader
    fxml.setController(view)
    fxml.setLocation(view.getClass.getResource("hangman-dialog.fxml"))
    val content = fxml.load[Parent]()
    val scene = new Scene(content)
    stage.setScene(scene)
    stage.setTitle("NetHangman")
    stage.show()

    stage.setOnCloseRequest(ev => controller.stop())
  }
}

object Client extends App {
  Application.launch(classOf[Client], args: _*)
}
