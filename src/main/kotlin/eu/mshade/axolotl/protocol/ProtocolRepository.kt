package eu.mshade.axolotl.protocol

import kotlin.reflect.KClass

class ProtocolRepository {

    val packetInByPacketKey = mutableMapOf<PacketKey, KClass<AxolotlPacketIn>>()
    val packetKeyByPacketOut = mutableMapOf<KClass<AxolotlPacketOut>, PacketKey>()

    fun registerPacketIn(packetKey: PacketKey, packetIn: KClass<AxolotlPacketIn>) {
        packetInByPacketKey[packetKey] = packetIn
    }

    fun registerPacketOut(packetOut: KClass<AxolotlPacketOut>, packetKey: PacketKey) {
        packetKeyByPacketOut[packetOut] = packetKey
    }

    fun getPacketIn(packetKey: PacketKey): KClass<AxolotlPacketIn> {
        return packetInByPacketKey[packetKey]!!
    }

    fun getPacketKey(packetOut: KClass<AxolotlPacketOut>): PacketKey {
        return packetKeyByPacketOut[packetOut]!!
    }

    fun createPacketIn(packetKey: PacketKey): AxolotlPacketIn {
        return getPacketIn(packetKey).constructors.first().call()
    }
}