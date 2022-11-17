package me.trqnquility.detective.compressor

import me.trqnquility.detective.compressor.implementation.ZstdCompressor
import me.trqnquility.detective.compressor.type.CompressorType

interface DetectiveCompressor {

    companion object {
        /**
         * Creates a new implementation of the compressor that allows for compression
         * algorithms to be switch easy if needed.
         *
         * @param type type of compressor to use
         * @return a compressor
         */
        fun create(type: CompressorType): DetectiveCompressor {
            return when (type) {
                CompressorType.Z_STANDARD -> ZstdCompressor
            }
        }
    }

    /**
     * @param input the byte array to compress.
     * @return returns the compressed bytebuffer.
     */
    fun compress(input: ByteArray): ByteArray

    /**
     * @param input the byte array to decompress.
     * @return the decompressed byte array.
     */
    fun decompress(input: ByteArray): ByteArray
}