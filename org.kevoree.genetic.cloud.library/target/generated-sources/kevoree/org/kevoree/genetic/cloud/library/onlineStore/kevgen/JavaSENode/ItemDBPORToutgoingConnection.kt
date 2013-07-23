package org.kevoree.genetic.cloud.library.onlineStore.kevgen.JavaSENode
import org.kevoree.framework.port.*
import org.kevoree.genetic.cloud.library.onlineStore.*
class ItemDBPORToutgoingConnection(val component : ItemDB) : org.kevoree.framework.MessagePort , KevoreeRequiredExecutorPort {
override var pool: PausablePortThreadPoolExecutor? = null
override var delegate: org.kevoree.framework.KevoreeChannelFragment? = null
override var isPaused : jet.Boolean = true
override var _isBound : jet.Boolean = false
override fun getName() : String { return "outgoingConnection"}
override fun getComponentName() : String? { return component.getName() }
override fun process(p0 : Any?) {this.send(p0)}
override fun getInOut():Boolean {return false}
}
