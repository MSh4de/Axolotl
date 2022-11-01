package eu.mshade.axolotl.protocol

import eu.mshade.mwork.binarytag.entity.CompoundBinaryTag
import javax.swing.text.html.HTML.UnknownTag

interface PacketKey {

    fun getIdentifier(): Int

    fun getName(): String

    companion object {
        fun from(identifier: Int, name: String): PacketKey = DefaultPacketKey(identifier, name)
    }

}

class DefaultPacketKey(private val identifier: Int, private val name: String) : PacketKey {

    override fun getIdentifier(): Int {
        return identifier
    }

    override fun getName(): String {
        return name
    }

    override fun toString(): String {
        return "DefaultPacketKey(identifier=$identifier)"
    }

}

interface AxolotlPacketIn {

    fun read(compoundBinaryTag: CompoundBinaryTag)

}

interface AxolotlPacketOut {

    fun write(compoundBinaryTag: CompoundBinaryTag)

}


