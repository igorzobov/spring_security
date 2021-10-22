-- Table: users
DROP TABLE users;
CREATE TABLE users
(
    id   INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(30)  NOT NULL,
    password VARCHAR(255) NOT NULL,
    age      INT          NOT NULL,
    email    VARCHAR(255) NOT NULL
)
    ENGINE = InnoDB;

-- Table: roles
DROP TABLE roles;
CREATE TABLE roles
(
    id   INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
)
    ENGINE = InnoDB;

-- Table for mapping user and roles: user_roles
DROP TABLE user_roles;
CREATE TABLE user_roles
(
    user_id INT NOT NULL,
    role_id INT NOT NULL,

    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (role_id) REFERENCES roles (id),

    UNIQUE (user_id, role_id)
)
    ENGINE = InnoDB;

-- Insert data

INSERT INTO users
VALUES (1, 'user', 'user', 22, 'user@mail.ru');
INSERT INTO users
VALUES (2, 'admin', 'admin', 33, 'admin@mail.ru');

INSERT INTO roles
VALUES (1, 'ROLE_USER');
INSERT INTO roles
VALUES (2, 'ROLE_ADMIN');

INSERT INTO user_roles
VALUES (1, 1);
INSERT INTO user_roles
VALUES (2, 2);