## How to depoly?

- Open back-end folder and run the application using IntelliJ IDE run button.
- It should be also possible to run back-end from terminal when entering:


    gradlew bootRun


- Open front-end folder (make sure to run applications in the right order).
- Enter following command into front-end terminal:  


    npm install


- Wait for it to finish and enter the next command:  


    npm run serve

- Open frontend localhost server and enjoy the application.


## General information

- If you wish do use Swagger to trigger back-end endpoints run the backend application and go to: 

    http://localhost:8080/swagger-ui/index.html#/


- Accuweather's free account only allows up to 50 http requests to one API key. That means that getting current weather data and Accuweather forecast can only be done up to 50 times per day. If it stops working and responds error 500 then it is probably because of the daily limit.


## Q&A

### How you solved the tasks, and how much time did different parts take?

At first I teached myself how simple APIs work and how to make HTTP requests to certain URLs. The next new thing I 
learned was automatically making Java classes from JSON object and mapping the data from JSON object to the classes. For 
automatic classes I used jsonschema2pojo technology.  After I learned how to that I started implementing my knowledge 
learned from Vali-IT bootcamp. I composed needed controller and service methods and made them as clean as I could. I 
think in total the back-end took about 16 hours of active work.

After making sure my back-end is working I started working on building front-end. As we were busy at Vali-IT with 
learning Vue.js I decided to not start learning Angular from zero. I implemented my knowledge for Vue.js and made three
weather forms for parameters and tables for data. After that I got obsessed about developing the map to enter the 
coordinates. It took few days after full days at bootcamp to find a do-able solution and start learning the Leaflet library.
After successfully implementing the map I started looking for different options for scheduling the current weather task.
I spend a good few hours on trying to figure out how to use @Schedule and then thought about solving the problem in front-end.
I managed to schedule the task in JavaScript pretty fast and then I felt the need to also add a timer to know when the next
weather request happens.

### How you decided what to implement and what to skip?

I approached the test step-by-step. I decided to complete the weather comparison first. I competed the methods for getting weather data from two sources and
also the current weather. After completing that I made a quick learning session about other tasks and figured out a map for coordinates
gives more functionality and visual effect for the project so I decided to start working on that. After completing the
map I still had time to also finish the task scheduling and I started to work on that. 

I believe I did not necessary skip any of the tasks but rather used another front-end technology instead of Angular. I also
feel the project would need validations for API requests and unit tests for the whole back-end.

### What were the biggest challenges and how did you overcome them?

One of the biggest challenges was to teach myself to use APIs, how to make HTTP requests and convert the data to Java classes.
One of the most annoying moments were when the map coordinates function in front-end did not work. I spent many hours trying every possible
solution I could imagine. After looking for the answer online I started figuring out the problem and in the end I missed the following line:

const self = this;

### What did you learn from implementing the project?

As mentioned before I taught myself how to send HTTP requests and map the data to Java classes. It was in many ways
eye-opening and really exciting. I also learned a lot about using Vue.js. I learned how to create dynamic tables and
how to manipulate HTML using Vue attributes.

