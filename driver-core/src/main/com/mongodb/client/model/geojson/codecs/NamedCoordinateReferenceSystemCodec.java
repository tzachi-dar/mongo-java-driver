/*
 * Copyright 2015 MongoDB, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mongodb.client.model.geojson.codecs;

import com.mongodb.client.model.geojson.NamedCoordinateReferenceSystem;
import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

/**
 * Codec for a GeoJson Coordinate Reference System of type name.
 *
 * @since 3.1
 */
public class NamedCoordinateReferenceSystemCodec implements Codec<NamedCoordinateReferenceSystem> {
    @Override
    public void encode(final BsonWriter writer, final NamedCoordinateReferenceSystem value, final EncoderContext encoderContext) {
        writer.writeStartDocument();

        writer.writeString("type", value.getType().getTypeName());

        writer.writeStartDocument("properties");
        writer.writeString("name", value.getName());
        writer.writeEndDocument();

        writer.writeEndDocument();
    }

    @Override
    public Class<NamedCoordinateReferenceSystem> getEncoderClass() {
        return NamedCoordinateReferenceSystem.class;
    }

    @Override
    public NamedCoordinateReferenceSystem decode(final BsonReader reader, final DecoderContext decoderContext) {
        throw new UnsupportedOperationException("Not implemented yet!");
    }
}
