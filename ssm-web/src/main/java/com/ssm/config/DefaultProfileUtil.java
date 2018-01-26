package com.ssm.config;

import org.springframework.core.env.Environment;

public final class DefaultProfileUtil {

  private static final String SPRING_PROFILE_DEFAULT = "spring.profiles.default";

  private DefaultProfileUtil() {
  }

  /**
   * Get the profiles that are applied else get default profiles.
   *
   * @param env spring environment
   * @return profiles
   */
  public static String[] getActiveProfiles(Environment env) {
    String[] profiles = env.getActiveProfiles();
    if (profiles.length == 0) {
      return env.getDefaultProfiles();
    }
    return profiles;
  }
}