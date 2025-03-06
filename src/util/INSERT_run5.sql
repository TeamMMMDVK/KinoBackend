DELIMITER $$

CREATE PROCEDURE InsertBookedSeats()
BEGIN
    DECLARE show_id INT;
    DECLARE seat_id INT;

    -- Første tilfælde: showidfk fra 1 til 18 med 400 sæder hver
    SET show_id = 1;
    WHILE show_id <= 18 DO
        SET seat_id = 1;
        WHILE seat_id <= 400 DO
            INSERT INTO booked_seat (seatidfk, showidfk, status, ticketidfk, reservationidfk) 
            VALUES (seat_id, show_id, 'AVAILABLE', NULL, NULL);
            SET seat_id = seat_id + 1;
        END WHILE;
        SET show_id = show_id + 1;
    END WHILE;

    -- Andet tilfælde: showidfk fra 19 til 32 med 240 sæder hver
    SET show_id = 19;
    WHILE show_id <= 32 DO
        SET seat_id = 1;
        WHILE seat_id <= 240 DO
            INSERT INTO booked_seat (seatidfk, showidfk, status, ticketidfk, reservationidfk) 
            VALUES (seat_id, show_id, 'AVAILABLE', NULL, NULL);
            SET seat_id = seat_id + 1;
        END WHILE;
        SET show_id = show_id + 1;
    END WHILE;

END $$

DELIMITER ;

CALL InsertBookedSeats();