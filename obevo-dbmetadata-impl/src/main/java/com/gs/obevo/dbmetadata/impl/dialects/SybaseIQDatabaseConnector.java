/**
 * Copyright 2017 Goldman Sachs.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.gs.obevo.dbmetadata.impl.dialects;

/*
Will port this to SchemaCrawler project soon

========================================================================
SchemaCrawler
http://www.schemacrawler.com
Copyright (c) 2000-2017, Sualeh Fatehi <sualeh@hotmail.com>.
All rights reserved.
------------------------------------------------------------------------

SchemaCrawler is distributed in the hope that it will be useful, but
WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.

SchemaCrawler and the accompanying materials are made available under
the terms of the Eclipse Public License v1.0, GNU General Public License
v3 or GNU Lesser General Public License v3.

You may elect to redistribute this code under any of these licenses.

The Eclipse Public License is available at:
http://www.eclipse.org/legal/epl-v10.html

The GNU General Public License v3 and the GNU Lesser General Public
License v3 are available at:
http://www.gnu.org/licenses/

========================================================================
*/

import java.io.IOException;
import java.util.function.Predicate;

import schemacrawler.schemacrawler.DatabaseServerType;
import schemacrawler.tools.databaseconnector.DatabaseConnector;
import schemacrawler.tools.iosource.ClasspathInputResource;

public final class SybaseIQDatabaseConnector extends DatabaseConnector {
    private static final long serialVersionUID = 1786572065393663455L;

    /**
     * Same as in original {@link SybaseIQDatabaseConnector}.
     */
    public SybaseIQDatabaseConnector() throws IOException {
        super(new DatabaseServerType("sybaseiq", "SAP Sybase IQ"),
                new ClasspathInputResource("/schemacrawler-sybaseiq.config.properties"),
                (informationSchemaViewsBuilder, connection) -> informationSchemaViewsBuilder.fromResourceFolder("/sybaseiqodbc.information_schema")
        );
    }

    @Override
    protected Predicate<String> supportsUrlPredicate() {
        // always return false here as this conflicts with SAP Sybase ASE
        return url -> false;
    }
}
