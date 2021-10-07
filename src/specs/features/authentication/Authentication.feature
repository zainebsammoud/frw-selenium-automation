Feature: Authentification - Orange HRM
  ETQ utilisateur je souhaite m'authentifier

  @connexion
  Scenario: Connexion sur l'application Orange
    Given je me connecte sur l'application Orange HRM
    When je saisie username "Admin"
    And je saisie le mot de passe "admin123"
    And je clique sur le bouton login
    Then je me redirige vers la page home "Welcome"
