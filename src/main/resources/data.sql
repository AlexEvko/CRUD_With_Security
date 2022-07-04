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