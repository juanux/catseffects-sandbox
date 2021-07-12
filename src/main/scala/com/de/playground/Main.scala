package com.de.playground

//import cats.instances.string._
//import cats.syntax.semigroup._

case class MyIO[A](unsafeRun: () => A)


object MyIO{
  def putStr(s: => String): MyIO[Unit] = MyIO(() => println(s))
}

object Main extends App {
  val hello = MyIO(()=> println("hello")).unsafeRun()
}



