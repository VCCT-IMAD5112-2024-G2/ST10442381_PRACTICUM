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
 !![Screenshot 2024-06-10 120918](https://github.com/st10442381-SchekinahBonane/ST10442381_PRACTICUM/assets/164514716/c315d5f0-c0d4-49ab-ad80-f5e0cda08e25)
[![Screenshot 2024-06-10 121917](https://github.com/st10442381-SchekinahBonane/ST10442381_PRACTICUM/assets/164514716/36ff97ab-8388-4884-989b-82b6bab9e0a0)
Screenshot 2024![Uploading Screenshot 2024-06-10 122108.png…]()
-06![Screenshot 2024-06-10 122454](https://github.com/st10442381-SchekinahBonane/ST10442381_PRACTICUM/assets/164514716/afcc06db-5bfe-42be-933b-7ce5938616a2)
-10 120145](ht![Screenshot 2024-06-10 120022](https://github.com/st10442381-SchekinahBonane/ST10442381_PRACTICUM/assets/164514716/83b56ad5-6904-445a-9546-597097ea65e1)
tps://github.com/st10442381-SchekinahBonane/ST10442381_PRACTICUM/assets/164514716/c1b2828c-209c-49d9-be0e-dcda168c338b)
![Screenshot 2024-06-10 114911](https://github.com/st10442381-SchekinahBonane/ST10442381_PRACTICUM/assets/164514716/59153e3f-4b69-4f79-8af4-d7763adf8a2c)


 
