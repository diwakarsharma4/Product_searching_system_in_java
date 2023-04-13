# please update jre system to 1.7 in eclipse for this project.

# This program is able to aotomatically detect in a specific directory for any changes in it
such as file deletion, new file addition, file modification.

# On any change occurrence in the directory the program will aotomatically load the new file
and re-execute its searching process.

# User do not have to provide the input again, the program will keep remember previously provided input and will
re-execute accordingly.

# for testing there are three csv files named Adidas, Nike and Puma all three files dont have any data of category-->
color - blue
size - m
gender - m

# so I have created a new file named Reebok that has only one product detail aforementioned.

# First of all we have to move Reebok file somewhere else and delete it from the csvdat->csvfiles.

# Now run the program from app.java and provide following input -->
color - blue
size - m
gender - m
output preference - rating

# No product will be found as all three files dont have any product from required fields.

# Now put back that Reebok file in csvdata-->scvfiles folder of the project and observe the output.

# Without again providing input details the program automatically loads new file and accordingly updates its
output on the basis of previously provided input data.
