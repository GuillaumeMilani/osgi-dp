/*******************************************************************************
 * Copyright (c) 2018 Jens Reimann
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann <jreimann@redhat.com> - initial API and implementation
 *******************************************************************************/

def zipFile = new java.util.zip.ZipFile(new File(basedir, "target/test2.bundle1_1.0.0-SNAPSHOT.dp"))

def entries = new HashSet<String>();
zipFile
        .entries()
        .each{
            entries.add(it.name.replaceAll("(1\\.0\\.0)\\.\\d{12}(\\.jar)", "\$1\$2"))
        };

println("Found: " + entries)

return entries.equals(
        [
            "META-INF/MANIFEST.MF",
            "test2.bundle1_1.0.0.jar"
        ]
        .toSet());