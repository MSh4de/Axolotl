package eu.mshade.axolotl.protocol

import eu.mshade.enderframe.metadata.MetadataKeyValueBufferRegistry
import eu.mshade.mwork.event.EventBus
import io.netty.channel.Channel

abstract class AxolotlProtocol {

    val packetRegistry = AxolotlPacketRegistry()
    val eventBus = EventBus<AxolotlPacketIn>()
    val metadataKeyValueBufferRegistry = MetadataKeyValueBufferRegistry()

    abstract fun getAxolotlProtocolVersion(): AxolotlProtocolVersion

    abstract fun getAxolotlSession(channel: Channel): AxolotlSession


}