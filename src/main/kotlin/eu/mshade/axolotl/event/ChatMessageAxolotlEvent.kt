package eu.mshade.axolotl.event

import eu.mshade.axolotl.protocol.AxolotlSession
import eu.mshade.enderframe.mojang.chat.TextComponent
import eu.mshade.enderframe.mojang.chat.TextPosition
import java.util.*

class ChatMessageAxolotlEvent(var axolotlSession: AxolotlSession, var uid: UUID, var textComponent: TextComponent, var textPosition: TextPosition): AxolotlEvent {

    override fun toString(): String {
        return "MessageAxolotlEvent(axolotlSession=$axolotlSession, uid=$uid, textComponent=$textComponent, textPosition=$textPosition)"
    }

}