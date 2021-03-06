// Copyright 2018 The Bazel Authors. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.devtools.build.skydoc.fakebuildapi.config;

import com.google.devtools.build.lib.events.Location;
import com.google.devtools.build.lib.skylarkbuildapi.config.ConfigGlobalLibraryApi;
import com.google.devtools.build.lib.skylarkbuildapi.config.ConfigurationTransitionApi;
import com.google.devtools.build.lib.syntax.BaseFunction;
import com.google.devtools.build.lib.syntax.SkylarkDict;
import com.google.devtools.build.lib.syntax.StarlarkSemantics;
import com.google.devtools.build.lib.syntax.StarlarkThread;
import java.util.List;

/**
 * Fake implementation of {@link ConfigGlobalLibraryApi}.
 */
public class FakeConfigGlobalLibrary implements ConfigGlobalLibraryApi {

  @Override
  public ConfigurationTransitionApi transition(
      BaseFunction implementation,
      List<String> inputs,
      List<String> outputs,
      Location location,
      StarlarkThread thread) {
    return new FakeConfigurationTransition();
  }

  @Override
  public ConfigurationTransitionApi analysisTestTransition(
      SkylarkDict<String, String> changedSettings, Location location, StarlarkSemantics semantics) {
    return new FakeConfigurationTransition();
  }
}
