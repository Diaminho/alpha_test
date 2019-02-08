CREATE TABLE Type (
  id          INTEGER PRIMARY KEY,
  name        VARCHAR(128) NOT NULL
  ); 

  
CREATE TABLE Brand (
  id          INTEGER PRIMARY KEY,
  name        VARCHAR(128) NOT NULL
  );
  
CREATE TABLE Property (
  id          INTEGER PRIMARY KEY,
  type_id     INTEGER REFERENCES Type(id),
  name        VARCHAR(128) NOT NULL
  );


CREATE Table Product(
  id          INTEGER PRIMARY KEY,
  model       VARCHAR(128) Not Null,
  type_id     INTEGER REFERENCES Type(id),
  brand_id    INTEGER REFERENCES Brand(id),
  quantity    INTEGER NOT NULL,
  price       DOUBLE NOT NULL
  );

  
CREATE Table Product_property(
  id          INTEGER PRIMARY KEY,
  product_id    INTEGER REFERENCES Product(id),
  property_id INTEGER REFERENCES Property(id),
  value       VARCHAR(128) NOT NULL
  ); 
