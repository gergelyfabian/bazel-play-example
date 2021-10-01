package controllers

import domain.Configuration

import javax.inject.Inject
import play.api.mvc._

class Application @Inject()(component: ControllerComponents) extends AbstractController(component) {

  def index(): Action[AnyContent] = Action {
    Ok(views.html.index(Configuration.MyConfig))
  }
}
