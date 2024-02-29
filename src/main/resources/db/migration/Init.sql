CREATE TABLE IF NOT EXISTS users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR (255) NOT NULL UNIQUE,
    password VARCHAR (255) NOT NULL,
    email VARCHAR (255) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS roles (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR (255) NOT NULL
);

CREATE TABLE IF NOT EXISTS users_roles (
    user_id BIGINT NOT NULL,
    role_id INT NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (role_id) REFERENCES roles (id)
);

INSERT INTO roles (name)
VALUES
('ROLE_USER'), ('ROLE_ADMIN');

--Пароли шифрованы Bcrypt 12 раундов (user password: '123', admin password: '321')

INSERT INTO users (username, password, email)
VALUES
('randomUser0', '$2a$12$MZnP6ZHA8VF9YB2Hsrt/Oe33sAhqLyPDm6IZteg/SA3nV6Co7ZMEG', 'randomUser0@example.com'),
('randomAdmin0', '$2a$12$d3WARt/f5cVqkS2N0Ztta.prGAz/uLKmWYEDPXzeFJeqlycWIgWo.', 'randomAdmin0@example.com');

INSERT INTO users_roles (user_id, role_id)
VALUES
(1, 1), (2, 2);