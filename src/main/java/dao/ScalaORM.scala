package dao

import scala.slick.driver.MySQLDriver.simple._
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource

// "jdbc:mysql://localhost/test", "", ""
class ScalaORM {
	val dbDriver = "com.mysql.jdbc.Driver"
	val dbUrl = "jdbc:mysql://localhost/test"
	val ds = new MysqlDataSource
	ds setUrl dbUrl
	ds setUser ""
	ds setPassword ""
	 
	implicit val session = getSession  // all in the same session; or change to def to ensure different sessions
	
	def getSession = {  
	  Database forDataSource(ds) createSession
	}
	
	def testCase = {
		val movies = TableQuery[Movies]
		println(movies.run)		
		println(movies.run.filter(_.title.toLowerCase().startsWith("star")))
		println(movies.filter(_.title.startsWith("star")).run)
		movies.map(x => x.title).run.foreach(println)
		
		// join (more on this later...)
		
		// insert a new row
		movies += Movie(None, title = "Edge Of Tomorrow", director = "someone", typeName = "Sci-Fi")
		
		// update a row, is will update the table although id is Option[Int] type 
		movies.filter(_.id === 11) map ( m => (m.director, m.typeName)) update ("Kexu", "Gooood")
	}
    
}

case class Movie(id : Option[Int], title : String, director : String, typeName : String)

class Movies(tag : Tag) extends Table[Movie](tag, "movies") {
  def id = column[Option[Int]]("id", O.PrimaryKey, O.AutoInc)
  def title = column[String]("title")
  def director = column[String]("director")
  def typeName = column[String]("type")
  
  def * = (id, title, director, typeName) <> (Movie.tupled, Movie.unapply _)
}