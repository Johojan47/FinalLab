# FinalLab

The problem I solved is whenever I go to the gym I tend to not track my workouts or the weight that I use. So the next time I go to the gym I'm left thinking "What kind of weight did I do last week?" and I have to constantly change the weight until it's perfect. So with this you're able to record, view and save your weekly workouts. You can log what days you worked out what, for example "Tuesdays, Chest, Flat Press, 8 reps, 200lbs". This way anyone can make significant progress in the gym and not have to worry about thinking what they did last week.

1. I used Arrays by using the savedWorkouts array to hold Workout objects.

2. I used ArrayLists by using the weeklyWorkouts ArrayList to be able to let people add and view workouts without worrying about fixed sizes.

3. I used Recursion by using the InputValidator class to make sure that valid inputs using recursion to tell the user over and over until they enter valid data.

4. I used File Persistance by having the DataHandler.loadData be able to read data from files using ObjectInputStream and be able to restore it

5. I used Exception Handling by being able to catch FileNotFoundException to make sure that the program can start even if there was no previous data.

Instructions:

1. Open up your terminal and compile the java files: "javac *.java"
2. Run the main clas: "java GymTracker"
3. And you're all done!! You just follow the menu options.
