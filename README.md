## How to depoly?

- Open backend folder and run the application.
- Open frontend folder (make sure to run applications in the right order).
- Enter following command into terminal:  


    npm install


- Wait for it to finish and enter the next command:  


    npm run serve

- Open frontend localhost server and enjoy the application.


## General information

- Accuweather's free account only allows up to 50 http requests to one API key. That means that getting current weather data and Accuweather forecast can only be done up to 50 times per day. If it stops working and responds error 500 then it is probably because of the daily limit.