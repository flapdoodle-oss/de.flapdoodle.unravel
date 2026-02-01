/**
 * Copyright (C) 2017 Michael Mosmann <michael@mosmann.de>
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package de.flapdoodle.unravel.types;

import de.flapdoodle.checks.Preconditions;

public enum JavaVersion {
    V1_1(45),
    V1_2(46),
    V1_3(47),
    V1_4(48),
    V1_5(49),
    V1_6(50),
    V1_7(51),
    V1_8(52),
    V9(53),
    V10(54),
    V11(55),
    V12(56),
    V13(57),
    V14(58),
    V15(59),
    V16(60),
    V17(61),
    V18(62),
    V19(63),
    V20(64),
    V21(65),
    V22(66),
    V23(67),
    V24(68),
    V25(69),
    ;

    private final int value;

    private JavaVersion(int value) {
        this.value = value;
    }

    public static JavaVersion of(int value) {
        for (JavaVersion v : JavaVersion.values()) {
            if (v.value == value) {
                return v;
            }
        }

        return Preconditions.checkNotNull(null, "could not find version for %s", value);
    }
}
