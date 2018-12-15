CREATE TABLE book (
  id            int(20) NOT NULL,
  book_store_id BIGINT,
  name          VARCHAR(80),
  author        VARCHAR(80),
  price         DECIMAL(10,2),
  topic         VARCHAR(80),
  publish_date  DATE,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE book_store (
  id           int(20) NOT NULL,
  name         VARCHAR(80),
  address      VARCHAR(80),
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE user (
  id            int(20) NOT NULL,
  username      VARCHAR(80),
  password      VARCHAR(80),
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;