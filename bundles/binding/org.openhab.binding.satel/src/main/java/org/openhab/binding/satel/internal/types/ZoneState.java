/**
 * Copyright (c) 2010-2019 Contributors to the openHAB project
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.openhab.binding.satel.internal.types;

/**
 * Available zone states.
 *
 * @author Krzysztof Goworek
 * @since 1.7.0
 */
public enum ZoneState implements StateType {
    VIOLATION(0x00),
    TAMPER(0x01),
    ALARM(0x02),
    TAMPER_ALARM(0x03),
    ALARM_MEMORY(0x04),
    TAMPER_ALARM_MEMORY(0x05),
    BYPASS(0x06),
    NO_VIOLATION_TROUBLE(0x07),
    LONG_VIOLATION_TROUBLE(0x08),
    ISOLATE(0x26),
    MASKED(0x28),
    MASKED_MEMORY(0x29);

    private byte refreshCommand;

    ZoneState(int refreshCommand) {
        this.refreshCommand = (byte) refreshCommand;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte getRefreshCommand() {
        return refreshCommand;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getPayloadLength(boolean extendedCmd) {
        return extendedCmd ? 32 : 16;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ObjectType getObjectType() {
        return ObjectType.ZONE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getStartByte() {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getBytesCount(boolean extendedCmd) {
        return getPayloadLength(extendedCmd);
    }

}
