package com.example.zack.hydrationreminder.sync;

import android.content.Context;


import com.example.zack.hydrationreminder.utilities.NotificationUtils;
import com.example.zack.hydrationreminder.utilities.PreferenceUtilities;

import static com.example.zack.hydrationreminder.utilities.PreferenceUtilities.incrementWaterCount;

/**
 * Created by zack on 6/10/17.
 */

// TODO (1) Create a class called ReminderTasks
public class ReminderTasks{

// TODO (2) Create a public static constant String called ACTION_INCREMENT_WATER_COUNT
    public static final String ACTION_INCREMENT_WATER_COUNT = "increment-water-count";
    public static final String ACTION_DISMISS_NOTIFICATION = "dismiss-notification";

    // Notifications without need to click a button
    public static final String ACTION_CHARGING_REMINDER = "charging-reminder";

// TODO (6) Create a public static void method called executeTask
    public static void executeTask(Context context, String action){
// TODO (7) Add a Context called context and String parameter called action to the parameter list

// TODO (8) If the action equals ACTION_INCREMENT_WATER_COUNT, call this class's incrementWaterCount
        if (ACTION_INCREMENT_WATER_COUNT.equals(action)){
            incrementWaterCount(context);
        } else if (ACTION_DISMISS_NOTIFICATION.equals(action)){
            NotificationUtils.clearAllNotifications(context);
        } else if (ACTION_CHARGING_REMINDER.equals(action)){
            issueChargingReminder(context);
        }
    }

    public static void issueChargingReminder(Context context){
        PreferenceUtilities.incrementChargingReminderCount(context);
        NotificationUtils.remindUserBecauseCharging(context);
    }
// TODO (3) Create a private static void method called incrementWaterCount
    private static void incrementWaterCount(Context context){
// TODO (4) Add a Context called context to the argument list
// TODO (5) From incrementWaterCount, call the PreferenceUtility method that will ultimately update the water count
        PreferenceUtilities.incrementWaterCount(context);
        // clear notification if the water was incremented
        NotificationUtils.clearAllNotifications(context);
    }

}