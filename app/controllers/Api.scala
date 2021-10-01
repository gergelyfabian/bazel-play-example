package controllers

import domain.Configuration
import play.api.libs.json.Json
import play.api.mvc._

import javax.inject.Inject

class Api @Inject()(component: ControllerComponents) extends AbstractController(component) {

  def index(): Action[AnyContent] = Action {
    val json = Json.obj("result" -> Configuration.MyConfig)
    Ok(json)
  }
}
