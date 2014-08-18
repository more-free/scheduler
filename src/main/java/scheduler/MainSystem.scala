package scheduler

import scala.io.Source
import java.net.URL
import akka.actor._
import com.typesafe.config._
import java.util.concurrent._

object MainSystem {
	def main(args : Array[String]) = {
	  val mainSystem = ActorSystem("mainsystem", ConfigFactory.load.getConfig("mainsystem"))
	  println("main system started")
	  
	  val worker = mainSystem.actorOf(Props[WorkerActor], name = "workeractor")
	  val mainActor = mainSystem.actorOf(Props(new MainActor(worker)), name = "mainactor")
	  mainActor ! "start"
	  
	  TimeUnit.SECONDS.sleep(10)
	  mainSystem.shutdown
	}
}

class MainActor(worker : ActorRef) extends Actor {
  def receive = {
    case "start" => 
      worker ! WordCount("http://www.reddit.com/")
  }
}

class WorkerActor extends Actor {
  def receive = {
    case WordCount(url) => 
      println("start counting")
      println(url + " has " + countWords(url) + " words in total")
  }
  
  def countWords(url : String) = {
	Source.fromURL(new URL(url)).getLines.foldLeft(0)(_ + _.split(" ").size)
  }
}

case class WordCount(url : String)
