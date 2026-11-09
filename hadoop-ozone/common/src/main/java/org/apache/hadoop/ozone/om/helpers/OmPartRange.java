/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hadoop.ozone.om.helpers;

import org.apache.hadoop.ozone.protocol.proto.OzoneManagerProtocolProtos.PartRange;

/**
 * Position of one part within its multipart key: the offset of the part and the size of the whole key.
 */
public final class OmPartRange {
  private final long offset;
  private final long keyDataSize;

  public OmPartRange(long offset, long keyDataSize) {
    this.offset = offset;
    this.keyDataSize = keyDataSize;
  }

  /** Offset of the first byte of the part within the key. */
  public long getOffset() {
    return offset;
  }

  /** Size of the whole key, not of the part. */
  public long getKeyDataSize() {
    return keyDataSize;
  }

  public PartRange getProtobuf() {
    return PartRange.newBuilder().setOffset(offset).setKeyDataSize(keyDataSize).build();
  }

  public static OmPartRange getFromProtobuf(PartRange proto) {
    return new OmPartRange(proto.getOffset(), proto.getKeyDataSize());
  }
}
