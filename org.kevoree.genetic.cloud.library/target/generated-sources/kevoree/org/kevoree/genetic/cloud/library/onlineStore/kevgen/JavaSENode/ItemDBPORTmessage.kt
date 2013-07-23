package org.kevoree.genetic.cloud.library.onlineStore.kevgen.JavaSENode
import org.kevoree.framework.port.*
import org.kevoree.genetic.cloud.library.onlineStore.*
class ItemDBPORTmessage(val component : ItemDB) : org.kevoree.framework.MessagePort , KevoreeProvidedExecutorPort {
override var pool: PausablePortThreadPoolExecutor? = null
override var isPaused : jet.Boolean = true
override fun getName() : String { return "message"}
override fun getComponentName() : String? { return component.getName() }
override fun process(p0 : Any?) {this.send(p0)}
override fun internal_process(o : Any?) : Any?{
when(o){else -> { try{component.messageReceived(o);return null}catch(e:Exception){e.printStackTrace();println("Uncatched exception while processing Kevoree message");return null}
}}}
}
