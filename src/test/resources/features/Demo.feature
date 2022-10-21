Feature: As a client i want to interact with the mobile application

  @Login
  Scenario: The user login in App
    Given The user is in the sign up page
    When The user input email "nicolinialejandro@gmail.com" and password "ale130985" in the application
    Then Page Entry Time is displayed

  @AddTask
  Scenario:  Add item work in time list
    Given el usuario logueado esta en la seccion time entry
    When agrega una entrada
    And ingresa a Time Range, selecciona un dia
    And ingresa un horario de inicio: "10" : "20" y de finalizacion: "17" : "50"
    And ingresa un nombre de tarea: "Tarea Nueva"
    And selecciona un proyecto y confirma la tarea
    Then redirige a la seccion time entry
    And aparece la entrada creada: "Tarea Nueva"

