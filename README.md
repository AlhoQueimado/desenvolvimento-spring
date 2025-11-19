CHEESE.COM

Instruções para uso:
Clonar repositório;
Com sua IDE de preferência, importar projeto, alterar application.properties com os valores corretos do banco de dados Postgresql;
Após isso, ao rodar a aplicação, o banco de dados será criado dinamicamente;

Endpoints:
/auth:
  /register POST
  body:
    "name": string;
    "email": string;
    "password": string;
  response:
    "name": string;
    "email": string;

  /login POST
  body:
    "name": string;
    "password": string;
  response:
    "token": BearerToken;

/game
  / POST
  body:
    "name": string;
    "teamNumber": int;
    "teamSize": int;
  response:
    "id": int,
    "name": string,
    "teamNumber": int,
    "teamSize": int,
  
  /update/{id} POST
  body:
    "name": string;
    "teamNumber": int;
    "teamSize": int;
  response:
    "id": int,
    "name": string,
    "teamNumber": int,
    "teamSize": int,

  /delete/{id} POST
  body:
    HTTP CODE
  response:
    HTTP CODE

  /get GET
  response:
    [
      {
          "id": int,
          "name": string,
          "teamNumber": int,
          "teamSize": int,
      }
    ]

  /get/{id} GET
  response:
    "id": int,
    "name": string,
    "teamNumber": int,
    "teamSize": int,

/match
  / POST
  body:
    "date": date;
    "game": int;
    "teams": array: [{"id": int}];
    "winner": int;
  response:
    "date": date;
    "id": int,
    "game": int;
    "teams": array: [{"id": int}];
    "winner": int;
  
  /update/{id} POST
  body:
    "date": date;
    "game": int;
    "teams": array: [{"id": int}];
    "winner": int;
  response:
    "date": date;
    "id": int,
    "game": int;
    "teams": array: [{"id": int}];
    "winner": int;

  /delete/{id} POST
  body:
    HTTP CODE
  response:
    HTTP CODE

  /get GET
  response:
    [
      {
          "date": date;
          "id": int,
          "game": int;
          "teams": array: [{"id": int}];
          "winner": int;
      }
    ]

  /get/{id} GET
  response:
    "date": date;
    "id": int,
    "game": int;
    "teams": array: [{"id": int}];
    "winner": int;

/team
  / POST
  body:
    "name": string;
    "users": array: [{"id": int}];
  response:
    "id": string;
    "name": string;
    "users": array: [{"id": int}];
  
  /update/{id} POST
  body:
    "name": string;
    "users": array: [{"id": int}];
  response:
    "id": string;
    "name": string;
    "users": array: [{"id": int}];

  /delete/{id} POST
  body:
    HTTP CODE
  response:
    HTTP CODE

  /get GET
  response:
    [
      {
        "id": string;
        "name": string;
        "users": array: [{"id": int}];
      }
    ]

  /get/{id} GET
  response:
    "id": string;
    "name": string;
    "users": array: [{"id": int}];

/achievement
  / POST
  body:
    "name": string;
    "description": string;
    "game": int;
  response:
    "id": int;
    "name": string;
    "description": string;
    "game": int;
  
  /update/{id} POST
  body:
    "name": string;
    "description": string;
    "game": int;
  response:
    "id": int;
    "name": string;
    "description": string;
    "game": int;

  /delete/{id} POST
  body:
    HTTP CODE
  response:
    HTTP CODE

  /get GET
  response:
    [
      {
        "id": int;
        "name": string;
        "description": string;
        "game": int;
      }
    ]

  /get/{id} GET
  response:
    "id": int;
    "name": string;
    "description": string;
    "game": int;

  /get/user/{id} GET
  response:
    "id": int;
    "name": string;
    "description": string;
    "game": int;

  /grant/{id}/{achievement_id} POST
  response:
    HTTP CODE
