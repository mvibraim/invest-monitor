-- :name create-user! :! :n
-- :doc creates a new user record
INSERT INTO users
(cpf, pass)
VALUES (:cpf, :pass)

-- :name update-user! :! :n
-- :doc updates an existing user record
UPDATE users
SET pass = :pass
WHERE cpf = :cpf

-- :name get-user :? :1
-- :doc retrieves a user record given the cpf
SELECT * FROM users
WHERE cpf = :cpf

-- :name delete-user! :! :n
-- :doc deletes a user record given the cpf
DELETE FROM users
WHERE cpf = :cpf
