package org.mu.stream.actors

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.cluster.typed.{Cluster, Join, SelfUp}
import com.typesafe.config.ConfigFactory

object Factory {
  val config = ConfigFactory.load()
  val system = ActorSystem[Any](Behaviors.empty, "StreamMuClusterSystem", config)
}
