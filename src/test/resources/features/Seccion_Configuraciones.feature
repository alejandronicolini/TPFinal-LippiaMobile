@FeatureConfiguracion @Smoke
Feature: Configuracion General de la App

Background:
  Given El usuario logueado esta en la seccion time entry
  And Elige el menu opciones
  When Clic en la opcion Settings


  @DarkMode
  Scenario: 5a. cambiar configuracion (Modo oscuro)
    And Clic en el boton DarkMode
    Then La App cambia su color
    And AFTER TEST: restaurar color - logout


  @ShowNotifications
  Scenario: 5b. cambiar configuracion (Notificaciones)
    And Clic en el boton Show Notifications
    Then La App muestra u oculta las notificaciones
    And AFTER TEST: restaurar notificaciones - logout