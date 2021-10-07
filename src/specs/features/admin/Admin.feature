Feature: Recherche d'un employé
  ETQ admin je souhaite chercher un employé par username

  Background: 
    Given je me connecte sur l'application Orange HRM
    When je saisie username "Admin"
    And je saisie le mot de passe "admin123"
    And je clique sur le bouton login

  @search
  Scenario: Recherche d'un employé par username
    When je clique sur le menu Admin
    And je clique sur le menu User Management
    And je saisie Username "Alice.Duval"
    And je clique sur le bouton search
    Then je trouve un seul employé "Alice.Duval"
    And je déconnecte du compte
