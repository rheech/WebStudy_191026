CREATE TABLE EXP_BOARD (
    ENTRY_NUM INT AUTO_INCREMENT PRIMARY KEY,
    TITLE VARCHAR(500),
    CONTENT TEXT,
    AUTHOR VARCHAR(80),
    REG_DATE DATETIME,
    VIEW_CNT INT
);