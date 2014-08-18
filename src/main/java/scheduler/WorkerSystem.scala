package scheduler

import akka.actor._
import com.typesafe.config._
import java.util.concurrent.TimeUnit

// does not work yet :
// testRemoteActor(scheduler.TestHelloActor): com.typesafe.config.Config.getDuration(Ljava/lang/String;Ljava/util/concurrent/TimeUnit;)J
// because running as scala script makes it automatically download some conflicted libs

object WorkerSystem {
	def main(args : Array[String]) = {
	  val workerSystem = ActorSystem("workersystem", ConfigFactory.load.getConfig("workersystem"))
	  println("worker system started")
	  TimeUnit.SECONDS.sleep(60)
	  workerSystem.shutdown
	}
}