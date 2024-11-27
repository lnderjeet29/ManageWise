<img src="https://github.com/user-attachments/assets/48406db6-99c8-44d5-ab80-c5afd4ad8af8" alt="GrowthX Logo" width="400" height="200"/>
<h1>ManageWise - REST API Controllers</h1>
  <p>
    Welcome to <strong>ManageWise</strong>, a backend service built using <strong>Spring Boot</strong> with Kotlin,
    designed to efficiently manage business, client, and user data. This repository contains the REST controllers
    for managing core application features.
  </p>

  <hr />

  <h2>🚀 Features</h2>
  <ul>
    <li>Business management with secure user authentication.</li>
    <li>Client creation with structured input validation.</li>
    <li>Health check endpoint for service monitoring.</li>
    <li>User management including creation, retrieval, and updates.</li>
    <li>Standardized error handling with meaningful response messages.</li>
    <li>OpenAPI/Swagger integration for API documentation.</li>
  </ul>

  <hr />

  <h2>📂 Controller Overview</h2>

  <h3>1. <strong>BusinessController</strong></h3>
  <p>Manages business-related operations.</p>
  <h4>Endpoints:</h4>
  <ul>
    <li>
      <strong>POST /v1/business</strong><br />
      Creates a new business.
      <ul>
        <li>Requires <code>userHash</code> in the request attributes for authentication.</li>
        <li>Request Body: <code>CreateBusinessDTO</code></li>
        <li>Responses:
          <ul>
            <li><code>200 OK</code>: Business Created Successfully.</li>
            <li><code>401 Unauthorized</code>: Invalid User.</li>
          </ul>
        </li>
      </ul>
    </li>
  </ul>

  <h3>2. <strong>ClientController</strong></h3>
  <p>Handles client creation and management.</p>
  <h4>Endpoints:</h4>
  <ul>
    <li>
      <strong>POST /v1/client</strong><br />
      Creates a new client.
      <ul>
        <li>Request Body: <code>CreateClientRequestDto</code></li>
        <li>Responses:
          <ul>
            <li><code>200 OK</code>: Client created successfully.</li>
            <li><code>500 Internal Server Error</code>: An error occurred while creating the client.</li>
          </ul>
        </li>
      </ul>
    </li>
  </ul>

  <h3>3. <strong>HealthStatusController</strong></h3>
  <p>Provides service health status.</p>
  <h4>Endpoints:</h4>
  <ul>
    <li>
      <strong>GET /</strong><br />
      Returns service status.
      <ul>
        <li>Response Body: <code>{"status": "up"}</code></li>
      </ul>
    </li>
  </ul>

  <h3>4. <strong>UserController</strong></h3>
  <p>Manages user-related operations including creation, retrieval, and updates.</p>
  <h4>Endpoints:</h4>
  <ul>
    <li>
      <strong>POST /v1/user</strong><br />
      Creates a new user.
      <ul>
        <li>Requires <code>userHash</code> in the request attributes for authentication.</li>
        <li>Request Body: <code>CreateUserDto</code></li>
        <li>Responses:
          <ul>
            <li><code>200 OK</code>: User successfully created.</li>
            <li><code>401 Unauthorized</code>: Invalid User.</li>
          </ul>
        </li>
      </ul>
    </li>
    <li>
      <strong>GET /v1/user/{userHash}</strong><br />
      Retrieves user details by their unique hash.
    </li>
    <li>
      <strong>PATCH /v1/user/{userHash}</strong><br />
      Updates user details by their unique hash.
    </li>
  </ul>

  <hr />

  <h2>💬 Contact</h2>
  <p>Feel free to reach out for any questions or contributions:</p>
  <ul>
    <li>Email: <a href="mailto:inderjeetdev33@example.com">inderjeetdev33@example.com</a></li>
    <li>GitHub: <a href="https://github.com/inderjeet29">https://github.com/inderjeet29</a></li>
  </ul>
