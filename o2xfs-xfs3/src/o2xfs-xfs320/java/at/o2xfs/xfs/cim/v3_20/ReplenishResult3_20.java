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

package at.o2xfs.xfs.cim.v3_20;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import at.o2xfs.win32.Pointer;
import at.o2xfs.win32.Struct;
import at.o2xfs.win32.ULONG;

public class ReplenishResult3_20 extends Struct {

	protected final ULONG numberOfItemsRemoved = new ULONG();
	protected final ULONG numberOfItemsRejected = new ULONG();
	protected final Pointer replenishTargetResults = new Pointer();

	protected ReplenishResult3_20() {
		add(numberOfItemsRemoved);
		add(numberOfItemsRejected);
		add(replenishTargetResults);
	}

	public ReplenishResult3_20(Pointer p) {
		this();
		assignBuffer(p);
	}

	public ReplenishResult3_20(ReplenishResult3_20 copy) {
		this();
		allocate();
		set(copy);
	}

	protected void set(ReplenishResult3_20 copy) {
		numberOfItemsRemoved.set(copy.getNumberOfItemsRemoved());
		numberOfItemsRejected.set(copy.getNumberOfItemsRejected());
		replenishTargetResults.pointTo(new ReplenishTargetResults(copy.getReplenishTargetResults()));
	}

	public long getNumberOfItemsRemoved() {
		return numberOfItemsRemoved.get();
	}

	public long getNumberOfItemsRejected() {
		return numberOfItemsRejected.get();
	}

	public ReplenishTargetResult3_20[] getReplenishTargetResults() {
		return new ReplenishTargetResults(replenishTargetResults).get();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getNumberOfItemsRemoved()).append(getNumberOfItemsRejected()).append(getReplenishTargetResults()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ReplenishResult3_20) {
			ReplenishResult3_20 replenishResult3_20 = (ReplenishResult3_20) obj;
			return new EqualsBuilder().append(getNumberOfItemsRemoved(), replenishResult3_20.getNumberOfItemsRemoved())
					.append(getNumberOfItemsRejected(), replenishResult3_20.getNumberOfItemsRejected())
					.append(getReplenishTargetResults(), replenishResult3_20.getReplenishTargetResults()).isEquals();
		}
		return false;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("numberOfItemsRemoved", getNumberOfItemsRemoved()).append("numberOfItemsRejected", getNumberOfItemsRejected())
				.append("replenishTargetResults", getReplenishTargetResults()).toString();
	}
}