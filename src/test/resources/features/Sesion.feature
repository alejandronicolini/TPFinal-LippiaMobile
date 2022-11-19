@Smoke
Feature: Gestion de Sesion

  @Login
  Scenario: 1. Login exitoso
    Given The user is in the sign up page
    When The user input valid email
    And input valid password in the application
    And clic in button login
    Then Page Entry Time is displayed


  Scenario: 6. Log-out
    Given El usuario esta en la Home Page
    And Elige el menu opciones
    When Click en la opcion Log-Out
    Then Confirma la accion
    And La App muestra la pagina de Login
#ver si falta algun paso en este ultimo step



#  @AddTask
#  Scenario:  Add item work in time list
#    Given el usuario logueado esta en la seccion time entry
#    When agrega una entrada
#    And ingresa a Time Range
#    And selecciona el dia "28" de "October" de "2022"
#    And ingresa un horario de inicio: "10" : "20"
#    And de finalizacion: "17" : "50"
#    And clic en boton save
#    And ingresa un nombre de tarea: "Tarea Nueva"
#    And selecciona el primer proyecto
#    And confirma la tarea
#    Then redirige a la seccion time entry
#    And aparece la entrada creada: "Tarea Nueva"

