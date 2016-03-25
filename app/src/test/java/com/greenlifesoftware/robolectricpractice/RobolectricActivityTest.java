package com.greenlifesoftware.robolectricpractice;

import android.view.View;
import android.widget.TextView;

import com.greenlifesoftware.robolectricpractice.support.ResourceLocator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import static com.greenlifesoftware.robolectricpractice.support.Assert.assertViewIsVisible;
import static com.greenlifesoftware.robolectricpractice.support.ResourceLocator.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class RobolectricActivityTest
{
    private RobolectricActivity activity;

    @Before
    public void setUp() throws Exception
    {
        activity = Robolectric.setupActivity( RobolectricActivity.class );
    }

    @Test
    public void shouldNotBeNull() throws Exception
    {
        assertNotNull( activity );
    }

    @Test
    public void shouldHaveTitle() throws Exception
    {
        assertThat( activity.getTitle().toString(),
                    equalTo( getString( R.string.app_name ) ) );
    }

    @Test
    public void shouldHaveWelcomeText() throws Exception
    {
        TextView welcomeText = (TextView) activity.findViewById( R.id.welcome_text );
        assertViewIsVisible( welcomeText );
        assertThat( welcomeText.getText().toString(),
                    equalTo( getString( R.string.WELCOME_TEXT ) ) );
    }
}