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
import at.o2xfs.xfs.cim.LockStatus;
import at.o2xfs.xfs.win32.XfsWord;

public class DeviceLockStatus3_20 extends Struct {

	protected final XfsWord<LockStatus> deviceLockStatus = new XfsWord<>(LockStatus.class);
	protected final Pointer cashUnitLock = new Pointer();

	protected DeviceLockStatus3_20() {
		add(deviceLockStatus);
		add(cashUnitLock);
	}

	public DeviceLockStatus3_20(Pointer p) {
		this();
		assignBuffer(p);
	}

	public DeviceLockStatus3_20(DeviceLockStatus3_20 copy) {
		this();
		allocate();
		set(copy);
	}

	protected void set(DeviceLockStatus3_20 copy) {
		deviceLockStatus.set(copy.getDeviceLockStatus());
		cashUnitLock.pointTo(new CashUnitLocks(copy.getCashUnitLock()));
	}

	public LockStatus getDeviceLockStatus() {
		return deviceLockStatus.get();
	}

	public CashUnitLock3_20[] getCashUnitLock() {
		return new CashUnitLocks(cashUnitLock).get();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getDeviceLockStatus()).append(getCashUnitLock()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof DeviceLockStatus3_20) {
			DeviceLockStatus3_20 deviceLockStatus3_20 = (DeviceLockStatus3_20) obj;
			return new EqualsBuilder().append(getDeviceLockStatus(), deviceLockStatus3_20.getDeviceLockStatus()).append(getCashUnitLock(), deviceLockStatus3_20.getCashUnitLock())
					.isEquals();
		}
		return false;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("deviceLockStatus", getDeviceLockStatus()).append("cashUnitLock", getCashUnitLock()).toString();
	}
}