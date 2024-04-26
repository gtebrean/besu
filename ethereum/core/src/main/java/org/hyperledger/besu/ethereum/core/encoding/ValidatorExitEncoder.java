/*
 * Copyright contributors to Hyperledger Besu
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 */
package org.hyperledger.besu.ethereum.core.encoding;

import org.hyperledger.besu.ethereum.core.ValidatorExit;
import org.hyperledger.besu.ethereum.rlp.RLP;
import org.hyperledger.besu.ethereum.rlp.RLPOutput;

import org.apache.tuweni.bytes.Bytes;

public class ValidatorExitEncoder {

  public static void encode(final ValidatorExit exit, final RLPOutput rlpOutput) {
    rlpOutput.startList();
    rlpOutput.writeBytes(exit.getSourceAddress());
    rlpOutput.writeBytes(exit.getValidatorPubKey());
    rlpOutput.endList();
  }

  public static Bytes encodeOpaqueBytes(final ValidatorExit exit) {
    return RLP.encode(rlpOutput -> encode(exit, rlpOutput));
  }
}
