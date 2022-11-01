package eu.mshade.axolotl.marshal

import eu.mshade.enderframe.mojang.chat.ChatColor
import eu.mshade.enderframe.mojang.chat.TextComponent
import eu.mshade.enderframe.mojang.chat.TextComponentEntry
import eu.mshade.mwork.binarytag.BinaryTagType
import eu.mshade.mwork.binarytag.entity.CompoundBinaryTag
import eu.mshade.mwork.binarytag.entity.ListBinaryTag

object TextComponentMarshal {

    fun serialize(textComponent: TextComponent): CompoundBinaryTag{
        val compoundBinaryTag = CompoundBinaryTag()
        serializeTextComponentExtra(textComponent, compoundBinaryTag)

        val listBinaryTag = ListBinaryTag(BinaryTagType.COMPOUND)
        textComponent.extra.forEach{
            listBinaryTag.add(serializeTextComponentExtra(it))
        }

        compoundBinaryTag.putBinaryTag("extra", listBinaryTag)

        return compoundBinaryTag
    }

    fun deserialize(compoundBinaryTag: CompoundBinaryTag): TextComponent{
        val textComponent = TextComponent.of(compoundBinaryTag.getString("text"))
        deserializeTextComponentExtra(compoundBinaryTag, textComponent)

        val listBinaryTag = compoundBinaryTag.getBinaryTag("extra") as ListBinaryTag
        listBinaryTag.value.forEach{
            textComponent.extra.add(deserializeTextComponentExtra(it as CompoundBinaryTag))
        }

        return textComponent
    }

    private fun serializeTextComponentExtra(textComponentEntry: TextComponentEntry, compoundBinaryTag: CompoundBinaryTag = CompoundBinaryTag()): CompoundBinaryTag{
        compoundBinaryTag.putString("text", textComponentEntry.text)
        compoundBinaryTag.putBoolean("bold", textComponentEntry.isBold)
        compoundBinaryTag.putBoolean("italic", textComponentEntry.isItalic)
        compoundBinaryTag.putBoolean("underlined", textComponentEntry.isUnderlined)
        compoundBinaryTag.putBoolean("strikethrough", textComponentEntry.isStrikethrough)
        compoundBinaryTag.putBoolean("obfuscated", textComponentEntry.isObfuscated)
        compoundBinaryTag.putString("color", (textComponentEntry.chatColor?: ChatColor.WHITE).code)
        return compoundBinaryTag
    }

    private fun deserializeTextComponentExtra(compoundBinaryTag: CompoundBinaryTag, textComponentEntry: TextComponentEntry = TextComponentEntry.of(compoundBinaryTag.getString("text"))): TextComponentEntry{
        textComponentEntry.withBold(compoundBinaryTag.getBoolean("bold"))
        textComponentEntry.withItalic(compoundBinaryTag.getBoolean("italic"))
        textComponentEntry.withUnderlined(compoundBinaryTag.getBoolean("underlined"))
        textComponentEntry.withStrikethrough(compoundBinaryTag.getBoolean("strikethrough"))
        textComponentEntry.withObfuscated(compoundBinaryTag.getBoolean("obfuscated"))
        textComponentEntry.withColor(ChatColor.getByChar(compoundBinaryTag.getString("color")))
        return textComponentEntry
    }

}