package com.madgag.sample.gslrw

trait Emphasiser {
  def emphasise(s: String): String
}

object Emphasiser {
  println("I could be some REALLY MALICIOUS CODE - but I'm just a demonstration! Sorry about that!")
  
  val Sardonic = new Emphasiser {
    override def emphasise(s: String): String = s"_${s}_"
  }
}
