/*
 * Copyright (c) 2016, Andreas Fagschlunger. All rights reserved.
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

package at.o2xfs.xfs.cim.v3_10;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import at.o2xfs.win32.Pointer;
import at.o2xfs.win32.Struct;
import at.o2xfs.xfs.cim.v3_00.P6Signature3;

public class P6CompareSignature3_10 extends Struct {

	protected final Pointer p6ReferenceSignatures = new Pointer();
	protected final Pointer p6Signatures = new Pointer();

	protected P6CompareSignature3_10() {
		add(p6ReferenceSignatures);
		add(p6Signatures);
	}

	public P6CompareSignature3_10(Pointer p) {
		this();
		assignBuffer(p);
	}

	public P6CompareSignature3_10(P6CompareSignature3_10 copy) {
		this();
		allocate();
		set(copy);
	}

	protected void set(P6CompareSignature3_10 copy) {
		p6ReferenceSignatures.pointTo(new P6Signatures(copy.getP6ReferenceSignatures()));
		p6Signatures.pointTo(new P6Signatures(copy.getP6Signatures()));
	}

	public P6Signature3[] getP6ReferenceSignatures() {
		return new P6Signatures(p6ReferenceSignatures).get();
	}

	public P6Signature3[] getP6Signatures() {
		return new P6Signatures(p6Signatures).get();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getP6ReferenceSignatures()).append(getP6Signatures()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof P6CompareSignature3_10) {
			P6CompareSignature3_10 p6CompareSignature3_10 = (P6CompareSignature3_10) obj;
			return new EqualsBuilder().append(getP6ReferenceSignatures(), p6CompareSignature3_10.getP6ReferenceSignatures())
					.append(getP6Signatures(), p6CompareSignature3_10.getP6Signatures()).isEquals();
		}
		return false;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("p6ReferenceSignatures", getP6ReferenceSignatures()).append("p6Signatures", getP6Signatures()).toString();
	}
}