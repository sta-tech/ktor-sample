package ru.statech.serialization

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializer
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.time.Instant

@OptIn(ExperimentalSerializationApi::class)
@Serializer(forClass = Instant::class)
object InstantSerializer : KSerializer<Instant> {
    override fun deserialize(decoder: Decoder): Instant
            = Instant.parse(decoder.decodeString())

    override fun serialize(encoder: Encoder, value: Instant) {
        encoder.encodeString(value.toString())
    }
}