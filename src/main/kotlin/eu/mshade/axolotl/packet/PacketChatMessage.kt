package eu.mshade.axolotl.packet

import eu.mshade.axolotl.marshal.TextComponentMarshal
import eu.mshade.axolotl.protocol.AxolotlPacketIn
import eu.mshade.axolotl.protocol.AxolotlPacketOut
import eu.mshade.enderframe.mojang.chat.TextComponent
import eu.mshade.enderframe.mojang.chat.TextPosition
import eu.mshade.mwork.binarytag.entity.CompoundBinaryTag

class AxolotlPacketInChatMessage : AxolotlPacketIn {

    lateinit var message: TextComponent
    lateinit var position: TextPosition

    override fun read(compoundBinaryTag: CompoundBinaryTag) {
        message = TextComponentMarshal.deserialize(compoundBinaryTag.getBinaryTag("message") as CompoundBinaryTag)
        position = TextPosition.valueOf(compoundBinaryTag.getString("position"))
    }

    override fun toString(): String {
        return "AxolotlPacketInChatMessage(message=$message, position=$position)"
    }
}

class AxolotlPacketOutChatMessage(private val message: String) : AxolotlPacketOut {

    override fun write(compoundBinaryTag: CompoundBinaryTag) {
        compoundBinaryTag.putString("message", message)
    }

    override fun toString(): String {
        return "AxolotlPacketOutChatMessage(message='$message')"
    }

}