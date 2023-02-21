# My First Monolith

* **Objective** - To create a full-stack monolithic application
* **Purpose** - To gain familiarity with connecting a web service to a front end application
* **Description**
   * Run this application by running the main method in `DemoApplication`.
   * Navigate to the server port specified in the [application.properties file](./src/main/resources/application.properties). By default, the port number is `8080`
   * If your application cannot run because something is occupying a port, execute this command from `Git Bash` with the respective port number specified:
       * ``kill -kill `lsof -t -i tcp:8080` ``
   * Navigate to `localhost/8080` from a browser (`Chrome`, or `Firefox`)
   * Take note of the functionality for each button that is available on the webpage.
   * Modify the functionality of the `create` button which fetches data from the [DOM](https://www.w3schools.com/js/js_htmldom.asp), and persists it in our database.

## Part 1 - Clone the project
* Begin by _forking_ this project into a personal repository.
   * To do this, click the `Fork` button located at the top right of this page.
* Navigate to **your github profile** to find the _newly forked repository_.
* Clone the repository from **your account** into your `~/dev` directory.
* Open the newly cloned project in a code editor (IntelliJ, for example).
