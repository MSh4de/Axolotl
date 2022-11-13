package eu.mshade.axolotl.protocol

import kotlin.reflect.KClass

class AxolotlPacketRegistry {

    private val packetInByPacketKey = mutableMapOf<Int, KClass<out AxolotlPacketIn>>()
    private val packetKeyByPacketOut = mutableMapOf<KClass<out AxolotlPacketOut>, Int>()

    fun registerPacketIn(packetKey: Int, packetIn: KClass<out AxolotlPacketIn>) {
        packetInByPacketKey[packetKey] = packetIn
    }

    fun registerPacketOut(packetKey: Int, packetOut: KClass<out AxolotlPacketOut>) {
        packetKeyByPacketOut[packetOut] = packetKey
    }

    fun getPacketIn(packetKey: Int): KClass<out AxolotlPacketIn> {
        return packetInByPacketKey[packetKey]!!
    }

    fun getPacketKey(packetOut: KClass<out AxolotlPacketOut>): Int {
        return packetKeyByPacketOut[packetOut]!!
    }

    fun createPacketIn(packetKey: Int): AxolotlPacketIn {
        return getPacketIn(packetKey).constructors.first().call()
    }
}