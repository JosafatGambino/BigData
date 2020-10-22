
## PAIR CODING

**Pair coding**, also known as _pair programming_, consists of two programmers who share a single 
workstation (a screen, keyboard, and mouse between the peer).

The programmer on the keyboard is usually called the _driver_, the other is also actively involved in 
the programming task, but focusing more on the general direction is the _navigator_; developers are 
expected to exchange roles every few minutes or so.

### **Roles**

These definitions of classic peer programming roles can be applied in one way or another to many of 
the approaches for pairing.

The _driver_ is the person behind the wheel, that is, the keyboard. It focuses on completing the small 
goal in question and ignoring bigger problems. A driver should always talk through what he's doing while 
doing it.

The _navigator_ is in the observer position, while the driver is typing. Take care of reviewing the 
code on the fly, he gives instructions and shares thoughts. The navigator also has a focus on the most 
errors, and takes notes of possible steps or obstacles.

The idea of this role division is to have two different perspectives on the code. The thought of 
the driver is more tactical, thinking about the details, the lines of code by hand. The navigator 
can think more strategically in his observational role. They have the big picture in mind.

A common flow reads like this:

* Start with a reasonably well-defined task.
* Agree one small goal at a time. This can be defined by a test, or by a confirmation message, or 
  written on a sticky note.
* Change keyboard and roles regularly. Shared active participation maintains the level of energy, 
  this way you learn and understand things better.
* As a navigator, avoid the "tactical" thinking mode, leave the coding details to the driver, your 
  job is to take a step back and complement your partner's most tactical way with medium-term thinking. 
  Take into account the next steps, note the potential obstacles and ideas to discuss them after the 
  little objective, in order not to interrupt the flow of the driver.


### **Techniques**
##### ___“Ping Pong”___
This technique adopts test-driven development (TDD). It is recommended to apply it when you have a 
clearly defined task that can be implemented in a way. 

* "Ping": Developer A writes a failed test.
* "Pong": Developer B writes the deployment to pass.

Developer B then starts the following "Ping", that is, the next error test.

Each "Pong" can also continue to refactor the code together, before moving on to the next failed test. 
This follows the "Red - Green - Refactor" approach: Write a failed test (red), pass it with the minimum 
means (green) and then refactor.

##### ___“Strong-Style Pairing”___

This is a particularly useful technique for knowledge transfer, described by Llewellyn Falco.

The rule is: "To bring an idea from head to computer MUST pass through someone else's hands". In this 
style, the _navigator_ is usually the most experienced person with the settings or task in issue, 
while the _driver_ is a beginner (with language, tool, codebase, ...). The experienced person stays 
mainly in the role of navigator and guides the beginner.


## CONCLUSION

Pair coding is a way to program together, exactly two people. A person will be in charge of computer, 
i.e manipulation of keyboard, mouse and software. It is known as a driver because it drives the 
programming of a proposed goal. He'll have to be explaining what he's programming at once so that the 
other partner understands what's being done.

The other person known as a navigator is the one who carries the direction of work, for example: 
a director of a movie, who directs the actions, ideas and executions to be performed in the project, 
however, the navigator is open to taking into account the different perspectives and opinions of his 
partner.

Pair coding sees an advantage as the saying goes, "Two heads think better than one", but why? Because 
one mind when trying to find a solution, it has ideas and knowledge of its own to another person.
So when we make mistakes many times, we can't see where we've made a mistake. And this good practice 
helps us a lot to visualize these kinds of situations.
Working together is also very feasible to find different solutions, because of the existence of different 
ideas, observations or ways of seeing things.

Basically this programming style aims to take a focus on meeting the goal with the help of two minds to 
find solutions, working efficiently as someone drives programming and meets short goals the navigator 
directs programming with its ideas but expanding potential challenges or scenarios found future development 
of the project.

