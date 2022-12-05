package eu.mshade.axolotl.protocol

import eu.mshade.enderframe.entity.Entity
import eu.mshade.enderframe.entity.Player
import eu.mshade.enderframe.world.World
import eu.mshade.enderframe.world.chunk.Chunk
import eu.mshade.enderframe.world.chunk.Section
import io.netty.channel.Channel

abstract class AxolotlSession(val channel: Channel) {

    fun sendPacket(axolotlPacketOut: AxolotlPacketOut) {
        channel.writeAndFlush(axolotlPacketOut)
    }

    abstract fun sendInitializePlayer(player: Player)

    abstract fun sendPlayerJoin(player: Player)

    abstract fun sendPlayerLeave(player: Player)

    abstract fun sendEntityLocation(entity: Entity)

    abstract fun sendChunk(chunk: Chunk)

    abstract fun sendChunkUnload(chunk: Chunk)

    abstract fun sendInitializeWorld(world: World)

    abstract fun sendSection(section: Section)

    abstract fun sendChatMessage(player: Player, message: String)
}