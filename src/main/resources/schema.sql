CREATE TABLE Type (
  id          INTEGER PRIMARY KEY,
  name        VARCHAR(64) NOT NULL
  ); 

  
CREATE TABLE Brand_Name (
  id          INTEGER PRIMARY KEY,
  name        VARCHAR(64) NOT NULL
  );
  
CREATE TABLE Property (
  id          INTEGER PRIMARY KEY,
  name        VARCHAR(64) NOT NULL
  );
  
CREATE Table ProductOrder(
  id          INTEGER PRIMARY KEY,
  name        VARCHAR(64) Not Null,
  type_id     INTEGER REFERENCES Type(id),
  brand_id    INTEGER REFERENCES Brand_Name(id),
  quantity    INTEGER NOT NULL,
  price       DOUBLE NOT NULL
  );
