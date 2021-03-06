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
package com.gs.obevo.api.appdata

import com.gs.obevo.api.platform.ChangeType

/**
 * The fields that consist the identity of objects within a client codebase.
 */
data class ObjectKey(val schema: String, val objectName: String, val changeType: ChangeType) {
    val changeTypeName: String
        get() = changeType.name

    fun toStringShort(): String {
        return schema + "-" + objectName + "-" + changeType.name
    }
}
