@Smoke
Feature: As a client i want to interact with the mobile application

  @Login
  Scenario: The user login in App
    Given The user is in the sign up page
    When The user input email xxxx
    And input password xxxx in the application
    And clic in button login
    Then Page Entry Time is displayed


  @AddTask
  Scenario:  Add item work in time list
    Given el usuario logueado esta en la seccion time entry
    When agrega una entrada
    And ingresa a Time Range
    And selecciona el dia "28" de "October" de "2022"
    And ingresa un horario de inicio: "10" : "20"
    And de finalizacion: "17" : "50"
    And clic en boton save
    And ingresa un nombre de tarea: "Tarea Nueva"
    And selecciona el primer proyecto
    And confirma la tarea
    Then redirige a la seccion time entry
    And aparece la entrada creada: "Tarea Nueva"

