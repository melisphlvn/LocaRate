package com.example.cs310_java.screens;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.example.cs310_java.R;

public class Screen1Directions {
  private Screen1Directions() {
  }

  @NonNull
  public static NavDirections actionScreen1ToScreen2() {
    return new ActionOnlyNavDirections(R.id.action_screen1_to_screen2);
  }
}
