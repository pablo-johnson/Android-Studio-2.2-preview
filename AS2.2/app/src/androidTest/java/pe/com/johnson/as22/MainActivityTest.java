package pe.com.johnson.as22;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {
        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.editText3),
                        withParent(allOf(withId(R.id.linearContainer),
                                withParent(withId(R.id.content_main)))),
                        isDisplayed()));
        appCompatEditText.perform(click());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.editText3),
                        withParent(allOf(withId(R.id.linearContainer),
                                withParent(withId(R.id.content_main)))),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("pablo@gmail.com"));

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.editText4),
                        withParent(allOf(withId(R.id.linearContainer),
                                withParent(withId(R.id.content_main)))),
                        isDisplayed()));
        appCompatEditText3.perform(replaceText("12345"));

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.myButton), withText("Login"),
                        withParent(allOf(withId(R.id.linearContainer),
                                withParent(withId(R.id.content_main)))),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction imageView = onView(
                allOf(withId(R.id.imageView),
                        withParent(allOf(withId(R.id.constraintLayout),
                                withParent(allOf(withId(android.R.id.content),
                                        withParent(withId(R.id.decor_content_parent)))))),
                        isDisplayed()));
        imageView.check(matches(isDisplayed()));

        ViewInteraction textView = onView(
                allOf(withId(R.id.textView), withText("Lima"),
                        withParent(allOf(withId(R.id.constraintLayout),
                                withParent(allOf(withId(android.R.id.content),
                                        withParent(withId(R.id.decor_content_parent)))))),
                        isDisplayed()));
        textView.check(matches(withText("Lima")));

    }
}
