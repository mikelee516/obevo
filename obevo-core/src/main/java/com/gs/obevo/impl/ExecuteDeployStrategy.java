/**
 * Copyright 2017 Goldman Sachs.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.gs.obevo.impl;

/**
 * The standard deployment behavior.
 */
class ExecuteDeployStrategy implements DeployStrategy {
    public static final ExecuteDeployStrategy INSTANCE = new ExecuteDeployStrategy();

    protected ExecuteDeployStrategy() {
    }

    @Override
    public String getDeployVerbMessage() {
        return "deployed";
    }

    @Override
    public void deploy(ExecuteChangeCommand changeCommand) {
        changeCommand.execute();
    }

    @Override
    public boolean isInitAllowedOnHashExceptions() {
        return false;
    }
}