@FeatureSesion @Smoke
Feature: Gestion de Sesion


  @LoginExitoso
  Scenario: 1. Login exitoso
    Given El usuario esta en la pagina LogIn
    When Ingresa un email valido
    And Ingresa un password valido en la aplicacion
    And Click en button login
    Then La Seccion Entry Time es visualizada
    And AFTER TEST: logout


  @LogOut
  Scenario: 6. Log-out
    Given El usuario logueado esta en la seccion time entry
    And Elige el menu opciones
    When Click en la opcion Log-Out
    Then Confirma la accion
    And La App muestra la pagina de Login
