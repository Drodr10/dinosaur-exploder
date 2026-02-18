/*
 * SPDX-FileCopyrightText: 2026 jvondermarck
 * SPDX-License-Identifier: MIT
 */

package com.dinosaur.dinosaurexploder.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LevelManagerTest {
  private LevelManager levelManager;

  @BeforeEach
  void setUp() {
    levelManager = new LevelManager();
  }

  @Test
  void testHeartTracking() {
    assertEquals(0, levelManager.getHeartsCollected());
    levelManager.incrementHeartsCollected();
    assertEquals(1, levelManager.getHeartsCollected());
  }

  @Test
  void testLevelProgression() {
    assertEquals(1, levelManager.getCurrentLevel());
    levelManager.nextLevel();
    assertEquals(2, levelManager.getCurrentLevel());
  }

  @Test
  void testSessionTimerFormatting() {
    String timeFormatted = levelManager.getSessionTimeFormatted();
    assertNotNull(timeFormatted);
    assertTrue(timeFormatted.matches("\\d{2}:\\d{2}"), "Session time should be formatted as MM:SS");
  }
}
