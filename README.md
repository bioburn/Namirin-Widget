# Namirin-Widget
Ara Ara

<H2>About</H2>
This widget was made for fun

<br/>
It also confuses the heck out of me. I thought I should have a service handle playing audio every time the widget gets clicked, right?
But if I do that, the media player stops working after 50 or so clicks. I am making sure to release it on completion.

I thought it might have to do with creating too many service instances, but I was pretty sure the service gets destroyed after executing
the code to play the media player. 

In the end I put the mediaplayer logic in a broadcast receiver instead. How much battery will this use up?

<H5>Notes</H5>
  Service vs IntentService
  <br/>
  https://stackoverflow.com/questions/15524280/service-vs-intentservice
  
  Which one is best suited to listen for phone events?
  
  IntentService runs on background thread, which would be nice for playing a short sound, and to listen for events?
  Initially tried with intentservice but had trouble registering the broadcastreceiver to it... will revisit in the future
  IntentService destroys self upon executing all code
  

<br/>
Next 

1.
start a service with a broadcast listener that listens for device events such as unlocking the screen. **Complete**
note - some events are unavailable on api level 26+
But jokes on them because my phone is on api level 23 and I don't have any internal storage space left to do an update

play sound on receive

???

profit

2.
On unlock screen, show avatar animation on top of screen


