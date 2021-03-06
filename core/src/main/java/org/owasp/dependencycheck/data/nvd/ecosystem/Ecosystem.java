/*
 * This file is part of dependency-check-core.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Copyright (c) 2020 The OWASP Foundation. All Rights Reserved.
 */
package org.owasp.dependencycheck.data.nvd.ecosystem;

import org.owasp.dependencycheck.utils.Settings;

/**
 * Collection of the standard ecosystems for dependency-check.
 *
 * @author Jeremy Long
 */
public final class Ecosystem {

    public final static String RUBY = "ruby";
    public final static String DOTNET = "dotnet";
    public final static String IOS = "ios";
    public final static String PHP = "php";
    public final static String GOLANG = "golang";
    public final static String JAVA = "java";
    public final static String NATIVE = "native";
    public final static String PYTHON = "python";
    public final static String JAVASCRIPT = "js";
    public final static String NODEJS = "nodejs";
    public final static String RUST = "rust";
    public final static String COLDFUSION = "coldfusion";
    public final static String PERL = "perl";
    public final static String ELIXIR = "exlixir";

    private final Settings settings;
    private final int defaultQuerySize;

    /**
     * Instantiates the ecosystem utility class.
     *
     * @param settings the ODC configuration
     */
    public Ecosystem(Settings settings) {
        this.settings = settings;
        this.defaultQuerySize = settings.getInt(Settings.KEYS.MAX_QUERY_SIZE_DEFAULT, 100);
    }

    /**
     * Returns the max query result size for the Lucene search for each
     * ecosystem.
     *
     * @param ecosystem the ecosystem
     * @return the max query result size
     */
    public int getLuceneMaxQueryLimitFor(String ecosystem) {
        return settings.getInt(Settings.KEYS.MAX_QUERY_SIZE_PREFIX + ecosystem, defaultQuerySize);
    }
}
