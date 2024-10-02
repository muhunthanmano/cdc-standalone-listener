package org.mu.stream

import com.typesafe.scalalogging.*
import org.slf4j.LoggerFactory

import scala.jdk.CollectionConverters.*
import akka.actor.AddressFromURIString
import com.typesafe.config.Config
import com.typesafe.config.ConfigFactory
import org.mu.stream.actors.Factory

object Bootstrap  extends  App {

  private val logger = Logger(LoggerFactory.getLogger(this.getClass))
  logger.info("Starting the streaming Listener")

  val seedNodePorts = ConfigFactory.load().getStringList("akka.cluster.seed-nodes").asScala.flatMap {
    case AddressFromURIString(s) => s.port
  }

  Factory
}
