/*
 * Copyright contributors to Hyperledger Besu.
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
package org.hyperledger.besu.ethereum.core;

import org.hyperledger.besu.datatypes.BLSPublicKey;
import org.hyperledger.besu.datatypes.BLSSignature;
import org.hyperledger.besu.datatypes.GWei;
import org.hyperledger.besu.datatypes.PublicKey;
import org.hyperledger.besu.datatypes.RequestType;

import java.util.Objects;

import org.apache.tuweni.bytes.Bytes32;
import org.apache.tuweni.units.bigints.UInt64;

public class DepositRequest extends Request
    implements org.hyperledger.besu.plugin.data.DepositRequest {

  private final BLSPublicKey pubkey;
  private final Bytes32 depositWithdrawalCredentials;
  private final GWei amount;
  private final BLSSignature signature;
  private final UInt64 index;

  public DepositRequest(
      final BLSPublicKey pubkey,
      final Bytes32 depositWithdrawalCredentials,
      final GWei amount,
      final BLSSignature signature,
      final UInt64 index) {
    this.pubkey = pubkey;
    this.depositWithdrawalCredentials = depositWithdrawalCredentials;
    this.amount = amount;
    this.signature = signature;
    this.index = index;
  }

  @Override
  public RequestType getType() {
    return RequestType.DEPOSIT;
  }

  @Override
  public PublicKey getPubkey() {
    return pubkey;
  }

  @Override
  public Bytes32 getWithdrawalCredentials() {
    return depositWithdrawalCredentials;
  }

  @Override
  public GWei getAmount() {
    return amount;
  }

  @Override
  public BLSSignature getSignature() {
    return signature;
  }

  @Override
  public UInt64 getIndex() {
    return index;
  }

  @Override
  public String toString() {
    return "Deposit{"
        + "pubKey="
        + pubkey
        + ", withdrawalCredentials="
        + depositWithdrawalCredentials
        + ", amount="
        + amount
        + ", signature="
        + signature
        + ", index="
        + index
        + '}';
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    final DepositRequest that = (DepositRequest) o;
    return Objects.equals(pubkey, that.pubkey)
        && Objects.equals(depositWithdrawalCredentials, that.depositWithdrawalCredentials)
        && Objects.equals(amount, that.amount)
        && Objects.equals(signature, that.signature)
        && Objects.equals(index, that.index);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pubkey, depositWithdrawalCredentials, amount, signature, index);
  }
}
