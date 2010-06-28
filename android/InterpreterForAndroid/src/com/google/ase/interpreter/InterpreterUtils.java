/*
 * Copyright (C) 2010 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.ase.interpreter;

import android.content.Context;

import java.io.File;

public class InterpreterUtils {

  private InterpreterUtils() {
    // Utility class
  }

  public static File getInterpreterRoot(Context context) {
    return context.getFilesDir().getParentFile();
  }

  public static File getInterpreterRoot(Context context, String interpreterName) {
    return new File(getInterpreterRoot(context), interpreterName);
  }

  public static boolean isInstalled(Context context, String name) {
    File interpreterDirectory = getInterpreterRoot(context, name);
    File interpreterExtrasDirectory = new File(InterpreterConstants.INTERPRETER_EXTRAS_ROOT, name);
    return interpreterDirectory.exists() || interpreterExtrasDirectory.exists();
  }

  public static boolean isInstalled(Context context, InterpreterDescriptor descriptor) {
    return isInstalled(context, descriptor.getName());
  }
}
