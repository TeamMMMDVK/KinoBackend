USE kinoxp;

-- Indsæt primære entiteter
INSERT INTO Image (name, image, saved) VALUES
('image_flow','https://poster.ebillet.dk/FLOW-CITATPLAKAT-2025.large.jpg','2025-03-05'), 
('image_A Complete Unknown','https://poster.ebillet.dk/a-complete-unknown-2025.large.jpg','2025-03-05'), 
('image_theend','https://poster.ebillet.dk/theend2024.hd.jpg','2025-03-05');

INSERT INTO Customer (full_name, email) VALUES
('John Doe', 'john@example.com'),
('Hans Hansen', 'hans@example.com'),
('Ole Olesen', 'ole@example.com'),
('Jane Smith', 'jane@example.com');

-- Insert data into the 'movie' table
INSERT INTO Movie (movieID, title, duration_min, description, trailer_link, review_link, genre, age_restriction, imageidfk) VALUES
                                                                                                                            (1, 'Action Movie', 120.5, 'An exciting action-packed movie.', 'http://example.com/trailer1', 'http://example.com/review1', 'ACTION', 'PG_7', 1),
                                                                                                                            (2, 'Drama Movie', 140.0, 'A touching story of love and loss.', 'http://example.com/trailer2', 'http://example.com/review2', 'DRAMA', 'PG_16', 2);

-- Insert data into the 'theater' table
INSERT INTO Theater (theaterID, theater_name, total_amount_of_rows, seats_per_row) VALUES
                                                                                 (1, 'Main Theater', 10, 15),
                                                                                 (2, 'VIP Theater', 5, 10);

-- Insert data into the 'seat' table
-- Seats for Main Theater
INSERT INTO Seat (seatID, seat_row, seat_number, theateridfk, blocked) VALUES
                                                                         (1, 1, 1, 1, false), (2, 1, 2, 1, false), (3, 1, 3, 1, false), -- More rows for Main Theater ...
                                                                         (150, 10, 15, 1, false);

-- Seats for VIP Theater
INSERT INTO Seat (seatID, seat_row, seat_number, theateridfk, blocked) VALUES
                                                                         (151, 1, 1, 2, false), (152, 1, 2, 2, false), (153, 1, 3, 2, false), -- More rows for VIP Theater ...
                                                                         (200, 5, 10, 2, false);

-- Insert data into the 'show' table
INSERT INTO show_table (showID, start_time, theateridfk, movieidfk) VALUES
                                                                 (1, '2025-03-07 18:00:00', 1, 1), -- Action Movie at Main Theater
                                                                 (2, '2025-03-07 20:00:00', 2, 2); -- Drama Movie at VIP Theater

-- Insert data into the 'reservation' table
INSERT INTO Reservation (reservationID, customeridfk, reserved_at) VALUES
                                                                                (1, 1, '2025-03-07 16:00:00'),
                                                                                (2, 2, '2025-03-07 17:30:00');

INSERT INTO booked_seat(showidfk, seatidfk, status, reservationidfk, price) VALUES
                                                                                (1, 1, 'BOOKED', 1, 12.50),  -- Seat 1 booked for show 1 with Reservation 1, price 12.50
                                                                                (1, 2, 'BOOKED', 1, 12.50),  -- Seat 2 booked for show 1 with Reservation 1, price 12.50
                                                                                (2, 151, 'BOOKED', 2, 15.00), -- Seat 151 booked for show 2 with Reservation 2, price 15.00
                                                                                (2, 152, 'BOOKED', 2, 15.00); -- Seat 152 booked for show 2 with Reservation 2, price 15.00

INSERT INTO Ticket (ticketID, ticket_type, showidfk, seatidfk) VALUES
                                                                  (1, 'Standard', 1, 1),  -- Ticket for show 1, seat 1 (Standard)
                                                                  (2, 'Standard', 1, 2),  -- Ticket for show 1, seat 2 (Standard)
                                                                  (3, 'VIP', 2, 151),     -- Ticket for show 2, seat 151 (VIP)
                                                                  (4, 'VIP', 2, 152);     -- Ticket for show 2, seat 152 (VIP)

UPDATE booked_seat
SET ticket_id = (SELECT ticketID FROM Ticket WHERE showidfk = 1 AND seatidfk = 1)
WHERE showidfk = 1 AND seatidfk = 1;

UPDATE booked_seat
SET ticket_id = (SELECT ticketID FROM Ticket WHERE showidfk = 1 AND seatidfk = 2)
WHERE showidfk = 1 AND seatidfk = 2;

UPDATE booked_seat
SET ticket_id = (SELECT ticketID FROM Ticket WHERE showidfk = 2 AND seatidfk = 151)
WHERE showidfk = 2 AND seatidfk = 151;

UPDATE booked_seat
SET ticket_id = (SELECT ticketID FROM Ticket WHERE showidfk = 2 AND seatidfk = 152)
WHERE showidfk = 2 AND seatidfk = 152;