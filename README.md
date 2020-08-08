<p align="center">
  <a href="https://img.shields.io/badge/License-MIT-yellow.svg"><img src="https://img.shields.io/badge/License-MIT-yellow.svg"></a>
  <a href="https://badges.frapsoft.com/os/v2/open-source.svg?v=103"><img src="https://badges.frapsoft.com/os/v2/open-source.svg?v=103"></a>
</p>

# Android Analytics Architecture
Analytics are really helpful to the developer. It gives us more insights on users behavior towards the application and also helps you to develop features depending on their behavior
and liking which gives more success to the developer.

This project is useful in defining your analytics layer. I just created this project in a simple manner to explain how I define my rules in creating an analytics layer in my project.
This is also helpful to the people who have multi module project. With the idea I have presented, you need not expose all the events to all modules. Each module can have it's own analytics
layer which takes info from core-analytics layer. So, that it encapsulates info like you needed.

This is pretty flexible.
If your boss asks you to add a different analytics service. It will be super easy for the dev to add one more layer and prototype it to the requested persons. That's the part the dev 
will enjoy this hardwork.


## TODO 🔨
🛠️ Write Unit tests to show how this implementation won't get coupled with your business logic

---

##  How to use?
```kotlin
// code away!
//Let's try to add redirect to my youtube channel button event
//Go to AnalyticsConstants

object ItemClicked {
            const val EVENT = "item_selected"

            object Params {
                const val TIME_BETWEEN_CLICKS = "time_between_clicks"
                const val BUTTON_NAME = "button_name"
            }

            object ItemNames {
                const val SUBSCRIBE_BUTTON_NAME = "subscribe_button_name"
                const val BELL_ICON_FAB = "bell_icon_fab"
                const val OPEN_YOUTUBE_CHANNEL_BUTTON_NAME = "open_youtube_channel_button_name" // Here we added our extra button
            }
        }
        
//Say suppose our button is in dashboard events screen. This can be a separate module or separate screen depending on your codebase
//All you need to do is you need to add one more event under DashBoardEvents

    class OpenYoutubeChannelEvent(
        timeBetweenClicks: Long
    ) : AnalyticsEvent(
        AnalyticsConstants.Events.ItemClicked.EVENT,
        mapOf(
            AnalyticsConstants.Events.ItemClicked.Params.BUTTON_NAME to AnalyticsConstants.Events.ItemClicked.ItemNames.OPEN_YOUTUBE_CHANNEL_BUTTON_NAME,
            AnalyticsConstants.Events.ItemClicked.Params.TIME_BETWEEN_CLICKS to timeBetweenClicks
        )
    )    
    
//You can still make changes and optimize the code to make it simple over there. All I'm trying to say is our DashboardEvents only expose events related to that screen
//instead of exposing all analytics constants. That's the beauty (I feel like that lol)

//Now go to DashboardAnalyticsInteractor class and add your event clicked. This class helps in sending the logs using analytics service and simply this will be injected to viewmodel. Which is great case for unit testing too. Voila, now you also unit tested that you are logging specific required events too :P 

    fun openYoutubeChannelButtonClicked() {
        analyticsService.log(
            DashboardEvents.OpenYoutubeChannelEvent(
                AnalyticsUtils.getTimeDurationInSecBetweenNow(startTime)
            )
        )
        startTrackingTime()
    }
    
//Don't get confused by startTrackingTime -> I just made an example for myself so that your event also records after how many seconds you did the next click.... It works like //charm
 
//Final bonus tip: Your boss told you to add one more AnalyticsService- say suppose mixedpanel. 
//In the app go to analytics provider package. Add your service class

class MixedPanelAnalyticsService : AnalyticsService {

    override fun init(context: Context) {
        //Init your MixedPanelAnalytics --> They must have some kind of token stuff
    }

    override fun log(event: AnalyticsEvent) {
        //Take the event and you need to add a mapper to upload the event to mixedpanels service because some services prefer JSON, some prefer bundle data
        // which is fairly easy to implement
    }
}

//Later go to AppModule 
    fun provideAnalyticsManager(@ApplicationContext context: Context): AnalyticsService {
        val analyticsManager = AnalyticsManager()
        analyticsManager.add(DebugAnalyticsService())
        analyticsManager.add(MixedPanelAnalyticsService()) //Added your new service and no code changes yay
        analyticsManager.init(context)
        return analyticsManager
    }

//One more boooonus tip lol: There will be cases where you are using multiple analytics services and for few events you just want to use only one service
//For that you can maintain ENUM for what analytics you currently have and attach them to AnalyticEvent class so that. You can mention what analytic services you want
//to use. I can make a continuation video on this part too. But later.
```
---

### Worked really hard for this project. Please show some love subscribing to my Youtube channel. I appreciate feedback. Feel free to contact me for furthur changes.
https://www.youtube.com/channel/UCSSnixu_IO8dvgnv9Gi1AHw?view_as=subscriber

##  Animated Gif 📷
![Android Analytics Architecture - Animated gif demo](demo/demo.gif)

## License
```
MIT License

Copyright (c) 2020 Sri Harsha Pothineni

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
