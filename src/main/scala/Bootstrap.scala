package org.mu.stream

import com.typesafe.scalalogging.*
import org.slf4j.LoggerFactory

import scala.jdk.CollectionConverters.*
import akka.actor.AddressFromURIString
import com.typesafe.config.Config
import com.typesafe.config.ConfigFactory
import org.mu.stream.actors.Factory
import akka.actor.typed.scaladsl.Behaviors
import akka.actor.typed.ActorSystem
import akka.actor.typed.Behavior
import com.typesafe.config.ConfigFactory
import org.mu.stream.actors.cluster.ClusterListener

object Bootstrap  extends  App {

  private val logger = Logger(LoggerFactory.getLogger(this.getClass))
  logger.info("Starting the streaming Listener")

  val seedNodePorts = ConfigFactory.load().getStringList("akka.cluster.seed-nodes").asScala.flatMap {
    case AddressFromURIString(s) => s.port
  }

  object RootBehavior {
    def apply(): Behavior[Nothing] = Behaviors.setup[Nothing] { context =>
      // Create an actor that handles cluster domain events
      context.spawn(ClusterListener(), "ClusterListener")

      Behaviors.empty
    }
  }

  def startup(port: Int): Unit = {
    // Override the configuration of the port
    val config = ConfigFactory.parseString(
      s"""
      akka.remote.artery.canonical.port=$port
      """).withFallback(ConfigFactory.load())

    // Create an Akka system
    ActorSystem[Nothing](RootBehavior(), "ClusterSystem", config)
  }

  def init(): Unit = {
    val ports = Seq(25251, 25252, 0)

    ports.foreach(startup)
  }

  init()



//  Factory
}
