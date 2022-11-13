package eu.mshade.axolotl.protocol

import io.netty.channel.Channel

object AxolotlProtocolPipeline {

    val protocolByChannel = mutableMapOf<Channel, AxolotlProtocol>()
    val axolotlSessionByChannel = mutableMapOf<Channel, AxolotlSession>()


    fun flush(channel: Channel){
        axolotlSessionByChannel.remove(channel)
        protocolByChannel.remove(channel)
    }

}