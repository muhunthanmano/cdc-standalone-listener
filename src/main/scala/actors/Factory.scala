package org.mu.stream.actors

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.cluster.typed.{Cluster, Join, SelfUp}
import com.typesafe.config.ConfigFactory
import akka.actor.Address
import akka.actor.AddressFromURIString
import akka.cluster.typed.JoinSeedNodes
import akka.actor.typed.Behavior
import org.mu.stream.actors.cluster.ClusterListener

object Factory {
//  val config = ConfigFactory.load()
//
//
//  object RootBehavior {
//    def apply(): Behavior[Nothing] = Behaviors.setup[Nothing] { context =>
//      // Create an actor that handles cluster domain events
//      context.spawn(ClusterListener(), "ClusterListener")
//
//      Behaviors.empty
//    }
//  }
//
//  val system = ActorSystem[Any](Behaviors.empty, "StreamMuClusterSystem", config)
//  val cluster = Cluster(system)
//  cluster.manager ! Join(cluster.selfMember.address)
//  val selfMember = Cluster(system).selfMember
//  println(s"=================================================================== ${selfMember.roles}")
//
//  println(selfMember.roles)


//  val seedNodes: List[Address] =
//    List("akka://ClusterSystem@127.0.0.1:2551", "akka://ClusterSystem@127.0.0.1:2552").map(AddressFromURIString.parse)
//  Cluster(system).manager ! JoinSeedNodes(seedNodes)
}
