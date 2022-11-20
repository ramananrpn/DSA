### **Pendency System**

[//]: # https://docs.google.com/document/d/1GaR5KaujMdj1iZPGC4U8JWAyTFYlVaLtiKG4PQrMhV4/edit?usp=sharing()

Pendency is a system that is able to track counts of in-flight/in-progress entities.
The system is told when to start tracking a particular entity, and when to stop. And at any point the system can be asked how many entities are in-progress (or in-flight). The system is expected to give this count, as fast as possible

**Problem Statement**

You need to design a system that is able to track pending entities.
An entity is identified using a unique ID and a list of hierarchical tags.
There are 3 parts to this problem statement. startTracking, endTracking and getCounts.
When an entity is being tracked, you will be provided with an identifier for the entity, and a hierarchical tags associated with the entity to be tracked.
When counts are being retrieved, you will be provided with a partial list of tags, for which the accumulated counts need to be returned. This partial list of tags will follow the same hierarchy order as given in the input. (Should become clear with the example shown below).

The following is a guide for the interfaces you may have in your system.

   1. An interface to start tracking the counts for the entity. (increment count by 1)
void startTracking (Integer id, List<String> hierarchicalTags);
where,
     `id = Identifier of the entity`
hierarchicalTags = Tags that are properties of the entity. These tags are hierarchical in nature.

   2. An interface to stop tracking the entity that is already being tracked (reduce count by 1)
      `void stopTracking (Integer id);`
      where,
      id = Identifier of the transaction

   3. An interface to get counts of entity being tracked, that match the tags supplied
       `Integer getCounts (List<String> tags);`
   where,
   tags = a hierarchy of tags, for which counts are to be retrieved


**Sample**

The following is just a sample for your understanding.

**Please remember:** You are expected to write the system which mirrors production quality code, rather than just implementing these functions

The sample below shows the ability to track in-flight transactions happening across instruments, states and cities:
## Examples for tracking and getting counts

startTracking(1112, ["UPI", "Karnataka", "Bangalore"]);
startTracking(2451, ["UPI", "Karnataka", "Mysore"]);
startTracking(3421, ["UPI", "Rajasthan", "Jaipur"]);
startTracking(1221, ["Wallet", "Karnataka", "Bangalore"]);

getCounts(["UPI"])   # represents the counts of all pending "UPI" transactions
Output: 3
getCounts(["UPI", "Karnataka"])  # represents the counts of all pending "UPI" transactions in "Karnataka"
Output: 2
getCounts(["UPI", "Karnataka", "Bangalore"]) # represents the counts of all pending "UPI" transactions in "Karnataka" and "Bangalore"
Output: 1

getCounts(["Bangalore"]) # Does not represent a valid hierarchy in the sample
Output: 0

startTracking(4221, ["Wallet", "Karnataka", "Bangalore"]);
stopTracking(1112);
stopTracking(2451);

getCounts(["UPI"])
Output: 1
getCounts(["Wallet"])
Output: 2
getCounts(["UPI", "Karnataka", "Bangalore"])
Output: 0


#### **Requirements P0**

1. Implement the above with appropriate assumptions for the example shown above.
2. Optimize your solution for time/space complexity taking reasonable tradeoffs.
3. You can limit your implementation, specifically for transactions (as shown in the example: startTracking(transactionID, [instrument, state, city]);
4. You can choose to assume that the hierarchical tags are of fixed size of 3 and are instrument, state, city.
5. You can simulate the operations of tracking and getting counts as shown in the sample, using a main function or test cases
6. You should have a working code that demonstrates the same.
7. Handle error scenarios appropriately

#### **Requirements P1**

1. Make your library/interfaces generic enough to be used for tracking any entities with any number of hierarchical tags. Not just transactions with 3 tags.
   Eg: Track pending restaurant orders, and fetch counts of pending orders per location, or counts of pending orders per location and specific restaurant and specific cuisine
2. startTracking(orderId, [location, restaurant, cuisine, title])

#### **Things to keep in mind**
* You are only allowed to use in-memory data structures
* You are NOT allowed to use any databases
* You are NOT required to have a full-fledged web service or APIs exposed
* A working code is ABSOLUTELY NECESSARY. Evaluation will not be done if your code is not running. So ensure you time yourselves accordingly
* You are required to showcase the working of the above concept
* Just a main class that simulates the above operations is enough
* Should you have any doubts, you are allowed to make appropriate assumptions, as long as you can explain them during the evaluation.
* You are allowed to code on your favourite IDEs as long as you paste the code back into the tool within the allotted time frame

##### **How you will be evaluated**

You are expected to write production quality code while implementing the requirements.
1. We look for the following:
   1. Separation of concerns
   2. Abstractions
   3. Application of OO design principles
   4. Testability
   5. Code readability
   6. Language proficiency
   [execution time limit] 14 seconds (js)


