# Self Service Appointment Booking (SSAB)

## Customer Jouneys
Here are some customer journeys for an online self-service multiple purpose appointment booking system:
New User Registration:

### The customer visits the website/app and clicks on the "Register" button.
  1. They are directed to a registration page where they enter their personal details, such as name, email, and contact information.
  2. After submitting the registration form, they receive a verification email or SMS with a link/code to activate their account.
  3. They click on the verification link/code and their account is activated.
### Logging In:
  1. The customer visits the website/app and clicks on the "Log In" button.
  2. They are directed to a login page where they enter their registered email/username and password.
  3. After entering the correct credentials, they are logged into their account dashboard.
### Browsing Services:
  * Once logged in, the customer can explore the available services or categories of services offered.
  * They can view detailed descriptions, prices, and availability of each service.
  * They can filter and sort services based on their preferences, such as location, date, time, or specific service provider.
### Selecting a Service:
  * The customer selects a service they are interested in booking.
  * They can view available time slots for the service.
  * They can select a preferred date and time that suits them.
### Booking an Appointment:
  * The customer selects a specific date and time slot for the service.
  * They can add any additional notes or requirements related to their appointment.
  * They review the booking details, including the date, time, and cost, and confirm the appointment.
### Managing Appointments:
  * The customer can view their upcoming appointments in their account dashboard.
  * They have options to reschedule or cancel appointments, if allowed by the system.
  * They can receive reminders or notifications about their upcoming appointments via email, SMS, or push notifications.
### Providing Feedback and Ratings:
  * After the appointment, the customer can provide feedback and ratings for the service they received.
  * They can leave comments or suggestions to help improve the overall experience.
### Support and Assistance:
  * The customer can access a support or help section where they can find answers to frequently asked questions.
  * They can also contact customer support through various channels, such as live chat, email, or phone, for any issues or queries they may have.

Remember, these customer journeys can be customized based on your specific requirements and the nature of your appointment booking system.

## Rest Endpoints
Here are some REST endpoints and the functionality they can cover based on the user journeys mentioned earlier:

### User Registration:
  * Endpoint: POST /api/users/register
  * Functionality: Creates a new user account with the provided registration details.

### User Login:
  * Endpoint: POST /api/users/login
  * Functionality: Authenticates the user based on the provided login credentials and returns an access token for subsequent API requests.

### Browse Services:
  * Endpoint: GET /api/services
  * Functionality: Retrieves a list of available services and their details.

### Selecting a Service:
  * Endpoint: GET /api/services/{serviceId}
  * Functionality: Retrieves the details of a specific service based on its ID.

### Check Availability:
  * Endpoint: GET /api/services/{serviceId}/availability?date={selectedDate}
  * Functionality: Retrieves the available time slots for a specific service on the selected date.

### Booking an Appointment:
  * Endpoint: POST /api/appointments
  * Functionality: Creates a new appointment for the user with the selected service, date, and time slot.

### View Upcoming Appointments:
  * Endpoint: GET /api/appointments
  * Functionality: Retrieves a list of upcoming appointments for the authenticated user.

### Reschedule or Cancel Appointment:
  * Endpoint: PUT /api/appointments/{appointmentId}
  * Functionality: Allows the user to reschedule or cancel a specific appointment based on its ID.

### Provide Feedback and Ratings:
  * Endpoint: POST /api/appointments/{appointmentId}/feedback
  * Functionality: Allows the user to provide feedback and ratings for a specific appointment.

### Support and Assistance:
  * Endpoint: GET /api/support/faq
  * Functionality: Retrieves a list of frequently asked questions and their answers.

11. Contact Customer Support:
  * Endpoint: POST /api/support/contact
  * Functionality: Sends a support request or inquiry to the customer support team.

These are just example endpoints, and you can modify them based on your specific requirements and naming conventions. Additionally, you may need to include authentication and authorization mechanisms to secure the API endpoints.

## Frontend App (SSAB-APP) Overview
Here's an outline of the frontend app components, services, guards, and other key elements you might consider using in your Angular application for the appointment booking system:

### Components:

