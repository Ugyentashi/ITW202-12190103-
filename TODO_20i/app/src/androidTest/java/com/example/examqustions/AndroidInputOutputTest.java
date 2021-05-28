package com.example.examqustions;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withTagValue;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class AndroidInputOutputTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);


    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.examqustions", appContext.getPackageName());
    }

    @Test
    public void ActivityLaunch(){
        onView(withId(R.id.send)).perform(click());
        onView(withId(R.id.message)).check(matches(isDisplayed()));
        onView(withId(R.id.reply)).perform(click());
        onView(withId(R.id.message)).check(matches(isDisplayed()));
    }

    @Test
    public void textInputOutput(){
        onView(withId(R.id.Etext1)).perform(typeText("This is a text"));
        onView(withId(R.id.send)).perform(click());
        onView(withId(R.id.message)).check(matches(withText("This is a text")));
    }
}