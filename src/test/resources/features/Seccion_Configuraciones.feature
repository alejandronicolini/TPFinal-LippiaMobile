@Smoke
Feature: Configuracion General de la App

  @DarkMode
  Scenario: 5. cambiar configuracion (Modo oscuro)
    Given El usuario esta en la Home Page
    And Elige el menu opciones
    When Click en la opcion Settings
    And Clic en el boton DarkMode
    Then La App cambia su color



