schekinah Bonane st10442381
the App/Repository is in the Master branch and not the main branch 
 PURPOSE AND EXPLANATION
 LINK: https://github.com/st10442381-SchekinahBonane/ST10442381_PRACTICUM.git

The app allows users to input temperature data along with corresponding dates and weather conditions. It then provides functionality to view entered data and calculate the average temperature based on the recorded minimum and maximum temperatures. 

Input Data: 

Users can enter date, minimum temperature, maximum temperature, and weather conditions. 

Add Temperature Data: 

Pressing the "Add" button saves the entered data. 

If all fields are filled correctly, the data is saved. 

If any field is empty or has invalid data, an error message is shown. 

Clear Data: 

Pressing the "Clear" button clears all entered data. 

View Details: 

Clicking the "View Details" button opens a new screen to view the data entered. 

Calculate Average Temperature: 

Clicking the "Average" button calculates and displays the average minimum and maximum temperatures. 

If there is no data available, it shows a message indicating so. 

PSEUDOCODE 
Initialize dayEditText, minEditText, maxEditText, weatherConditionEditText as EditText 

Initialize days as ArrayList<String> 

Initialize minTemps as ArrayList<Int> 

Initialize maxTemps as ArrayList<Int> 

Initialize weatherConditions as ArrayList<String> 

On onCreate: 

Set content view to activity_main_screen 

Set window insets listener to adjust padding 

Initialize dayEditText, minEditText, maxEditText, weatherConditionEditText 

Initialize buttons: clearButton, viewDetails, exitBtn, addBtn, averageBtn 

On addBtn click: 

Call addTemperature function 

On clearButton click: 

Call clearData function 

On exitBtn click: 

Finish the activity to exit the app 

On viewDetails click: 

Create Intent to navigate to DetailsView activity 

Pass days, minTemps, maxTemps, weatherConditions to DetailsView 

Start DetailsView activity 

On averageBtn click: 

Call calculateAverageTemperature function 

addTemperature function: 

Retrieve input from dayEditText, minEditText, maxEditText, weatherConditionEditText 

If all inputs are valid: 

Add inputs to respective lists 

Clear input fields 

Show success message 

Else: 

Show error message 

clearData function: 

Clear all lists and input fields 

calculateAverageTemperature function: 

If temperature lists are not empty: 

Calculate average min and max temperatures 

What average temperatures 

Else: 

Show message indicating no temperature data available 
![Uploading Screenshot 2024-06-10 120145.png…]() this screenshot is how the splash screen of my app displays
![Uploading Screenshot 2024-06-10 120918.png…]() this is how my second screen looks like. where the user will input all the data 
![Uploading Screenshot 2024-06-10 131724.png…]() this is how my third screen looks like where all the data that was inputted will be displayed
![Uploading Screenshot 2024-06-10 120022.png…]() this is the code for the splash screen 
![Uploading Screenshot 2024-06-10 121917.png…]() the code for my second screen 
![Uploading Screenshot 2024-06-10 122108.png…]() code for my second screen 
![Uploading Screenshot 2024-06-10 122454.png…]() code for my third screen that codes to display all the information 

REFERENCING:
IIE, 2024, Introducction to Mobile Application Development [IMAD5111 Module Manual]. The Independent Institute of Education Unpublished.  












 

 
