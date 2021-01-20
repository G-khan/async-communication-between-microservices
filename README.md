

## Simple Asynchronous Microservice Communication Example with Event-Driven Architecture

Demo project for Microservice Event-Driven Architecture 
- Kotlin & Java
- Spring Boot Web
- Spring Cloud Stream Kafka 

***

![Image for post](https://miro.medium.com/max/1388/1*eVj4XfzdQs_N457wiDM3yQ.png)

## Requirements
1.  Java - 1.11.x
2.  Gradle- 3.x.x
3. Docker for kafka instance

<table>
    <tr>
        <th>Service Name</th>
        <th>Port</th>
    </tr>
    <tr>
        <td>Order Service</td>
        <td>8083</td>
    </tr>
    <tr>
        <td>Courier Service</td>
        <td>8084</td>
    </tr>
    <tr>
        <td>Email Service</td>
        <td>8085</td>
    </tr>
    </table>
    

**Step 1: Running the Kafka & Zookeeper**
Open the project directory,
Type the following command in your terminal to run kafka&zookeeper as a docker instances

     docker-compose up -d
    

**Step 2: Running the Order Service** 
Open the this project path then order-service directory. Run the project with gradle:

     ./gradlew bootRun

**Step 3: Running the Courier Service** 
Open the this project path then courier-service directory. Run the project with gradle:

     ./gradlew bootRun
     

**Step 4: Running the Courier Service** 
Open the this project path then email-service directory. Run the project with gradle:

     ./gradlew bootRun
     


## Rest APIs

The app defines following for APIs.

    POST http://localhost:8083/orders
    
    {
        "name": "Black Friday",
        "productIds": [
            14,
            23,
            34
        ],
        "email": "gokhana@mail.com",
        "userName": "G-khan",
        "orderDetail": "%90 discount"
    }

### Example
These examples present the order created event flow.

 - Order Creates with API
 - Order Service Creates Event as a OrderEvent with Created eventType
 - Order Service produces orderEvent via kafka on orderEvent topic.
 - Courier Service consumes the orderEvent and then assign the courier of order
 - At the same time Email Service consumes the OrderEvent and then sends a fake email to user  
