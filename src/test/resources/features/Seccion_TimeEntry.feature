@FeatureEntradas @Smoke
Feature: Gestion de Entradas

  Background:
    Given El usuario logueado esta en la seccion time entry
    When Agrega una entrada


  @EntradaSimple
  Scenario: 2. Agregar una entrada datos
    And ingresa las horas trabajadas: "05":"30"
    And ingresa un nombre de tarea: "Entrada v."
    And confirma la tarea
    Then redirige a la seccion time entry
    And aparece la entrada creada
    And AFTER TEST: eliminar tarea - logout


  @EntradaConFecha
  Scenario:  3. Agregar una entrada datos con una fecha particular
    And ingresa a Time Range
    And selecciona el dia "10"-"12"-"2022"
    And ingresa un horario de inicio: "10" : "20"
    And de finalizacion: "17" : "50"
    And clic en boton save
    And ingresa un nombre de tarea: "Fecha v."
    And selecciona el primer proyecto
    And confirma la tarea
    Then redirige a la seccion time entry
    And aparece la entrada creada
    And AFTER TEST: eliminar tarea - logout


  @EntradaCancelada
  Scenario: 4. Generar una entrada de datos, y cancelar el guardado
    And ingresa las horas trabajadas: "02":"30"
    And ingresa un nombre de tarea: "Cancelada v."
    And cancela la tarea y vuelve a la seccion time entry
    Then la entrada no queda registrada
    And AFTER TEST: logout