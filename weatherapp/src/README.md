# WeatherApp

## Overview
WeatherApp is a full-stack web application developed with Spring Boot that provides users with 
real-time weather data for various locations. Users can manage their preferences and access 
weather information through a user-friendly interface. The application supports role-based 
authentication, allowing different functionalities based on user roles.

## Features
- **User Authentication**: 
  - Secure login for users with role-based access (Admin and User roles).
  - Admin users can manage all data, while regular users can only access their own preferences.

- **Weather Data Management**: 
  - **View Weather Data**: Fetch current weather data for a specified city.
  - **Create Weather Data**: Users can add new weather information through a simple form.
  - **Update Weather Data**: Modify existing weather records based on city input.
  - **Delete Weather Data**: Remove weather entries as needed.

- **User Preferences**: 
  - Users can specify their preferred temperature unit (Celsius or Fahrenheit).
  - Preferences are saved and reflected in the weather data displayed.

- **Responsive Design**: 
  - A clean, responsive UI that adapts to different screen sizes.
  - Navigation bar for easy access to various sections of the application.

## Technologies Used
- **Backend**:
  - **Spring Boot**: A Java-based framework for building RESTful applications.
  - **JPA/Hibernate**: For ORM (Object-Relational Mapping) and database interactions.
  - **Spring Security**: For implementing authentication and authorization.

- **Frontend**:
  - **HTML**: Markup for structuring web pages.
  - **CSS**: Custom styles for consistent UI design (see `styles.css`).
  - **JavaScript**: Client-side logic for interactivity (see `scripts.js`).

- **Database**: 
  - MySQL or H2 database (configured in `application.properties`) for storing user data and weather records.

## Installation
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/yourusername/weatherapp.git
   cd weatherapp
   ```

2. **Set Up the Database**:
   - Ensure you have MySQL or H2 installed and running.
   - Configure your `application.properties` file with your database connection details.

3. **Run the Application**:
   - Use Maven to build and run the Spring Boot application:
   ```bash
   mvn spring-boot:run
   ```

4. **Access the Application**:
   - Open your web browser and navigate to `http://localhost:8080` to access the application.

## API Endpoints
| Method | Endpoint            | Description                                     |
|--------|---------------------|-------------------------------------------------|
| GET    | `/weather/{city}`   | Fetch current weather data for a specified city.|
| POST   | `/weather`          | Create a new weather data entry.                |
| PUT    | `/weather/{city}`   | Update existing weather data for a specified city. |
| DELETE | `/weather/{city}`   | Remove weather data for a specified city.       |

### Example API Usage
- **Get Weather Data**:
   ```bash
   curl -X GET http://localhost:8080/weather/London
   ```

- **Create Weather Data**:
   ```bash
   curl -X POST http://localhost:8080/weather -H "Content-Type: application/json" -d '{"locationName": "London", "temperature": "15°C", "description": "Cloudy"}'
   ```

## Frontend Structure
- **styles.css**: Contains styles for body, header, buttons, and overall layout to enhance the user experience.
- **scripts.js**: Handles user interactions, such as button clicks, and fetches weather data through alerts.
- **header.html**: Navigation bar structure that provides links to the Home, Preferences, and Login pages.


## Error Handling
- **ResourceNotFoundException**: Custom exception to handle scenarios when requested data (like weather data or location)
is not found. This exception is thrown with a relevant message, enhancing user experience and 
debugging.

## Testing
- Unit tests are critical for ensuring the application's reliability. Consider writing tests for:
  - Controllers: Ensure endpoints return the correct responses.
  - Services: Validate business logic and data handling.
  - Repositories: Verify database interactions.



## Author
Manfung Cheung


