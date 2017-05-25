USE QuizApp

SELECT re.*
FROM Account acc, Record re
WHERE acc.username = re.username
ORDER BY re.row * re.col DESC, re.time ASC

IF (OBJECT_ID('getRecord')) IS NOT NULL
	DROP PROCEDURE getRecord
GO
CREATE PROCEDURE getRecord
AS
BEGIN
	SELECT acc.username, acc.fullname, re.row, re.col, re.time
	FROM Account acc, Record re
	WHERE acc.username = re.username
	ORDER BY re.row * re.col DESC, re.time ASC
END

IF (OBJECT_ID('getTopRecord')) IS NOT NULL
	DROP PROCEDURE getTopRecord;
GO

CREATE PROCEDURE getTopRecord @number Integer
AS
BEGIN
	SELECT TOP (@number) acc.username, acc.fullname, re.row, re.col, re.time
	FROM Account acc, Record re
	WHERE acc.username = re.username
	ORDER BY re.row * re.col DESC, re.time ASC
END

EXEC getTopRecord 1
EXEC getRecord


IF (OBJECT_ID('insertRecord')) IS NOT NULL
	DROP PROCEDURE insertRecord;
GO
CREATE PROCEDURE insertRecord @username varchar(50), @row int, @col int, @time int
AS
BEGIN
	BEGIN TRANSACTION
		INSERT INTO Record VALUES(@username, @row, @col, @time);
	COMMIT TRANSACTION
END

EXEC insertRecord 'QuizApp', 4, 5, 10

EXEC insertRecord 'quizapp',10, 9, 60

IF (OBJECT_ID('insertNewAccount')) IS NOT NULL
	DROP PROCEDURE insertNewAccount;
GO
CREATE PROCEDURE insertNewAccount @username varchar(50), @password varchar(50), @fullname varchar(MAX)
AS
BEGIN
	BEGIN TRANSACTION 
		INSERT INTO Account VALUES(@username, @password, @fullname);
	COMMIT TRANSACTION
END

EXEC getRecord