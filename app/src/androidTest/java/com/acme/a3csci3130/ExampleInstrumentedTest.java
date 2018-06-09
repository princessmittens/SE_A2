package com.acme.a3csci3130;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import android.database.Cursor;
import android.widget.SimpleCursorAdapter;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.CursorMatchers.withRowString;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("com.acme.a3csci3130", appContext.getPackageName());
    }

    @Test
    public void testCreate() {
        onView(withId(R.id.submitButton)).perform(click());
        onView(withId(R.id.name)).perform(typeText("FishRUS"), closeSoftKeyboard());
        onView(withId(R.id.num)).perform(typeText("123456789"), closeSoftKeyboard());
        onView(withId(R.id.bustype)).perform(typeText("Fish Monger"), closeSoftKeyboard());
        onView(withId(R.id.address)).perform(typeText("123 Cat Avenue"), closeSoftKeyboard());
        onView(withId(R.id.province)).perform(typeText("NS"), closeSoftKeyboard());
        onView(withId(R.id.email)).perform(typeText("cats@catsalot.com"), closeSoftKeyboard());
        onView(withId(R.id.submitButton)).perform(click());
//http://www.qaautomated.com/2016/01/testing-with-espresso-data-adapter.html
        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0).
                check(matches(withText("FishRUS")));
    }

    @Test
    public void testUpdate() {
  //     onData(withRowString(DB.COLUMN_FIRSTNAME, "Ivan")).perform(click());
      onData(instanceOf(MainActivity.class)).atPosition(0).perform(click());
    ///   onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());
//        onView(withId(R.id.name)).perform(typeText("FishRUSCatsTEST"), closeSoftKeyboard());
//        onView(withId(R.id.num)).perform(typeText("123456789"), closeSoftKeyboard());
//        onView(withId(R.id.bustype)).perform(typeText("Fisher"), closeSoftKeyboard());
//        onView(withId(R.id.address)).perform(typeText("123 Cat Avenue"), closeSoftKeyboard());
//        onView(withId(R.id.province)).perform(typeText("NS"), closeSoftKeyboard());
//        onView(withId(R.id.email)).perform(typeText("cats@catsmeow.com"), closeSoftKeyboard());
//        onView(withId(R.id.updateButton)).perform(click());
        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0).
                check(matches(withText("FishRUSCats")));
    }

//    @Test
//    public void testCreate() {
//        onView(withId(R.id.edit)).perform(typeText(badpass),closeSoftKeyboard());
//        onView(withId(R.id.button)).perform(click());
//        onView(withText("Invalid password, please try again.")).check(matches(withId(R.id.view)));
//    }
}
