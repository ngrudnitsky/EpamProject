
Task 1. (10 баллов) Dynamic Array
Создать собственный класс DynamicDoubleArray, содержащий внутри себя массив double [], поддерживающий добавление элемента в конец массива (add), получение элемента по индексу (get), печать внутреннего состояния (toString), удаление произвольного элемента по индексу (remove), а также возможность задать начальный размер при вызове конструктора. При изменении количества элементов внутренний массив должен пересоздаваться.

Task 2. (10 баллов) Dynamic Array with Generics
Параметризуйте класс из предыдущего домашнего задания, позволив хранить в нем массив элементов произвольного типа.

Task 3. (10 points) Classic Annotations
Use the pet project with class hierarchy.
Use next annotations correctly with explanation in comments
•	@Deprecated
•	@Override
•	@SuppressWarnings
•	@FunctionalInterface
Refactor code if it is required

Task 4. (20 points) Reflection API usage
Use the project from the previous module [Java Core I] with class hierarchy or another pet project with class hierarchy.
Rewrite your app with Reflection API:
1.	(5 points) Use reflection to instantiate all objects in client code via constructors (with or without arguments)
2.	(5 points) Use reflection API to fill private fields without setters
3.	(5 points) Use reflection API to change method calls from direct call on reflection call in client code
4.	(5 points) Print out the metadata for all classes in application in human-readable format (about all fields, methods, modifiers and etc.) 

Task 5. (10 points) Custom annotations
Use the project from the previous module [Java Core I] with class hierarchy or another pet project with class hierarchy.
Create custom annotations and use them in code
1.	@UseStackOnly which could be attached to fields and couldn’t be accessed in Runtime
2.	@UseArrayList which could be attached to methods and couldn’t be found in the bytecode
3.	@ThisCodeSmells(reviewer=”Petya”) which could be attached everywhere and could be repeatable
4.	@ProdCode which could be attached to methods only and should be accessed in Runtime

*Task 6 (10 points) How to handle annotations?
Write annotation handler for the @ThisCodeSmells annotation from the previous task source code.
It should print out
1.	All smelt code names (classes, method, fields)
2.	Authority of persons who count this code smelt and vote for it
3.	Range all smelt code areas by votes (amount of annotations)

*Task 7. (10 points) Very helpful annotation and its handler
Write annotation handler for the previous task and @ProdCode annotation
Add class ProdRunner and run all methods annotated with @ProdCode

