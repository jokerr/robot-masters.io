create table robots (
  id VARCHAR (10) IDENTITY PRIMARY KEY,
  name VARCHAR (25) NOT NULL,
  weapon VARCHAR (50),
  endurance NUMBER DEFAULT 0,
  intelligence NUMBER DEFAULT 0,
  speed NUMBER DEFAULT 0,
  battle NUMBER DEFAULT 0
);