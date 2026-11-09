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

package org.apache.hadoop.ozone.om;

import org.apache.hadoop.ozone.om.helpers.OmKeyInfo;
import org.apache.hadoop.ozone.om.helpers.OmPartRange;

/**
 * Key info read by {@link KeyManager#getKeyInfo}, with the position of the part it was restricted to.
 */
public final class KeyInfoWithPartRange {
  private final OmKeyInfo keyInfo;
  private final OmPartRange partRange;

  public KeyInfoWithPartRange(OmKeyInfo keyInfo, OmPartRange partRange) {
    this.keyInfo = keyInfo;
    this.partRange = partRange;
  }

  public OmKeyInfo getKeyInfo() {
    return keyInfo;
  }

  /** Position of {@link #getKeyInfo()} within the whole key, or null if the key was not read as one part. */
  public OmPartRange getPartRange() {
    return partRange;
  }
}
