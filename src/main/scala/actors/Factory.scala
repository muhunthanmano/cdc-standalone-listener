package org.mu.stream.actors

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.cluster.typed.{Cluster, Join, SelfUp}
import com.typesafe.config.ConfigFactory

import akka.actor.Address
import akka.actor.AddressFromURIString
import akka.cluster.typed.JoinSeedNodes

object Factory {
  val config = ConfigFactory.load()
  val system = ActorSystem[Any](Behaviors.empty, "StreamMuClusterSystem", config)
  val cluster = Cluster(system)

//  val seedNodes: List[Address] =
//    List("akka://ClusterSystem@127.0.0.1:2551", "akka://ClusterSystem@127.0.0.1:2552").map(AddressFromURIString.parse)
//  Cluster(system).manager ! JoinSeedNodes(seedNodes)
}
