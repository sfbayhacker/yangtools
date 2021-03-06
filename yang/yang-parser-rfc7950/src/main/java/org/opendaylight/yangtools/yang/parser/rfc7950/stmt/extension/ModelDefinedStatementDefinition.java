/*
 * Copyright (c) 2015 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.yangtools.yang.parser.rfc7950.stmt.extension;

import static java.util.Objects.requireNonNull;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.model.api.meta.DeclaredStatement;
import org.opendaylight.yangtools.yang.model.api.meta.EffectiveStatement;
import org.opendaylight.yangtools.yang.model.api.meta.StatementDefinition;
import org.opendaylight.yangtools.yang.model.api.stmt.UnrecognizedEffectiveStatement;
import org.opendaylight.yangtools.yang.model.api.stmt.UnrecognizedStatement;

/**
 * Public definition for statements declared by extensions. This class is instantiated for every extension that is seen
 * to be declared in a model.
 */
@NonNullByDefault
final class ModelDefinedStatementDefinition implements StatementDefinition {
    private final QName statementName;
    private final @Nullable QName argumentName;
    private final boolean yinElement;

    ModelDefinedStatementDefinition(final QName statementName, final @Nullable QName argumentName,
            final boolean yinElement) {
        this.statementName = requireNonNull(statementName);
        this.argumentName = argumentName;
        this.yinElement = yinElement;
    }

    @Override
    public QName getStatementName() {
        return statementName;
    }

    @Override
    public @Nullable QName getArgumentName() {
        return argumentName;
    }

    @Override
    public Class<? extends DeclaredStatement<?>> getDeclaredRepresentationClass() {
        return UnrecognizedStatement.class;
    }

    @Override
    public Class<? extends EffectiveStatement<?, ?>> getEffectiveRepresentationClass() {
        return UnrecognizedEffectiveStatement.class;
    }

    @Override
    public boolean isArgumentYinElement() {
        return yinElement;
    }
}
