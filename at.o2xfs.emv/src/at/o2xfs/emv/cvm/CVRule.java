/*
 * Copyright (c) 2014, Andreas Fagschlunger. All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 * 
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

package at.o2xfs.emv.cvm;

import at.o2xfs.common.Bit;
import at.o2xfs.common.Bytes;
import at.o2xfs.common.Hex;

public class CVRule {

	private byte[] rule;

	public CVRule(byte[] rule) {
		if (rule.length != 2) {
			throw new IllegalArgumentException("Illegal CVRule: "
					+ Hex.encode(rule));
		}
		this.rule = Bytes.copy(rule);
	}

	/**
	 * Fail cardholder verification if this CVM is unsuccessful
	 */
	public boolean failIfUnsuccessful() {
		return !Bit.isSet(rule[0], Bit.B7);
	}

	/**
	 * 
	 * @return
	 */
	public int getCVMCode() {
		return Bytes.toInt(rule[0]) & 0x3F;
	}

	public int getCVMConditionCode() {
		return Bytes.toInt(rule[1]);
	}

	@Override
	public String toString() {
		return Hex.encode(rule);
	}
}