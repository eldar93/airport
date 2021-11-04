--

INSERT INTO country( id, name, continent, wikipedia_link, keywords )
SELECT "CODE", "NAME", "CONTINENT", "WIKIPEDIA_LINK", "KEYWORDS"
  FROM CSVREAD('classpath:input/countries.csv', NULL /* columnNameHeader */, NULL /* StringDecode */);

--

INSERT INTO airport( id, airport_ident, type, name, iso_country )
SELECT "ID", "IDENT", "TYPE", "NAME", "ISO_COUNTRY"
  FROM CSVREAD('classpath:input/airports.csv', NULL /* columnNameHeader */, NULL /* StringDecode */);

--

INSERT INTO runway( id, airport_ref, length_ft, width_ft, surface, lighted, closed )
SELECT "ID", "AIRPORT_REF", "LENGTH_FT", "WIDTH_FT", "SURFACE", "LIGHTED", "CLOSED"
  FROM CSVREAD('classpath:input/runways.csv', NULL /* columnNameHeader */, NULL /* StringDecode */);