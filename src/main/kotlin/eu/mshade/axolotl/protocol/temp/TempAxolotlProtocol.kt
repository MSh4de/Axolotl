package eu.mshade.axolotl.protocol.temp

import eu.mshade.axolotl.Axolotl
import eu.mshade.axolotl.event.HandshakeAxolotlEvent
import eu.mshade.axolotl.packet.AxolotlPacketInHandshake
import eu.mshade.axolotl.protocol.AxolotlProtocol
import eu.mshade.axolotl.protocol.AxolotlProtocolVersion
import eu.mshade.axolotl.protocol.AxolotlSession
import eu.mshade.mwork.event.EventListener
import io.netty.channel.Channel

object TempAxolotlProtocol: AxolotlProtocol() {

    init {

        eventBus.subscribe(AxolotlPacketInHandshake::class.java, object : EventListener<AxolotlPacketInHandshake> {
            override fun onEvent(event: AxolotlPacketInHandshake) {
                Axolotl.eventBus.publish(HandshakeAxolotlEvent(event.axolotlSession, event.axolotlProtocolVersion))
            }
        })

        packetRegistry.registerPacketIn(0, AxolotlPacketInHandshake::class)
    }

    override fun getAxolotlProtocolVersion(): AxolotlProtocolVersion {
        return AxolotlProtocolVersion.UNKNOWN
    }

    override fun getAxolotlSession(channel: Channel): AxolotlSession {
        return TempAxolotlSession(channel)
    }
}