USE kinoxp;

-- Indsæt primære entiteter
INSERT INTO image (name, image, saved) VALUES 
('movie_poster_1','imagenummer1','2025-03-04'), 
('movie_poster_2.jpg','imagenummer2','2025-03-01');

INSERT INTO customer (full_name, email) VALUES 
('John Doe', 'john@example.com'),
('Jane Smith', 'jane@example.com');

INSERT INTO ticket (ticket_type, price) VALUES 
('Adult', 100.00), 
('Student', 80.00), 
('Child', 50.00);

-- Indsæt afhængige entiteter
INSERT INTO movie (title, genre, duration_min, age_restriction, trailer_link, description, review_link, imageidfk) VALUES 
('Action Movie', 'ACTION', 120, 'PG_16', 'https://trailer.com/action', 'An action-packed adventure', 'https://review.com/action', 1),
('Comedy Movie', 'COMEDY', 90, 'PG_7', 'https://trailer.com/comedy', 'A hilarious comedy', 'https://review.com/comedy', 2);

INSERT INTO theater (theater_name, total_amount_of_rows, seats_per_row) VALUES 
('Sal 1', 25, 16), 
('Sal 2', 20, 12);

-- Indsæt afhængige entiteter
INSERT INTO Seat (theateridfk, seat_row, seat_number, blocked) VALUES 
(1, '1', 1, FALSE), 
(1, '1', 2, FALSE),
(1, '1', 3, FALSE),
(1, '1', 4, FALSE),
(1, '1', 5, FALSE),
(1, '1', 6, FALSE),
(1, '1', 7, FALSE),
(1, '1', 8, FALSE),
(1, '1', 9, FALSE), 
(1, '1', 10, FALSE),
(1, '1', 11, FALSE),
(1, '1', 12, FALSE),
(1, '1', 13, FALSE),
(1, '1', 14, FALSE),
(1, '1', 15, FALSE),
(1, '1', 16, FALSE),
(1, '2', 1, FALSE), 
(1, '2', 2, FALSE),
(1, '2', 3, FALSE),
(1, '2', 4, FALSE),
(1, '2', 5, FALSE),
(1, '2', 6, FALSE),
(1, '2', 7, FALSE),
(1, '2', 8, FALSE),
(1, '2', 9, FALSE), 
(1, '2', 10, FALSE),
(1, '2', 11, FALSE),
(1, '2', 12, FALSE),
(1, '2', 13, FALSE),
(1, '2', 14, FALSE),
(1, '2', 15, FALSE),
(1, '2', 16, FALSE),
(2, '1', 1, FALSE), 
(2, '1', 2, FALSE),
(2, '1', 3, FALSE),
(2, '1', 4, FALSE),
(2, '1', 5, FALSE),
(2, '1', 6, FALSE),
(2, '1', 7, FALSE),
(2, '1', 8, FALSE),
(2, '1', 9, FALSE), 
(2, '1', 10, FALSE),
(2, '1', 11, FALSE),
(2, '1', 12, FALSE),
(2, '2', 1, FALSE), 
(2, '2', 2, FALSE),
(2, '2', 3, FALSE),
(2, '2', 4, FALSE),
(2, '2', 5, FALSE),
(2, '2', 6, FALSE),
(2, '2', 7, FALSE),
(2, '2', 8, FALSE),
(2, '2', 9, FALSE), 
(2, '2', 10, FALSE),
(2, '2', 11, FALSE),
(2, '2', 12, FALSE);

INSERT INTO show_table (theateridfk, movieidfk, start_time) VALUES 
(1, 1, '2025-03-04 18:00:00'),
(1, 1, '2025-03-04 20:00:00'),
(2, 2, '2025-03-04 18:00:00'),
(2, 2, '2025-03-04 20:00:00');

-- Indsæt reservation og bookede pladser
INSERT INTO reservation (customeridfk, time_stamp_reservation, total_price) VALUES 
(1, '2025-03-01 15:00:00', 180.00),
(2, '2025-03-01 15:00:00', 180.00);

INSERT INTO booked_Seat (seatidfk, showidfk, status, ticketidfk, reservationidfk) VALUES
(1, 1, 'BOOKED', 1, 1),
(2, 1, 'BOOKED', 2, 1),
(8, 2, 'BOOKED', 2, 2),
(9, 2, 'BOOKED', 1, 2);
