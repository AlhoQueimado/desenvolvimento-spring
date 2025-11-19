# CHEESE.COM

## Instruções para uso:
Clonar repositório;
Com sua IDE de preferência, importar projeto, alterar application.properties com os valores corretos do banco de dados Postgresql;
Após isso, ao rodar a aplicação, o banco de dados será criado dinamicamente;

## Endpoints
### /auth
#### /register - POST

Body:

{
  "name": "string",
  "email": "string",
  "password": "string"
}


Response:

{
  "name": "string",
  "email": "string"
}

#### /login - POST

Body:

{
  "name": "string",
  "password": "string"
}


Response:

{
  "token": "BearerToken"
}

### /game
#### / - POST

Body:

{
  "name": "string",
  "teamNumber": "int",
  "teamSize": "int"
}


Response:

{
  "id": "int",
  "name": "string",
  "teamNumber": "int",
  "teamSize": "int"
}

#### /update/{id} - POST

Body:

{
  "name": "string",
  "teamNumber": "int",
  "teamSize": "int"
}


Response:

{
  "id": "int",
  "name": "string",
  "teamNumber": "int",
  "teamSize": "int"
}

#### /delete/{id} - POST

Body:

HTTP Code

Response:

HTTP Code

#### /get - GET

Response:

[
  {
    "id": "int",
    "name": "string",
    "teamNumber": "int",
    "teamSize": "int"
  }
]

#### /get/{id} - GET

Response:

{
  "id": "int",
  "name": "string",
  "teamNumber": "int",
  "teamSize": "int"
}

###/match
#### / - POST

Body:

{
  "date": "date",
  "game": "int",
  "teams": [{"id": "int"}],
  "winner": "int"
}


Response:

{
  "date": "date",
  "id": "int",
  "game": "int",
  "teams": [{"id": "int"}],
  "winner": "int"
}

#### /update/{id} - POST

Body:

{
  "date": "date",
  "game": "int",
  "teams": [{"id": "int"}],
  "winner": "int"
}


Response:

{
  "date": "date",
  "id": "int",
  "game": "int",
  "teams": [{"id": "int"}],
  "winner": "int"
}

#### /delete/{id} - POST

Body:

HTTP Code

Response:

HTTP Code

#### /get - GET

Response:

[
  {
    "date": "date",
    "id": "int",
    "game": "int",
    "teams": [{"id": "int"}],
    "winner": "int"
  }
]

#### /get/{id} - GET

Response:

{
  "date": "date",
  "id": "int",
  "game": "int",
  "teams": [{"id": "int"}],
  "winner": "int"
}

### /team
#### / - POST

Body:

{
  "name": "string",
  "users": [{"id": "int"}]
}


Response:

{
  "id": "string",
  "name": "string",
  "users": [{"id": "int"}]
}

#### /update/{id} - POST

Body:

{
  "name": "string",
  "users": [{"id": "int"}]
}


Response:

{
  "id": "string",
  "name": "string",
  "users": [{"id": "int"}]
}

#### /delete/{id} - POST

Body:

HTTP Code

Response:

HTTP Code

#### /get - GET

Response:

[
  {
    "id": "string",
    "name": "string",
    "users": [{"id": "int"}]
  }
]

#### /get/{id} - GET

Response:

{
  "id": "string",
  "name": "string",
  "users": [{"id": "int"}]
}

###/achievement
#### / - POST

Body:

{
  "name": "string",
  "description": "string",
  "game": "int"
}


Response:

{
  "id": "int",
  "name": "string",
  "description": "string",
  "game": "int"
}

#### /update/{id} - POST

Body:

{
  "name": "string",
  "description": "string",
  "game": "int"
}


Response:

{
  "id": "int",
  "name": "string",
  "description": "string",
  "game": "int"
}

#### /delete/{id} - POST

Body:

HTTP Code

Response:

HTTP Code

#### /get - GET

Response:

[
  {
    "id": "int",
    "name": "string",
    "description": "string",
    "game": "int"
  }
]

#### /get/{id} - GET

Response:

{
  "id": "int",
  "name": "string",
  "description": "string",
  "game": "int"
}

#### /get/user/{id} - GET

Response:

{
  "id": "int",
  "name": "string",
  "description": "string",
  "game": "int"
}

#### /grant/{id}/{achievement_id} - POST

Response:

HTTP Code
