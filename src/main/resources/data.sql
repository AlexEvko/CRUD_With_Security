ALTER TABLE users_roles
    drop CONSTRAINT fk_userol_on_user;
ALTER TABLE users_roles
    ADD CONSTRAINT fk_userol_on_user
        FOREIGN KEY (users_id)
            REFERENCES users (id)
            ON DELETE CASCADE;
# все что выше - скрипт для каскадного удаления
# USE my_db;
# DELETE FROM users WHERE id=5
USE my_db;

INSERT INTO users values(5,'Vlad', 'Nedob', 22, 'Nedob'), (6,'Vla', 'N', 22, 'N');
INSERT INTO users_roles values(1, 5), (1, 6);

INSERT INTO role values(1,'ROLE_ADMIN'), (2,'ROLE_USER');
INSERT INTO users values(5,'Vlad', 'Nedob', 22, 'Nedob'), (6,'Vla', 'N', 22, 'N');
INSERT INTO users_roles values(1, 5), (1, 6);