1. RegistrationComponent: Renders the registration form for new users.
2. LoginComponent: Displays the login form for existing users.
3. ServicesComponent: Shows a list of available services and allows users to browse and select a service.
4. ServiceDetailsComponent: Displays detailed information about a specific service.
5. AvailabilityComponent: Shows available time slots for a selected service and date.
6. AppointmentComponent: Handles the booking of appointments and displays booking details.
7. AppointmentsComponent: Lists the upcoming appointments for the logged-in user.
8. FeedbackComponent: Provides a form for users to provide feedback and ratings for an appointment.
9. SupportComponent: Displays FAQs and contact information for customer support.
### Services:
1. AuthService: Handles user authentication and authorization.
2. UserService: Communicates with the backend API for user-related operations (e.g., registration, login).
3. ServiceService: Communicates with the backend API for service-related operations (e.g., fetching services, service details).
4. AppointmentService: Handles communication with the backend API for appointment-related operations (e.g., booking, rescheduling, cancellation).
5. SupportService: Handles communication with the backend API for support-related operations (e.g., retrieving FAQs, contacting support).
### Guards:
1. AuthGuard: Protects routes that require authentication. Redirects unauthenticated users to the login page.
2. RoleGuard: Restricts access to certain routes based on user roles. For example, allowing only admin users to access the admin dashboard.

### Other Elements:
1. Routing Module: Defines the routing configuration for navigating between components and guards.
2. Interceptors: Handles authentication token injection into API requests and intercepts API responses for error handling.
3. Error Handling: Implements error handling mechanisms to display user-friendly error messages and handle API errors gracefully.
4. Form Validation: Implements form validation to ensure data integrity and provide user feedback on invalid inputs.

These are just the foundational components, services, guards, and other elements that you may need in your Angular application. You can further customize and expand upon these as per your specific requirements and application design.


## Authentication and Authorization Design

Here's an explanation of how you can handle user authentication and authorization in your Angular application:

### Authentication:

1. Registration: When a user registers, their information (e.g., name, email, password) is sent to the backend API (UserService) via a registration form (RegistrationComponent). The API validates and stores the user's information in a database.
2. Login: The user enters their credentials (email and password) in the login form (LoginComponent). These credentials are sent to the backend API (AuthService), which verifies them against the stored user information. If the credentials are valid, the API generates an access token (JWT or similar) and sends it back to the frontend.
3. Token Storage: The access token is securely stored in the frontend (e.g., local storage or cookies) to maintain the user's authenticated state across different pages or app reloads.
4. Authentication Guard: An AuthGuard is implemented as a route guard in Angular. It checks if the user has a valid access token. If the token is present, the user is allowed to access protected routes. If the token is missing or invalid, the user is redirected to the login page.
### Authorization:

1. User Roles: Each user in the system may have one or more roles assigned to them (e.g., admin, regular user). These roles determine the user's level of access and permissions within the application.
2. Role-Based Guard: A RoleGuard can be implemented to restrict access to specific routes based on the user's role. For example, an admin user might have access to an admin dashboard, while a regular user may not.
3. Backend Validation: While the frontend RoleGuard restricts UI-level access, it's crucial to validate user roles on the backend as well. The backend API should enforce authorization rules to prevent unauthorized access to sensitive resources or actions.
4. API Permissions: Each API endpoint should have appropriate permission checks to ensure that only authorized users (with the required roles) can access or modify specific resources. For example, an endpoint to delete a service may only be accessible to admin users.


By implementing authentication and authorization mechanisms, you can ensure that only authenticated users can access protected parts of your application and that they have the necessary roles and permissions to perform specific actions. This helps maintain security and control over sensitive data and functionality.

## Token management in frontend app
The storage and usage of roles for every user interaction typically involve the following steps:

1. Role Definition: Define the roles that will be used in your application (e.g., admin, user, manager). Each role should have specific permissions and access levels associated with it.
2. User Role Assignment: Store the user's role information in your backend database. When a user registers or is created, assign the appropriate role(s) to them based on your application's business logic. This information should be associated with the user's account.
3. Token-Based Authentication: During the authentication process, generate an access token (JWT or similar) on the backend and include the user's role(s) as a part of the token's payload. The token is then sent back to the frontend and stored securely (e.g., local storage or cookies) for subsequent requests.
4. Access Token Verification: On each subsequent request, the frontend includes the access token in the request headers. The backend verifies the token's authenticity and integrity, and extracts the user's role(s) from the token's payload.
5. Middleware/Interceptor: Implement a middleware or interceptor on the backend to extract and validate the role(s) from the access token. This middleware can ensure that the user making the request has the necessary role(s) to perform the requested action.
6. Authorization Checks: In your backend API routes and endpoints, implement authorization checks based on the user's role(s). For each action or resource, check if the user's role(s) match the required role(s) for that specific action or resource. If the roles don't match, return an error or deny access.
7. Frontend UI Controls: On the frontend, you can use the user's role(s) to conditionally render or disable certain UI components and features based on their permissions. For example, an admin user might see additional options or have access to admin-specific functionalities that regular users don't.

By storing the user's role(s) in the access token and implementing role-based authorization checks in your backend API, you can control access to various parts of your application and ensure that users have the appropriate permissions for each interaction.
