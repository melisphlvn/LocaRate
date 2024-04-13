package com.example.cs310_java.screens;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.example.cs310_java.R;

public class Screen2Directions {
  private Screen2Directions() {
  }

  @NonNull
  public static NavDirections actionScreen2ToScreen3() {
    return new ActionOnlyNavDirections(R.id.action_screen2_to_screen3);
  }
}
