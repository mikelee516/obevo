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
package com.gs.obevo.cmdline;

import java.io.File;

import com.gs.obevo.api.platform.GraphExportFormat;
import com.gs.obevo.util.ArgsParser;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class DeployerArgsTest {
    @Test
    public void testMinimal() {
        DeployerArgs args = parseArgs("-sourcePath abc");
        assertEquals("abc", args.getSourcePath());
        assertNull(args.getEnvNames());
        assertNull(args.getChangesets());
        assertEquals(null, args.getForceEnvSetup());
    }

    @Test
    public void testEnvs() {
        DeployerArgs args = parseArgs("-sourcePath abc -env e1,e2,e3 -forceEnvSetup");
        assertEquals("abc", args.getSourcePath());
        assertArrayEquals(new String[] { "e1", "e2", "e3" }, args.getEnvNames());
        assertEquals(true, args.getForceEnvSetup());
    }

    @Test
    public void testChangesets() {
        DeployerArgs args = parseArgs("-sourcePath abc -changesets c1,c2,c3 -forceEnvSetup");
        assertEquals("abc", args.getSourcePath());
        assertArrayEquals(new String[] { "c1", "c2", "c3" }, args.getChangesets());
        assertEquals(true, args.getForceEnvSetup());
    }

    @Test
    public void testGraphArgs() {
        DeployerArgs args = parseArgs("-sourcePath abc -sourceGraphExportFile /home/myfile.txt -sourceGraphExportFormat GML");
        assertEquals("abc", args.getSourcePath());
        assertEquals(new File("/home/myfile.txt"), args.getSourceGraphExportFile());
        assertEquals(GraphExportFormat.GML, args.getSourceGraphExportFormat());
    }

    private DeployerArgs parseArgs(String argsStr) {
        return new ArgsParser().parse(argsStr.split(" "), new DeployerArgs());
    }
}