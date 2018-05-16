General Inheritance Questions:
 
1. What does the line super(5); do when placed in a class’s constructor?

	It will call the super class’s constructor with the parameter 5.
	For example, if a class extended the Tiger class, and called super(5),
	the Tiger class’s constructor would be called, and hungry would receive the value 5.

2. Assume you have a base class Superclass, and class Subclass that extends Superclass. If you have the following code:
		Superclass c = new Subclass();
	will this cause an error? (Assume Subclass has a default constructor). Why or why not?

	This will not cause an error because the Subclass “is a” type of the Superclass. The 
	only difference is that the “c” will only have access to the Superclass’ public methods, whereas
	Subclass c = new Subclass();, “c” now has access to the public methods of both the Subclass and
	the Superclass.

3. For the classes Superclass and Subclass as described above, which is true:
	a. A Superclass “is a” Subclass
	b. A Subclass “is a” Superclass
	c. Both of these
	d. Neither of these.

	Only b is true. A Superclass is not a Subclass.

4. Now assume you have classes Person and Student as defined in class.  Assume that you have a Person type variable that references a Student type object. I.e. Person p = new Student(“Sally”, 18);  If the method sayHi() is defined in the Person class and overridden in the student class, which version of the method will be called when I write p.sayHi(), the Person’s version or the Student’s version?

	The Student’s version of the sayHi() method will be called.

Inheritance Questions Based on the Implementation of Critters.java:

5. Which methods from Critter will you override in the Bear class?

	The eat(), fight(), getColor(), getMove(), and toString() methods will be overridden in the Bear class.

6. Will the following cause an error:  Bear b = new Critter();  Why or why not?

	Yes, that will cause an error because a Critter is not necessarily a Bear. Critter b = new Bear() would have worked, because a Bear is a Critter.

7. True or false: you will need to add a line of code that calls the method “eat” critters to eat food during the simulation.

	No. I only need to worry about how the critter will eat within the critter classes that I must write (Bear, Lion, Tiger, Dragon, MyCritter). Whatever methods of my critter classes are called are 	already prewritten.

8. True or false: The member variables in the Dragon class can be different and have no relation to the member variables in the Tiger class.

	True. The Dragon has independent, and private, member variables. The methods are what the Dragon and Tiger classes have in common, since they both extend Critter.

9. Explain how you could use a static member variable in the Bear class to keep track of the total number of Bears that had ever been created. (Note: There’s no need to actually do this in the code).

	You would write private static int numBears = 0; at the top of the class, above the constructor. You would then increment this within the constructor, so that every time a Bear is created, the 	numBears will be incremented.
