# Jets

## About Jets
This is a program demonstrating the use of Lists of Object Oriented classes as Jets. On the program's launch, <u>File IO</u> will read in, from a local ***jets.txt*** file, and *populate an Airfield object with a fleet of jets* added to a <u>List</u>.  

The user will have a 9 option, looping, menu: 

1. **List fleet**- *Lists each jet in the fleet and its data.*
2. **Fly all jets**- *All capable planes take off and list their distance traveled based on speed and range.*
3. **View fastest jet**- *Returns the user the fastest jet in the fleet.*
4. **View jet with longest range**- *Returns the user the jet with the longest range in the fleet.*
5. **Load all Cargo Jets**- *Each CargoCarrying plane prints out a message talking about loading its Cargo.*
6. **Dogfight!**- *Each CombatCapable plane prints out a message about joining the fight.*
7. **Add a jet to Fleet**- *The user can add a jet to the Fleet by inputing all of the jet's class fields.*
8. **Remove a jet from Fleet**- *The user can remove a jet from the fleet.*
9. **Quit**- *Self explanatory...*

## Types of Jets


 ModelType | Extends | Implements    
 --- | :---: | --- 
 CargoPlane    | Jet | CargoCarrying 
 SuperGuppy    | Jet | CargoCarrying 
 FighterJet    | Jet | CombatReady   
 PredatorDrone | Jet | CombatReady  
 JetImpl       | Jet |               
 UAV           | Jet |               


# Lessons Learned
+ Re-enforced FileIO in Java
+ Re-enforced OOP principles (APIE)
+ Re-enforced UML Design
+ Demonstrates protected fields
+ Demonstrates abstract class
+ Demonstrates interfaces
+ Java List: Iterating -- Adding -- Removing -- Initializing
+ Try/Catch/Finally including with resources
+ Tracking and Closing project "issues" on github
+ Markdown Tables and more formatting


# Technology Used
* Eclipse
* Terminal
* Git



















