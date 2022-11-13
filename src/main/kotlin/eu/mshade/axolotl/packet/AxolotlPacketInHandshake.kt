package eu.mshade.axolotl.packet

import eu.mshade.axolotl.protocol.AxolotlPacketIn
import eu.mshade.axolotl.protocol.AxolotlProtocolVersion
import eu.mshade.axolotl.protocol.AxolotlSession
import eu.mshade.mwork.binarytag.entity.CompoundBinaryTag

class AxolotlPacketInHandshake: AxolotlPacketIn {

    lateinit var axolotlProtocolVersion: AxolotlProtocolVersion
    lateinit var axolotlSession: AxolotlSession

    override fun read(axolotlSession: AxolotlSession, compoundBinaryTag: CompoundBinaryTag) {
        this.axolotlSession = axolotlSession
        axolotlProtocolVersion = AxolotlProtocolVersion.getProtocolVersion(compoundBinaryTag.getInt("version"))
    }

}