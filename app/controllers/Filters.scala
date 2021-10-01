package controllers

import javax.inject.Inject
import play.api.http.DefaultHttpFilters
import play.api.http.EnabledFilters

class Filters @Inject() (
  defaultFilters: EnabledFilters,
  log: LoggingFilter
) extends DefaultHttpFilters(defaultFilters.filters :+ log: _*)