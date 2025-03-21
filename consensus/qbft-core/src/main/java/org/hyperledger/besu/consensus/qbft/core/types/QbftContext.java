/*
 * Copyright ConsenSys AG.
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
package org.hyperledger.besu.consensus.qbft.core.types;

import org.hyperledger.besu.ethereum.ConsensusContext;

/**
 * Holds the QBFT specific mutable state.
 *
 * @param validatorProvider the validator provider
 * @param blockInterface the block interface
 */
public record QbftContext(
    QbftValidatorProvider validatorProvider, QbftBlockInterface blockInterface)
    implements ConsensusContext {

  /**
   * Gets validator provider.
   *
   * @return the validator provider
   */
  @Override
  public QbftValidatorProvider validatorProvider() {
    return validatorProvider;
  }

  /**
   * Gets block interface.
   *
   * @return the block interface
   */
  @Override
  public QbftBlockInterface blockInterface() {
    return blockInterface;
  }

  @Override
  public <C extends ConsensusContext> C as(final Class<C> klass) {
    return klass.cast(this);
  }
}
