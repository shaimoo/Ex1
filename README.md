
# Extend StdringBuilder 


- Nir Meir 
- Shai Moshe 

# About the Project:
This is task 2 in our OOP course.
The idea of the project is to implement Observer design pattern, by creating group admin (Observerable) that
notify members (Observers) in any change that happend.

# Code Description:

- ConcreteMember.java : Implement the member interface and represent the Observer.
- GroupAdmin.java : Implement the sender interface and represent the Observerable.
- UndoableStringBuilder.java : Class to create object of StdringBuilder.
- JvmUtilities.java : Utility class for tracking the Java Virtual Machine (JVM) resources allocated by the Operating System.
- Member.java : Interface.
- Sender.java : Interface.

# Functions Description
### GroupAdmin functions:
- Register - This function add the observer (member) to the observable (group admin).
- Unregister - This function removes the observer (member)  from the observable (group admin).
- Insert - This function insert new string to our stringBuilder in specific location.
- Append - This function add a string to our stringBuilder in the end of index.
- Delete - This function delete from the stringBuilder in specific start and end location.
- Undo - This function is pop from the stack the previous stringBuilder and update our stringBuilder.
- NotifyObservers - This function are update the document for every member that registered.

### ConcreteMember:
- Update - This function Update the document copy.



# How to Run:
Firstly, to run this project, download the files from the github.
Secondly, open the pom.xml file from Intellij or any different IDE.
Open the Test class and Run the file.


# Memory results

- Insert Function 

![](https://i.ibb.co/gry9bvz/Insert.jpg)

- Append Function

![](https://i.ibb.co/6gmHBs4/append.jpg)

- Delete Function 

![](https://i.ibb.co/FszxSD8/delete.jpg)

- Undo Function

![](https://i.ibb.co/dtNqPKg/undo.jpg)

