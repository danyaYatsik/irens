DROP TABLE IF EXISTS palindromes;
CREATE TABLE palindromes(
    id int AUTO_INCREMENT PRIMARY KEY,
    origin VARCHAR(250) NOT NULL,
    max VARCHAR(250),
    min VARCHAR(250)
);