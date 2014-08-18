package scheduler

import akka.actor._
import java.util.concurrent._

class RaftLeaderElection {
	val sys = ActorSystem("raft")
	val main = sys.actorOf(Props[Role], name = "main")
	
	TimeUnit.SECONDS.sleep(5)
	sys.shutdown
}

case class Start

class Role extends Actor {
  def receive = {
    case Start => println("starting...")
  }
}