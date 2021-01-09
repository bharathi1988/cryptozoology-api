Stories and Acceptance Criteria
---------------------------------------------------------------------------------
As zookeeper, I want to add animals to my zoo.
````
Rule: Animal should have a name and a type (flying, swimming, walking)

When I add an animalDto
Then it is in my zoo
````
---------------------------------------------------------------------------------
As zookeeper, I want to view animals of my zoo.

````
Given I have added animals to my zoo
When I check my zoo
Then I see all the animals
````
---------------------------------------------------------------------------------
As a zookeper, I want to feed my animals.

````
Rule: Animal moods are unhappy or happy. They are unhappy by default.
````
````
Given an animal is unhappy
When I give it a treat
Then the animal is happy
````
````
Given an animal is happy
When I give it a treat
Then the animal is still happy
````
---------------------------------------------------------------------------------
As a zookeeper, I want to maintain different types of habitats so that 
I can put different types of animals in them.
````
Given I have an empty <habitat>
When I put animal of <type> into a compatible habitat
Then the animal is in the habitat
````
````
Given I have an empty <habitat>
When I put animal of <type> into an incompatible habitat
Then the animal habitat should not change
And the animal becomes unhappy
````
````
Given I have an occuppied habitat
When I put an animal into the occupied habitat
Then the animal habitat should not change

|   type  |  habitat  |
| --------- | --------- | 
| flying     |   nest    | 
| swimming  |   ocean   | 
| walking   |   forest  | 
````
---------------------------------------------------------------------------------

As a zookeeper, I want to search zoo data so that I can make reports on my zoo.
````
Given I have animals in my zoo
When I search for <mood> and <type>
Then I see a list of animals matching only <mood> and <type>
````
````
Given I have habitats in my zoo
When I search for empty habitats
Then I see a list of empty habitats
````
---------------------------------------------------------------------------------
|Functionality|Request Method|URI|Description|Status
|-------------|:-------------|:---|:----------|-----:|
|Add animal|Post|/zoo/animals|Adding animal to zoo| 201
|Get all Animals from Zoo|Get|/zoo/animals|Get all animals from the Database|200 
|Feed Animal - treat animal|Put|/zoo/animals| Pass in Animal ID and get the animal object as response|200
|Allocate habitat to the animal|Post|/zoo/allocateanimals| post habitat and Animal ID, get animal object as response|200 
|Search animals|POST|/zoo/search|post report type to fetch the Animal Report|200









