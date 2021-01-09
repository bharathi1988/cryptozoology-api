Stories and Acceptance Criteria
---------------------------------------------------------------------------------
As zookeeper, I want to add animals to my zoo.

Rule: Animal should have a name and a type (flying, swimming, walking)

When I add an animalDto
Then it is in my zoo
---------------------------------------------------------------------------------
As zookeeper, I want to view animals of my zoo.

Given I have added animals to my zoo
When I check my zoo
Then I see all the animals
---------------------------------------------------------------------------------
As a zookeper, I want to feed my animals.

Rule: Animal moods are unhappy or happy. They are unhappy by default.

Given an animal is unhappy
When I give it a treat
Then the animal is happy

Given an animal is happy
When I give it a treat
Then the animal is still happy

---------------------------------------------------------------------------------
As a zookeeper, I want to maintain different types of habitats so that 
I can put different types of animals in them.

Given I have an empty <habitat>
When I put animal of <type> into a compatible habitat
Then the animal is in the habitat

Given I have an empty <habitat>
When I put animal of <type> into an incompatible habitat
Then the animal habitat should not change
And the animal becomes unhappy

Given I have an occuppied habitat
When I put an animal into the occupied habitat
Then the animal habitat should not change

|   type  |  habitat  |
| --------- | --------- | 
| flying     |   nest    | 
| swimming  |   ocean   | 
| walking   |   forest  | 

---------------------------------------------------------------------------------

As a zookeeper, I want to search zoo data so that I can make reports on my zoo.

Given I have animals in my zoo
When I search for <mood> and <type>
Then I see a list of animals matching only <mood> and <type>

Given I have habitats in my zoo
When I search for empty habitats
Then I see a list of empty habitats

---------------------------------------------------------------------------------

Add animal(Post request) :   /zoo/animals — Adding animal to zoo and post use
- 201 created 

Get all Animals from ZOO (Get request) :   /zoo/animals
- 200 

Feed Animal - treat animal : /zoo/animals -- put animal name and type
- 200 response , animal object as response

Allocate habitat to the animal : /zoo/allocateanimals - post habitat and animal
 - return 200 response , animal object as response

Search animals based mood and type : /zoo/search - post mood and type

- return 200 response also report of animals from zoo







