DELIMITER $$

CREATE PROCEDURE InsertSeatsSal1()
BEGIN
    DECLARE row_num INT DEFAULT 1;
    DECLARE seat_num INT;
    
    WHILE row_num <= 25 DO
        SET seat_num = 1;
        
        WHILE seat_num <= 16 DO
            INSERT INTO Seat (theateridfk, seat_row, seat_number, blocked)
            VALUES (1, row_num, seat_num, FALSE);
            
            SET seat_num = seat_num + 1;
        END WHILE;
        
        SET row_num = row_num + 1;
    END WHILE;
END $$

DELIMITER ;

CALL InsertSeatsSal1();
