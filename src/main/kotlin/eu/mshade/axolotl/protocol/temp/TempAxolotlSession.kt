package eu.mshade.axolotl.protocol.temp

import eu.mshade.axolotl.protocol.AxolotlSession
import eu.mshade.enderframe.entity.Entity
import eu.mshade.enderframe.entity.Player
import eu.mshade.enderframe.world.World
import eu.mshade.enderframe.world.chunk.Chunk
import eu.mshade.enderframe.world.chunk.Section
import io.netty.channel.Channel

class TempAxolotlSession(channel: Channel) : AxolotlSession(channel) {

    override fun sendInitializePlayer(player: Player) {
        TODO("Not yet implemented")
    }

    override fun sendPlayerJoin(player: Player) {
        TODO("Not yet implemented")
    }

    override fun sendPlayerLeave(player: Player) {
        TODO("Not yet implemented")
    }

    override fun sendEntityLocation(entity: Entity) {
        TODO("Not yet implemented")
    }

    override fun sendChunk(chunk: Chunk) {
        TODO("Not yet implemented")
    }

    override fun sendChunkUnload(chunk: Chunk) {
        TODO("Not yet implemented")
    }

    override fun sendInitializeWorld(world: World) {
        TODO("Not yet implemented")
    }

    override fun sendSection(section: Section) {
        TODO("Not yet implemented")
    }


}
