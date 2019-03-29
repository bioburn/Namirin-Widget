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

<br/>
Next 

start a service with a broadcast listener that listens for device events such as unlocking the screen.
note - some events are unavailable on api level 26+
But jokes on them because my phone is on api level 23 and I don't have any internal storage space left to do an update

play sound on receive

???

profit

COMPLETED!
