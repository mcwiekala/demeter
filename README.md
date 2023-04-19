## The Law of Demeter 

### Don't talk to strangers 
#### …or just don't breathe down someone's neck
The object should not know about the innards of objects it manipulates. Objects should hide their data structure and expose their behaviours. In a nutshell inside a method, we should only use parameters or class fields.

![image](./board.png)


### The formal definition
More formally, the Law of Demeter requires that a method m of an object O may only invoke the methods of the following kinds of objects:
- itself
- m's parameters
- any objects created within m
- an object held inside O

#### This repository is a part of my article about Clean Code you can read it here: 

Medium 

LinkedIn 

