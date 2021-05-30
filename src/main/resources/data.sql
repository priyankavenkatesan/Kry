DROP table if exists kry;

CREATE TABLE kry (
  service_name VARCHAR(250) PRIMARY KEY,
  url VARCHAR(250) NOT NULL,
  active_ind VARCHAR (20),
  created_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO kry (service_name, url, active_ind) VALUES('Kry','https://www.kry.se/', 'Ok');
INSERT INTO kry (service_name, url, active_ind) VALUES('Vaccination','https://www.kry.se/en/vaccination/', 'FAIL');