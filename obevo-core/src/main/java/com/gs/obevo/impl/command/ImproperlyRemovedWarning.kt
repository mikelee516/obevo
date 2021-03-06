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
package com.gs.obevo.impl.command

import com.gs.obevo.api.appdata.Change
import com.gs.obevo.impl.ChangeCommandWarning

class ImproperlyRemovedWarning(private val deployed: Change) : ChangeCommandWarning {
    override val commandDescription: String
        get() = String.format("Deployed artifact is no longer in source and has not been properly removed: %1\$s",
                this.deployed.displayString)

    override val isFatal: Boolean
        get() = true

    override val changes: List<Change>
        get() = listOf(this.deployed)
}
