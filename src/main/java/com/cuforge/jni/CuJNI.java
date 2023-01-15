package com.cuforge.jni;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

import edu.wpi.first.util.RuntimeLoader;

/**
 * LibCu JNI
 */
public class CuJNI {
  static boolean libraryLoaded = false;
  static RuntimeLoader<CuJNI> loader = null;

  /**
   * Native library extraction helper class.
   */
  public static class Helper {
    private static AtomicBoolean extractOnStaticLoad = new AtomicBoolean(true);

    /**
     * Returns true if the native libraries will be extracted upon static load.
     *
     * @return Whether to extract the native libraries upon static load.
     */
    public static boolean getExtractOnStaticLoad() {
      return extractOnStaticLoad.get();
    }

    /**
     * Sets whether the native libraries will be extracted upon static load.
     *
     * @param load Whether to extract.
     */
    public static void setExtractOnStaticLoad(boolean load) {
      extractOnStaticLoad.set(load);
    }
  }

  static {
    if (Helper.getExtractOnStaticLoad()) {
      try {
        loader = new RuntimeLoader<>("LibCu", RuntimeLoader.getDefaultExtractionRoot(), CuJNI.class);
        loader.loadLibrary();
      } catch (IOException ex) {
        ex.printStackTrace();
        System.exit(1);
      }
      libraryLoaded = true;
    }
  }

  /**
   * Force load the library.
   * @throws java.io.IOException thrown if the native library cannot be found
   */
  public static synchronized void forceLoad() throws IOException {
    if (libraryLoaded) {
      return;
    }
    loader = new RuntimeLoader<>("LibCu", RuntimeLoader.getDefaultExtractionRoot(), CuJNI.class);
    loader.loadLibrary();
    libraryLoaded = true;
  }

  /**
   * Initializes the JNI library.
   *
   * @return The JNI instance handle.
   */
  public static native int initialize();
}
